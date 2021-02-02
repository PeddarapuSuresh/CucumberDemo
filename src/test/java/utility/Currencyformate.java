package utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Currencyformate {
	
	public static double currencytype(double n) {
	
        NumberFormat formateUS = NumberFormat.getInstance(new Locale("en", "US"));
        String val = formateUS.format(n);

        System.out.println(val);
        
		return n;

       
	}
	
	public static String convertCurrencyToNbr(final String amount) throws Exception {
		try {
			
			final NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
			if(format instanceof DecimalFormat) {
				((DecimalFormat) format).setParseBigDecimal(true);
			}
			
			return format.parse(amount.replaceAll("[^\\d.,]","")).toString();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		double n = 23329.50;
		currencytype(n);
		
		System.out.println(convertCurrencyToNbr("$23,329.50"));
	}

}
