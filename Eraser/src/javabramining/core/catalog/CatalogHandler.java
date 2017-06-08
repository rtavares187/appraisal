/*
 * Projeto JavaBraMining
 * NUPAC - UNIVERCIDADE
 *  
 * Desenvolvedor:
 * 	Rafael Castaneda Ribeiro
 * 
 * Orientadores:
 * 	Prof. Cláudia Ferlin	
 * 	Prof. Ronaldo Ribeiro Goldschmitd
 * 
 */

package javabramining.core.catalog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javabramining.core.catalog.metadata.ComponentInfo;
import javabramining.core.catalog.metadata.KDDInfo;
import javabramining.core.catalog.metadata.MinComponentInfo;
import javabramining.core.catalog.metadata.OperationInfo;
import javabramining.core.catalog.metadata.PosComponentInfo;
import javabramining.core.catalog.metadata.PreComponentInfo;
import javabramining.core.catalog.metadata.StageInfo;
import javabramining.core.context.JBraminingContext;
import javabramining.core.parser.Parser;
import javabramining.core.parser.generated.JBraminingDefinition;
import javabramining.core.parser.generated.MinKddComponentDefinition;
import javabramining.core.parser.generated.MinOperationDefinition;
import javabramining.core.parser.generated.MiningDefinition;
import javabramining.core.parser.generated.PosKddComponentDefinition;
import javabramining.core.parser.generated.PosOperationDefinition;
import javabramining.core.parser.generated.PosProcessingDefinition;
import javabramining.core.parser.generated.PreKddComponentDefinition;
import javabramining.core.parser.generated.PreOperationDefinition;
import javabramining.core.parser.generated.PreProcessingDefinition;

import javax.xml.bind.JAXBException;

/**
 *	Classe Catalogo
 *
 *	TODO: Documentar Classe
 *
 *	@author: rafaelcastaneda@brfree.com.br
 *
 *	Data de Criação:
 *	Data de Modificação:
 */

public class CatalogHandler 
{
	//
	// Fields
	//
	
	private static KDDInfo kddInfo;
	
	private static Map<String,ComponentInfo> componentsMap = new HashMap<String,ComponentInfo>();
	private static Map<String,OperationInfo> operationsMap = new HashMap<String,OperationInfo>();

	//
	// Singleton
	//
	
	public static CatalogHandler getInstance()
	{
		return (CatalogHandler) JBraminingContext.getBean("catalogHandler");
	}
	
	//
	// Constructors
	//
	
	@SuppressWarnings("unchecked")
	public CatalogHandler() throws JAXBException,CatalogHandlerException
	{
		// XML Definition
		JBraminingDefinition jbDefinition = Parser.parse(); 
		
		// Metadata Definition
		kddInfo	= new KDDInfo();
		
		//////////////////////////////////////////////////////////////////////
		// 1. PRE_PROCESSING STAGE							 				//
		//////////////////////////////////////////////////////////////////////
						
		// XML Definition
		PreProcessingDefinition pre = jbDefinition.getPreprocessing();
		
		// Metadata Definition
		StageInfo stageInfo = kddInfo.getStage(StageInfo.PRE_PROCESSING);
		
		//////////////////////////////////////////////////////////
		// 1.1 OPERATIONS								 		//
		//////////////////////////////////////////////////////////
		
		// XML Definition
		List<PreOperationDefinition>  preOpList = pre.getOperation();
		
		for (PreOperationDefinition preOp : preOpList) 
		{
			// Metadata Definition
			OperationInfo opInfo = new OperationInfo(preOp.getName(),stageInfo);
			
			addOperation(opInfo.getName(),opInfo);
			stageInfo.addOperation(opInfo);
			
			//////////////////////////////////////////////////////////
			// 1.2 METHODS							 				//
			//////////////////////////////////////////////////////////
			
			// XML Definition
			List<PreKddComponentDefinition> preCkList = preOp.getKddcomponent();
			
			for (PreKddComponentDefinition preCk : preCkList) 
			{
				// Metadata Definition
				ComponentInfo ckInfo = new PreComponentInfo(preCk.getName(),preCk.getKddscreen(),preCk.getKddmethod(),opInfo);
				
				addComponent(ckInfo.getName(),ckInfo);
				opInfo.addComponent(ckInfo);
			}
		}

		//////////////////////////////////////////////////////////////////////
		// 2. MINING STAGE							 						//
		//////////////////////////////////////////////////////////////////////
		
		// XML Definition
		MiningDefinition min = jbDefinition.getMining();
		
		// Metadata Definition
		stageInfo = kddInfo.getStage(StageInfo.MINING);
		
		//////////////////////////////////////////////////////////
		// 1.1 OPERATIONS								 		//
		//////////////////////////////////////////////////////////
		
		// XML Definition
		List<MinOperationDefinition>  minOpList = min.getOperation();
		
		for (MinOperationDefinition minOp : minOpList) 
		{
			// Metadata Definition
			OperationInfo opInfo = new OperationInfo(minOp.getName(),stageInfo);
			
			addOperation(opInfo.getName(),opInfo);
			stageInfo.addOperation(opInfo);
			
			//////////////////////////////////////////////////////////
			// 1.2 METHODS							 				//
			//////////////////////////////////////////////////////////
			
			// XML Definition
			List<MinKddComponentDefinition>  minCkList = minOp.getKddcomponent();
			
			for (MinKddComponentDefinition minCk : minCkList) 
			{
				// Metadata Definition
				ComponentInfo ckInfo = new MinComponentInfo(minCk.getName(),minCk.getKddscreen(),minCk.getKddmethod(),minCk.getDataType(),opInfo);
				
				addComponent(ckInfo.getName(),ckInfo);
				opInfo.addComponent(ckInfo);
			}
		}
		
		//////////////////////////////////////////////////////////////////////
		// 1. POS_PROCESSING STAGE							 				//
		//////////////////////////////////////////////////////////////////////
						
		// XML Definition
		PosProcessingDefinition pos = jbDefinition.getPosprocessing();
		
		// Metadata Definition
		stageInfo = kddInfo.getStage(StageInfo.POS_PROCESSING);
		
		//////////////////////////////////////////////////////////
		// 1.1 OPERATIONS									 	//
		//////////////////////////////////////////////////////////
		
		// XML Definition
		List<PosOperationDefinition>  posOpList = pos.getOperation();
		
		for (PosOperationDefinition posOp : posOpList) 
		{
			// Metadata Definition
			OperationInfo opInfo = new OperationInfo(posOp.getName(),stageInfo);
			
			addOperation(opInfo.getName(),opInfo);
			stageInfo.addOperation(opInfo);
			
			//////////////////////////////////////////////////////////
			// 1.2 METHODS										 	//
			//////////////////////////////////////////////////////////
			
			// XML Definition
			List<PosKddComponentDefinition> posCkList = posOp.getKddcomponent();
			
			for (PosKddComponentDefinition posCk : posCkList) 
			{
				// Metadata Definition
				ComponentInfo ckInfo = new PosComponentInfo(posCk.getName(),posCk.getKddscreen(),posCk.getKddmethod(),posCk.getResultType(),opInfo);
				
				addComponent(ckInfo.getName(),ckInfo);
				opInfo.addComponent(ckInfo);
			}
		}
	}
	
	//
	// Methods
	//

	public void addComponent(String componentName,ComponentInfo component) throws CatalogHandlerException
	{
		if (componentsMap.containsKey(componentName))
		{
			throw new CatalogHandlerException("Duplicate entry for kddcomponent name: '"+componentName+"'");
		}
		
		componentsMap.put(componentName,component);
	}
	
	public void addOperation(String operationName,OperationInfo operation) throws CatalogHandlerException
	{
		if (operationsMap.containsKey(operationName))
		{
			throw new CatalogHandlerException("Duplicate entry for operation name: '"+operationName+"'");
		}
		
		operationsMap.put(operationName,operation);
	}
	
	public  String getComponentMethodPath(String componentName) 
	{
		return(getComponent(componentName).getKddMethodPath());
	}
	
	public  String getComponentScreenPath(String componentName) 
	{
		return(getComponent(componentName).getKddScreenPath());	   
	}	
		
	public ComponentInfo getComponent(String componentName)
	{				
		return (componentsMap.get(componentName));
	}
	
	public ComponentInfo[] getComponents(String operationName)
	{
		return (getOperation(operationName).getComponents());
	}
	
	public OperationInfo getOperation(String operationName) 
	{
		return (operationsMap.get(operationName));		
	}
	
	public OperationInfo[] getOperations(String stageName) 
	{		
		return (getStage(stageName).getOperations());
	}
		
	public StageInfo getStage(String stageName) 
	{
		return (kddInfo.getStage(stageName));
	}
	
	public StageInfo[] getStages()
	{
		return (kddInfo.getStages());
	}
}