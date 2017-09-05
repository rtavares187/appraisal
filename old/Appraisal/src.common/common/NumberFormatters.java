package common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberFormatters
{
	public static DecimalFormat decimalFormatter = new DecimalFormat("0.00");
	public static DecimalFormat integerFormatter = new DecimalFormat("#");
	
	static
	{
		DecimalFormatSymbols dfs = decimalFormatter.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		decimalFormatter.setDecimalFormatSymbols(dfs);
	}
}
