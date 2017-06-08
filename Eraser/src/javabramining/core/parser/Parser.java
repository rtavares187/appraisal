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
 
package javabramining.core.parser;

import java.io.File;

import javabramining.core.parser.generated.JBraminingDefinition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *	Classe Parser
 *
 *	TODO: Documentar Classe
 *
 *	@author: rafaelcastaneda@brfree.com.br
 *
 *	Data de Criação:
 *	Data de Modificação:
 */

public class Parser
{
	public static JBraminingDefinition parse() throws JAXBException 
	{		
		// Inicializando Contexto JABX
		JAXBContext jc = JAXBContext.newInstance("javabramining.core.parser.generated");
		Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setValidating(true);
        
        return((JBraminingDefinition)unmarshaller.unmarshal(new File("jbramining.xml")));
	}
}