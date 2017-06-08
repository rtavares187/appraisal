package entities.dataset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


import org.apache.commons.lang.builder.EqualsBuilder;

import common.NumberFormatters;


public class Dataset 
{
	// 
	// Atributos
	//
	
	List<String> columns;
	protected TreeSet<Tuple> data = new TreeSet<Tuple>();
	
	//
	// Construtores
	//	
	
	public Dataset(String attributeName)
	{
		columns = new ArrayList<String>();
		columns.add(attributeName);
	}
	
	public Dataset(List<String> columns)
	{
		this.columns = new ArrayList<String>();
		
		for (String attribute : columns) 
		{
			this.columns.add(attribute);
		}
	}
	
	public Dataset(String... columns)
	{
		this.columns = new ArrayList<String>();
		
		for (String attribute : columns) 
		{
			this.columns.add(attribute);
		}
	}

	public Dataset(File targetDatasetFile,String datasetName) throws IOException 
	{
		columns = new ArrayList<String>();
		columns.add(datasetName);
		
		BufferedReader reader = new BufferedReader(new FileReader(targetDatasetFile));
		
		String line;
		
		while((line = reader.readLine()) != null)
		{
			String[] split = line.split("\t");
			
			int id = Integer.parseInt(split[0].split(" = ")[1]);
			double db = Double.parseDouble(split[1]);
			
			Tuple tuple = new Tuple(id,db);
			this.addTuple(tuple);
		}
	}

	
	//
	// Métodos
	//
	
	public void addTuple(Tuple tuple)
	{
		tuple.setColumns(columns);
		data.add(tuple);
	}
	
	public void mergeTuples(Set<Tuple> tuples)
	{
		data.addAll(tuples);
	}
	
	public void mergeDataset(Dataset dataset)
	{
		data.addAll(dataset.data);
	}
	
	public Iterator<Tuple> getTuples()
	{
		return data.iterator();
	}	

	public List<String> getColumns() 
	{
		List<String> newColumns = new ArrayList<String>();
		
		for (String column : columns) 
		{
			newColumns.add(column);
		}
		
		return newColumns;		
	}
	
	public Integer getColumnCount() 
	{
		return columns.size();		
	}
	
	public Integer getTupleCount() 
	{
		return data.size();		
	}
	
	public Dataset removeColumn(String attributeName)
	{
		Dataset removedDataset = new Dataset(attributeName);
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			Tuple newTuple = new Tuple(tuple.getId(),tuple.removeAttribute(attributeName));
			
			removedDataset.addTuple(newTuple);
		}
		
		columns.remove(attributeName);
		
		return removedDataset;
	}
	
	public Dataset copyColumn(String attributeName)
	{
		Dataset copyDataset = new Dataset(attributeName);
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			Tuple newTuple = new Tuple(tuple.getId(),tuple.getValue(attributeName));
			
			copyDataset.addTuple(newTuple);
		}
		
		return copyDataset;
	}

	public Dataset copyDataset()
	{
		List<String> names = new ArrayList<String>();
		
		for (String attribute: columns) 
		{
			names.add(new String(attribute));			
		}
		
		Dataset copyDataset = new Dataset(names);
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			Tuple newTuple = tuple.copyTuple();
			
			copyDataset.addTuple(newTuple);
		}
		
		return copyDataset;
	}
	
	public Dataset copyDataset(List<String> selectedColumns)
	{
		List<String> names = new ArrayList<String>();
		
		for (String column: selectedColumns) 
		{
			names.add(new String(column));			
		}
		
		Dataset copyDataset = new Dataset(names);
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple 		 tuple 		 = iter.next();
			int			 id			 = tuple.getId();
			List<Number> tupleValues = tuple.getValues(selectedColumns);
			
			List<Number> newValues = new ArrayList<Number>();
			
			for (Number number : tupleValues) 
			{
				newValues.add(number);
			}		
			
			Tuple newTuple = new Tuple(id,newValues);
			copyDataset.addTuple(newTuple);
		}
		
		return copyDataset;
	}

	public void listWiseDeletion()
	{
		List<Tuple> deletionTuples = new ArrayList<Tuple>();
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			
			if (tuple.hasNullValues())
				deletionTuples.add(tuple);
		}	
		
		for (Tuple tuple : deletionTuples) 
		{
			data.remove(tuple);
		}	
	}
	
	public void pairWiseDeletion(List<String> attributeNames)
	{
		List<Tuple> deletionTuples = new ArrayList<Tuple>();
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			
			if (tuple.hasNullValues(attributeNames))
				deletionTuples.add(tuple);
		}	
		
		for (Tuple tuple : deletionTuples) 
		{
			data.remove(tuple);
		}
	}
	
	public double[][] toMatrix()
	{
		double[][] matrix = new double[data.size()][columns.size()];
		
		int i=0;
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			
			List<Number> values = tuple.getValues();
			
			for (int j=0 ; j<values.size() ; j++) 
			{
				matrix[i][j] = values.get(j).doubleValue();
			}
			
			i++;
		}	
		
		return matrix;
	}

	public double[][] toMatrixInverse()
	{
		double[][] matrix = new double[columns.size()][data.size()];
		
		int i=0;
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			
			List<Number> values = tuple.getValues();
			
			for (int j=0 ; j<values.size() ; j++) 
			{
				matrix[j][i] = values.get(j).doubleValue();
			}
			
			i++;
		}	
		
		return matrix;
	}

	
	public void toFile(File targetRegressionFile) 
	{
		try 
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(targetRegressionFile));

			for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
			{
				Tuple tuple = iter.next();
		
				writer.append("ID = "+tuple.getId());
				
				List<Number> values = tuple.getValues();
				
				for (Number number : values) 
				{
					writer.append("\t"+number);
				}
				
				writer.append("\n");
			}

			writer.flush();
			writer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String toString()
	{
		String result = "" ;
		
		result+="[ID";
		
		for (String attributeName : columns) 
		{
			result+="|"+attributeName;
		}
		
		result+="]:";
				
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			
			result+="[";
			
			result+="ID="+tuple.getId();
			
			List<Number> values = tuple.getValues();
			
			for (Number number : values) 
			{
				result+=("|"+NumberFormatters.decimalFormatter.format(number));
			}
			
			result+="]";
		}
		
		return result;
	}

	public Dataset[] splitTrainTest(String regressionColumn) 
	{
		Dataset trainDataset = new Dataset(columns);
		Dataset testDataset = new Dataset(columns);
		
		for (Iterator<Tuple> iter = data.iterator(); iter.hasNext();) 
		{
			Tuple tuple = iter.next();
			
			if (tuple.getValue(regressionColumn) == null)
				testDataset.addTuple(tuple.copyTuple());
			else
				trainDataset.addTuple(tuple.copyTuple());
		}
		
		testDataset.removeColumn(regressionColumn);
		
		return new Dataset[]{trainDataset,testDataset};
	}
	
	public double euclidianDistance(Dataset otherDataset)
	{
		ArrayList<Tuple> tuples = new ArrayList<Tuple>(data);
		ArrayList<Tuple> otherTuples = new ArrayList<Tuple>(otherDataset.data);
		
		int tupleIndex = 0;
		int otherTupleIndex = 0;
		
		int tupleCount = 0;
		double distance = 0;
				
		while (otherTupleIndex < otherDataset.getTupleCount()) 
		{
			Tuple tuple = tuples.get(tupleIndex);
			Tuple otherTuple = otherTuples.get(otherTupleIndex);
			
			if (tuple.getId() == otherTuple.getId())
			{
				distance += calculateEuclidianDistance(tuple,otherTuple);
				
				tupleCount++;
				otherTupleIndex++;
			}
			else if (tuple.getId() < otherTuple.getId())
			{
				tupleIndex++;
			}
			else
			{
				otherTupleIndex++;
			}
		}
		
		return (double)distance/tupleCount;
	}
	
	public double relativeDeviation(Dataset otherDataset) 
	{
		ArrayList<Tuple> tuples = new ArrayList<Tuple>(data);
		ArrayList<Tuple> otherTuples = new ArrayList<Tuple>(otherDataset.data);
		
		int tupleIndex = 0;
		int otherTupleIndex = 0;
		
		int tupleCount = 0;
		double deviation = 0;
				
		while (otherTupleIndex < otherDataset.getTupleCount()) 
		{
			Tuple tuple = tuples.get(tupleIndex);
			Tuple otherTuple = otherTuples.get(otherTupleIndex);
			
			if (tuple.getId() == otherTuple.getId())
			{
				deviation += calculateRelativeDeviation(tuple,otherTuple);
				
				tupleCount++;
				otherTupleIndex++;
			}
			else if (tuple.getId() < otherTuple.getId())
			{
				tupleIndex++;
			}
			else
			{
				otherTupleIndex++;
			}
		}
		
		return (double)deviation/tupleCount;
	}	
	
	public double relativeDeviation(Dataset otherDataset, double errorE) 
	{
		ArrayList<Tuple> tuples = new ArrayList<Tuple>(data);
		ArrayList<Tuple> otherTuples = new ArrayList<Tuple>(otherDataset.data);
		
		int tupleIndex = 0;
		int otherTupleIndex = 0;
		
		int tupleCount = 0;
		double deviation = 0;
				
		while (otherTupleIndex < otherDataset.getTupleCount()) 
		{
			Tuple tuple = tuples.get(tupleIndex);
			Tuple otherTuple = otherTuples.get(otherTupleIndex);
			
			if (tuple.getId() == otherTuple.getId())
			{
				deviation += calculateRelativeDeviation(tuple,otherTuple,errorE);
				
				tupleCount++;
				otherTupleIndex++;
			}
			else if (tuple.getId() < otherTuple.getId())
			{
				tupleIndex++;
			}
			else
			{
				otherTupleIndex++;
			}
		}
		
		return (double)deviation/tupleCount;
	}
	
	public double distance(Dataset otherDataset)
	{
		ArrayList<Tuple> tuples = new ArrayList<Tuple>(data);
		ArrayList<Tuple> otherTuples = new ArrayList<Tuple>(otherDataset.data);
		
		int tupleIndex = 0;
		int otherTupleIndex = 0;
		
		int tupleCount = 0;
		double distance = 0;
				
		while (otherTupleIndex < otherDataset.getTupleCount()) 
		{
			Tuple tuple = tuples.get(tupleIndex);
			Tuple otherTuple = otherTuples.get(otherTupleIndex);
			
			if (tuple.getId() == otherTuple.getId())
			{
				distance += calculateDistance(tuple,otherTuple);
				
				tupleCount++;
				otherTupleIndex++;
			}
			else if (tuple.getId() < otherTuple.getId())
			{
				tupleIndex++;
			}
			else
			{
				otherTupleIndex++;
			}
		}
		
		return (double)distance/tupleCount;
	}
	
	public double meanSquareError(Dataset otherDataset)
	{
		ArrayList<Tuple> tuples = new ArrayList<Tuple>(data);
		ArrayList<Tuple> otherTuples = new ArrayList<Tuple>(otherDataset.data);
		
		int tupleIndex = 0;
		int otherTupleIndex = 0;
		
		int tupleCount = 0;
		double distance = 0;
				
		while (otherTupleIndex < otherDataset.getTupleCount()) 
		{
			Tuple tuple = tuples.get(tupleIndex);
			Tuple otherTuple = otherTuples.get(otherTupleIndex);
			
			if (tuple.getId() == otherTuple.getId())
			{
				distance += calculateMeanSquareError(tuple,otherTuple);
				
				tupleCount++;
				otherTupleIndex++;
			}
			else if (tuple.getId() < otherTuple.getId())
			{
				tupleIndex++;
			}
			else
			{
				otherTupleIndex++;
			}
		}
		
		return (double)distance/tupleCount/100;
	}
	
	public double maxMinDistance(Dataset otherDataset)
	{
		ArrayList<Tuple> tuples = new ArrayList<Tuple>(data);
		ArrayList<Tuple> otherTuples = new ArrayList<Tuple>(otherDataset.data);
		
		List<Number> maxValues = getMaxValues(tuples);
		List<Number> minValues = getMinValues(tuples);
		
		int tupleIndex = 0;
		int otherTupleIndex = 0;
		
		int tupleCount = 0;
		double distance = 0;
				
		while (otherTupleIndex < otherDataset.getTupleCount()) 
		{
			Tuple tuple = tuples.get(tupleIndex);
			Tuple otherTuple = otherTuples.get(otherTupleIndex);
			
			if (tuple.getId() == otherTuple.getId())
			{
				distance += calculateMaxMinDistance(tuple,otherTuple,maxValues,minValues);
				
				tupleCount++;
				otherTupleIndex++;
			}
			else if (tuple.getId() < otherTuple.getId())
			{
				tupleIndex++;
			}
			else
			{
				otherTupleIndex++;
			}
		}
		
		return (double)distance/tupleCount*100;
	}
	
	private double calculateMeanSquareError(Tuple tuple, Tuple otherTuple)
	{
		List<Number> queryAttributes = otherTuple.getValues();
		List<Number> sampleAttributes = tuple.getValues();
				
		double squareDistance = 0;
		 
		for (int i = 0; i < queryAttributes.size(); i++) 
		{
			double queryAttr  = (Double)queryAttributes.get(i);
			double sampleAttr = (Double)sampleAttributes.get(i);
			
			squareDistance += (sampleAttr - queryAttr) * (sampleAttr - queryAttr);			
		}		
		
		return squareDistance/queryAttributes.size();
	}
	
	private double calculateRelativeDeviation(Tuple tuple,Tuple otherTuple) 
	{
		List<Number> values = tuple.getValues();
		List<Number> otherValues = otherTuple.getValues();
		
		double absoluteDeviation = 0;
		 
		for (int i = 0; i < values.size(); i++) 
		{
			double value = (Double)values.get(i);
			double otherValue = (Double)otherValues.get(i);
			
			absoluteDeviation = (value-otherValue)/(value);
		}
		
		double deviation = absoluteDeviation/values.size()*100;

		// Operação de módulo
		return (deviation<0?deviation*-1:deviation);	
	}
	
	private double calculateRelativeDeviation(Tuple tuple, Tuple otherTuple, double errorE) 
	{
		List<Number> values = tuple.getValues();
		List<Number> otherValues = otherTuple.getValues();
		
		double absoluteDeviation = 0;
		 
		for (int i = 0; i < values.size(); i++) 
		{
			double value = (Double)values.get(i);
			double otherValue = (Double)otherValues.get(i);
			
			absoluteDeviation = (value-otherValue)/(value+errorE);
		}
		
		double deviation = absoluteDeviation/values.size()*100;

		// Operação de módulo
		return (deviation<0?deviation*-1:deviation);
	}
	
	private double calculateEuclidianDistance(Tuple tuple,Tuple otherTuple)
	{
		List<Number> queryAttributes = otherTuple.getValues();
		List<Number> sampleAttributes = tuple.getValues();
		
		/* 
		 * Distância Euclidiana
		 * 
		 * d^2 = (sample1 - query1)^2 + (sample2 - query2)^2 + ... + (sampleN - queryN )^2  
		 * 
		 * http://en.wikipedia.org/wiki/Euclidean_distance
		 * http://people.revoledu.com/kardi/tutorial/Similarity/EuclideanDistance.html
		 */
		
		double squareDistance = 0;
		 
		for (int i = 0; i < queryAttributes.size(); i++) 
		{
			double queryAttr  = (Double)queryAttributes.get(i);
			double sampleAttr = (Double)sampleAttributes.get(i);
			
			squareDistance += (sampleAttr - queryAttr) * (sampleAttr - queryAttr);			
		}		
				
		return Math.sqrt(squareDistance);
	}
	
	private double calculateDistance(Tuple tuple,Tuple otherTuple)
	{
		List<Number> queryAttributes = otherTuple.getValues();
		List<Number> sampleAttributes = tuple.getValues();
		
		double distance = 0;
		 
		for (int i = 0; i < queryAttributes.size(); i++) 
		{
			double queryAttr  = (Double)queryAttributes.get(i);
			double sampleAttr = (Double)sampleAttributes.get(i);
			
			double d = (sampleAttr - queryAttr);
			
			if (d < 0)
				d = d*-1;

			//System.out.println("MOD("+NumberFormatters.decimalFormatter.format(sampleAttr)+"-"+NumberFormatters.decimalFormatter.format(queryAttr)+")="+NumberFormatters.decimalFormatter.format(d));
			
			distance+=d;
		}		
				
		return distance/queryAttributes.size();
	}
	
	private double calculateMaxMinDistance(Tuple tuple, Tuple otherTuple, List<Number> maxValues, List<Number> minValues) 
	{
		List<Number> queryAttributes = otherTuple.getValues();
		List<Number> sampleAttributes = tuple.getValues();
		
		double distance = 0;
		 
		for (int i = 0; i < queryAttributes.size(); i++) 
		{
			double queryAttr  = (Double)queryAttributes.get(i);
			double sampleAttr = (Double)sampleAttributes.get(i);
			double maxAttr 	  = (Double)maxValues.get(i);
			double minAttr 	  = (Double)minValues.get(i);
			
			double d =  (queryAttr - sampleAttr) / (maxAttr - minAttr); 
				
			if (d < 0)
				d = d*-1;
			
			/*System.out.println("MOD("+NumberFormatters.decimalFormatter.format(sampleAttr)+
					           "-"+
					           NumberFormatters.decimalFormatter.format(queryAttr)+
					           ") / ("+
					           NumberFormatters.decimalFormatter.format(maxAttr)+
					           "-"+
					           NumberFormatters.decimalFormatter.format(minAttr)+
					           ")="+
					           NumberFormatters.decimalFormatter.format(d*100)+"%");
			*/
			distance+=d;
		}		
				
		return distance/queryAttributes.size();		
	}
	
	private List<Number> getMaxValues(ArrayList<Tuple> tuples) 
	{
		List<Number> maxAttributes = tuples.get(0).copyTuple().getValues();
		
		for (Tuple tuple : tuples) 
		{
			List<Number> tupleAttributes = tuple.getValues();
			
			for (int i = 0; i < tupleAttributes.size(); i++) 
			{
				double maxAttr  = (Double)maxAttributes.get(i);
				double tupleAttr = (Double)tupleAttributes.get(i);
				
				if (tupleAttr > maxAttr)
				{
					maxAttributes.set(i, tupleAttr);
				}
			}		
		}
		
		return maxAttributes;	
	}
	
	private List<Number> getMinValues(ArrayList<Tuple> tuples) 
	{
		List<Number> minAttributes = tuples.get(0).getValues();
		
		for (Tuple tuple : tuples) 
		{
			List<Number> tupleAttributes = tuple.getValues();
			
			for (int i = 0; i < tupleAttributes.size(); i++) 
			{
				double maxAttr  = (Double)minAttributes.get(i);
				double tupleAttr = (Double)tupleAttributes.get(i);
				
				if (tupleAttr < maxAttr)
				{
					minAttributes.set(i, tupleAttr);
				}
			}		
		}
		
		return minAttributes;	
	}

	public boolean equals(final Object other) {
		if (!(other instanceof Dataset))
			return false;
		Dataset castOther = (Dataset) other;
		return new EqualsBuilder().append(columns, castOther.columns).append(
				data, castOther.data).isEquals();
	}

	public boolean isEmpty() 
	{
		return data.isEmpty();
	}
	
	public static void main(String[] args)
	{
		Dataset d1 = new Dataset("a");
		d1.addTuple(new Tuple(0,10d));
		d1.addTuple(new Tuple(1,20d));
		d1.addTuple(new Tuple(2,40d));
						
		Dataset d2 = new Dataset("b");
		d2.addTuple(new Tuple(0,5d));
		d2.addTuple(new Tuple(1,10d));
		d2.addTuple(new Tuple(2,20d));
		
		System.out.println(d1.meanSquareError(d2));
		System.out.println(Math.sqrt(d1.meanSquareError(d2)));
	}
}