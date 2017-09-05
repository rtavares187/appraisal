package appraisal.algorithms.bkprop;

import java.util.Iterator;
import java.util.Vector;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joone.engine.FullSynapse;
import org.joone.engine.LinearLayer;
import org.joone.engine.Monitor;
import org.joone.engine.NeuralNetEvent;
import org.joone.engine.NeuralNetListener;
import org.joone.engine.Pattern;
import org.joone.engine.SigmoidLayer;
import org.joone.engine.learning.TeachingSynapse;
import org.joone.io.MemoryInputSynapse;
import org.joone.io.MemoryOutputSynapse;
import org.joone.util.NormalizerPlugIn;
import org.joone.util.UnNormalizerOutputPlugIn;

import entities.dataset.Dataset;
import entities.dataset.Tuple;


public class BkPropAlgorithm implements NeuralNetListener
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(BkPropAlgorithm.class);
	
	private BkPropModel bkPropModel; 
	
	private volatile boolean active;
	
	protected Monitor  	   monitor;
	protected LinearLayer  input;
	protected SigmoidLayer hidden;
	protected SigmoidLayer output;
    	
	public BkPropAlgorithm(BkPropModel bkPropModel)
	{
		// 1. Associa o modelo
		this.bkPropModel = bkPropModel;
		
		// 2. Cria as camadas		
		input  = new LinearLayer();
	    hidden = new SigmoidLayer();
	    output = new SigmoidLayer();
	    
	    input.setRows(bkPropModel.getInputNeurons());
	    hidden.setRows(bkPropModel.getHiddenNeurons());
	    output.setRows(bkPropModel.getOutputNeurons());
	    
	    // 2.1. Cria as sinapses entre as camadas
	    FullSynapse synapse_IH = new FullSynapse(); 
	    FullSynapse synapse_HO = new FullSynapse(); 
	    
	    input.addOutputSynapse(synapse_IH);
	    hidden.addInputSynapse(synapse_IH);
	    
	    hidden.addOutputSynapse(synapse_HO);
	    output.addInputSynapse(synapse_HO);
	    	    
	    // 3. Cria um monitor para a rede
	    monitor = new Monitor();
	    monitor.setLearningRate(bkPropModel.getLearningRate());
	    monitor.setMomentum(bkPropModel.getMomentum());
	    
	    input.setMonitor(monitor);
	    hidden.setMonitor(monitor);
	    output.setMonitor(monitor);
	    
	    monitor.addNeuralNetListener(this);
	}

	public void trainNetwork(Dataset inputDataset,Dataset outputDataset)
	{
		/////////////////////
		// ENTRADA DA REDE //
		/////////////////////
		
		// Monta matriz com os dados
		double[][] inputData = inputDataset.toMatrix();
		double[][] trainData = outputDataset.toMatrix();
		
		// Determina colunas
		String inputColumns = "";
		int    inputCount   = inputData[0].length;
		
		for (int i = 1; i <= inputCount; i++) 
		{
			if (i != inputCount)
				inputColumns += i+",";
			else
				inputColumns += i;
		}
		
		String outputColumns = "";
		int    outputCount   = trainData[0].length;
		
		for (int i = 1; i <= outputCount; i++) 
		{
			if (i != outputCount)
				outputColumns += i+",";
			else
				outputColumns += i;
		}
		
		// Cria sinapse    	
		MemoryInputSynapse inputSynapse = new MemoryInputSynapse();
		inputSynapse.setInputArray(inputData);
		inputSynapse.setAdvancedColumnSelector(inputColumns);
		
		// Insere plugin
		NormalizerPlugIn normalizerPlugin = new NormalizerPlugIn(); 
		normalizerPlugin.setMax(1); 
		normalizerPlugin.setMin(0);
		normalizerPlugin.setDataMax(bkPropModel.getMaxValue()); 
		normalizerPlugin.setDataMin(bkPropModel.getMinValue());
		normalizerPlugin.setAdvancedSerieSelector(inputColumns);
		inputSynapse.addPlugIn(normalizerPlugin);		
		
		// Adiciona na camada de entrada
		input.addInputSynapse(inputSynapse);
	    
		///////////////////
		// SAÍDA DA REDE //
		///////////////////
		
		// Cria pré-sinapse
		MemoryInputSynapse preSynapse = new MemoryInputSynapse();
		preSynapse.setInputArray(trainData);
		preSynapse.setAdvancedColumnSelector(outputColumns);
		
		// Insere plugin
		NormalizerPlugIn normalizerPlugin2 = new NormalizerPlugIn(); 
		normalizerPlugin2.setMax(1); 
		normalizerPlugin2.setMin(0);
		normalizerPlugin2.setDataMax(bkPropModel.getMaxValue()); 
		normalizerPlugin2.setDataMin(bkPropModel.getMinValue());
		normalizerPlugin2.setAdvancedSerieSelector(outputColumns);
		preSynapse.addPlugIn(normalizerPlugin2);
		
		TeachingSynapse trainingSynapse = new TeachingSynapse();
	    trainingSynapse.setDesired(preSynapse);
	    trainingSynapse.setMonitor(monitor);
	    
	    // Adiciona na camada de saída
	    output.addOutputSynapse(trainingSynapse);		    
	    
	    /////////////////////////
	    // TREINAMENTO DA REDE //
	    /////////////////////////
	    
	    monitor.setTrainingPatterns(inputData.length); // outputData
	    
	    input.start();
	    hidden.start();
	    output.start();
	    
	    monitor.setTotCicles(bkPropModel.getCycles()); 
	    monitor.setLearning(true); 
	    monitor.Go(); 
	    
	    active = true;
	    
	    while(active)
	    {
	    	try{Thread.sleep(1000);}catch (InterruptedException e){}
	    }
	}	
	
	public Dataset queryNetwork(Dataset queryDataset)
	{
		/////////////////////
		// ENTRADA DA REDE //
		/////////////////////
		
		// Monta matriz com os dados
		double[][] queryData = queryDataset.toMatrix();

		// Determina colunas
		String columns = "";
		int    count   = queryData[0].length;
		
		for (int i = 1; i <= count; i++) 
		{
			if (i != count)
				columns += i+",";
			else
				columns += i;
		}		
				
		// Cria sinapse de consulta   	
		MemoryInputSynapse querySynapse = new MemoryInputSynapse();
		querySynapse.setInputArray(queryData);
		querySynapse.setAdvancedColumnSelector(columns);
		
		// Insere plugin
		NormalizerPlugIn normalizerPlugin = new NormalizerPlugIn(); 
		normalizerPlugin.setMax(1); 
		normalizerPlugin.setMin(0);
		normalizerPlugin.setDataMax(bkPropModel.getMaxValue()); 
		normalizerPlugin.setDataMin(bkPropModel.getMinValue());
		normalizerPlugin.setAdvancedSerieSelector(columns);
		querySynapse.addPlugIn(normalizerPlugin);
		
		// Cria sinapse de resposta
		MemoryOutputSynapse resultsSynapse = new MemoryOutputSynapse();
		resultsSynapse.setMonitor(monitor);
		
		UnNormalizerOutputPlugIn outputplugin = new UnNormalizerOutputPlugIn();
		outputplugin.setInDataMin(0.0f);
		outputplugin.setInDataMax(1.0f); 
		outputplugin.setOutDataMin(bkPropModel.getMinValue());
		outputplugin.setOutDataMax(bkPropModel.getMaxValue());		
		outputplugin.setAdvancedSerieSelector("1");
		resultsSynapse.addPlugIn(outputplugin);
		
		//
		// Remove sinapses de treinamento, e troca pelas de query e resultado
		//
		
		input.removeAllInputs();
		input.addInputSynapse(querySynapse);
		
		output.removeAllOutputs();
		output.addOutputSynapse(resultsSynapse);
		
	    //
	    // Configura e inicializa rede
	    //
	    
		input.start();
	    hidden.start();
	    output.start();
	    	    
	    monitor.setTrainingPatterns(queryData.length);
	    monitor.setTotCicles(1);
	    monitor.setLearning(false);
	    
	    monitor.Go(); 
	    
	    active = true;
	    
	    while(active)
	    {
		    try{Thread.sleep(200);}catch(InterruptedException e){}
	    }
	    
	    //
	    // Monta resultados
	    //
	    
	    Dataset 		resultDataset = new Dataset("result");
	    Iterator<Tuple> originalTuples = queryDataset.getTuples();    
	    
	    Vector  patterns = resultsSynapse.getAllPatterns();
	    
	    for (int i=0; i<patterns.size(); i++) 
	    {
	    	int id = originalTuples.next().getId();
	    	double value = ((Pattern)patterns.get(i)).getArray()[0];
	    	
	    	Tuple resultTuple = new Tuple(id,value);
	    	resultDataset.addTuple(resultTuple);	    
	    }	    
	    
	    return resultDataset;
	}	
	
	public void cicleTerminated(NeuralNetEvent arg0)
	{
		Monitor mon = (Monitor)arg0.getSource();
	    long c = mon.getCurrentCicle();
	    long cl = c / 1000;
	
	    if ( (cl * 1000) == c )
	    	LOGGER.debug(c + " cycles remaining - Error = " + mon.getGlobalError());
	}
	
	public void errorChanged(NeuralNetEvent arg0) 
	{
	
	}
	
	public void netStarted(NeuralNetEvent arg0) 
	{
		
	}
	
	public void netStopped(NeuralNetEvent arg0) 
	{
		active=false;
	}	
	
	public void netStoppedError(NeuralNetEvent arg0, String arg1)
	{	
	
	}
}