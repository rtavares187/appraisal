package classification.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

import entities.dataset.Dataset;
import entities.dataset.Tuple;


public class BkPropAlgorithm implements NeuralNetListener
{
	// Logger
	private static final Log LOGGER = LogFactory.getLog(BkPropClassification.class);
	
	private BkPropModel bkPropModel; 
	
	private volatile boolean active;
	
	protected Monitor  	   monitor;
	protected LinearLayer  input;
	protected SigmoidLayer hidden;
	protected SigmoidLayer output;
    	
	String inputColumns;
	String outputColumns; 
	
	List<String> outputColumnsNames;
	
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
		inputColumns = "";
		int    inputCount   = inputData[0].length;
		
		for (int i = 1; i <= inputCount; i++) 
		{
			if (i != inputCount)
				inputColumns += i+",";
			else
				inputColumns += i;
		}
		
		outputColumns = "";
		int    outputCount   = trainData[0].length;
		
		for (int i = 1; i <= outputCount; i++) 
		{
			if (i != outputCount)
				outputColumns += i+",";
			else
				outputColumns += i;
		}
		
		outputColumnsNames = outputDataset.getColumns();
		
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

		// Cria sinapse de consulta   	
		MemoryInputSynapse querySynapse = new MemoryInputSynapse();
		querySynapse.setInputArray(queryData);
		querySynapse.setAdvancedColumnSelector(inputColumns);
		
		// Insere plugin
		NormalizerPlugIn normalizerPlugin = new NormalizerPlugIn(); 
		normalizerPlugin.setMax(1); 
		normalizerPlugin.setMin(0);
		normalizerPlugin.setDataMax(bkPropModel.getMaxValue()); 
		normalizerPlugin.setDataMin(bkPropModel.getMinValue());
		normalizerPlugin.setAdvancedSerieSelector(inputColumns);
		querySynapse.addPlugIn(normalizerPlugin);
		
		// Cria sinapse de resposta
		MemoryOutputSynapse resultsSynapse = new MemoryOutputSynapse();
		resultsSynapse.setMonitor(monitor);			
				
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
	    
	    Dataset 		resultDataset = new Dataset(outputColumnsNames);
	    Iterator<Tuple> originalTuples = queryDataset.getTuples();    
	    
	    Vector  patterns = resultsSynapse.getAllPatterns();
	    
	    for (int i=0; i<patterns.size(); i++) 
	    {
	    	int id = originalTuples.next().getId();
	    	List<Number> values = new ArrayList<Number>();
	    	
	    	for (Double d : ((Pattern)patterns.get(i)).getArray())
	    	{
	    		values.add((double)Math.round(d));
	    	}	    	
	    	
	    	Tuple resultTuple = new Tuple(id,values);
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
	    
	    if ( c == 0)
	    	LOGGER.debug("0000 cycles remaining - Error = " + mon.getGlobalError());			
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