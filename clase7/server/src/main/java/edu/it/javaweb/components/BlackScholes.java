package edu.it.javaweb.components;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlackScholes {
	public static double calcDateDiff(String StrikeDate) {
		try {
			var strike = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d2 = strike.parse(StrikeDate);
			Date d1 = new Date();
			long timeDiff = (d2.getTime() - d1.getTime());
			double daysDiff = (double)timeDiff / ((double)(60*60*24*1000));
			
			System.out.print("Dias restantes: ");
			System.out.println(daysDiff);
			
			double years_difference = (daysDiff / 365d);
			return years_difference;
		}
		catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
	public static double doCalc(char CallPutFlag, double S, double X, double T, double r, double v)
	{
	double d1, d2;

	d1=(Math.log(S/X)+(r+v*v/2)*T)/(v*Math.sqrt(T));
	d2=d1-v*Math.sqrt(T);

	if (CallPutFlag=='c')
	{
	return S*CND(d1)-X*Math.exp(-r*T)*CND(d2);
	}
	else
	{
	return X*Math.exp(-r*T)*CND(-d2)-S*CND(-d1);
	}
	}

	// The cumulative normal distribution function
	public static double CND(double X)
	{
	double L, K, w ;
	double a1 = 0.31938153, a2 = -0.356563782, a3 = 1.781477937, a4 = -1.821255978, a5 = 1.330274429;

	L = Math.abs(X);
	K = 1.0 / (1.0 + 0.2316419 * L);
	w = 1.0 - 1.0 / Math.sqrt(2.0 * Math.PI) * Math.exp(-L *L / 2) * (a1 * K + a2 * K *K + a3
	* Math.pow(K,3) + a4 * Math.pow(K,4) + a5 * Math.pow(K,5));

	if (X < 0.0)
	{
	w= 1.0 - w;
	}
	return w;
	}
}
