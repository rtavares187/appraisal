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

package javabramining.core.kdd;

/**
 *	Classe Componente
 *
 *	TODO: Documentar Classe
 *
 *	@author: rafaelcastaneda@brfree.com.br
 *
 *	Data de Criação:
 *	Data de Modificação:
 */

public interface KDDMethod 
{
	public abstract void run(KDDInput input,KDDOutput output) throws KDDMethodException;    
}

