package utiles;

import java.util.ArrayList;
import java.util.List;

import edu.it.javaweb.components.BlackScholes;
import edu.it.javaweb.components.Constantes;
import edu.it.javaweb.model.InputConsultaOpciones;
import edu.it.javaweb.model.PrecioVolatilidad;

public class Calculadora {
	private static double dosDecimales(double inicial) {
		inicial = inicial * 100d;		
		double retorno = Math.round(inicial);
		return (retorno / 100);
	}
	public static List<PrecioVolatilidad> calcular(InputConsultaOpciones datosInput) {
		var precioVolatilidad = new ArrayList<PrecioVolatilidad>();
		
		char letraCallOrPut = 'c';
		String vencimiento = "";
		double pu$d = 0.0d;
		double strike = 0.0d;
		double ccl = 0d;
		
		try {
			// System.out.println(System.getProperty("tipo"));
			if (datosInput.tipo.equals("call")) {
				letraCallOrPut = 'c';
			}
			else if (datosInput.tipo.equals("put")) {
				letraCallOrPut = 'p';
			}
			else {
				throw new Exception("el tipo debe ser call o put");
			}
			if (datosInput.vencimiento.equals("jun")) {
				vencimiento = "2023-06-15 15:30:00";
			}
			else if (datosInput.vencimiento.equals("ago")) {
				vencimiento = "2023-08-17 15:30:00";
			}
			else if (datosInput.vencimiento.equals("oct")) {
				vencimiento = "2023-10-19 15:30:00";
			}
			else if (datosInput.vencimiento.equals("dic")) {
				vencimiento = "2023-12-15 15:30:00";
			}
			else {
				throw new Exception("vencimiento no implementado");
			}
			
			pu$d = Double.parseDouble(datosInput.precio);
			strike = Double.parseDouble(datosInput.strike);
			ccl = Double.parseDouble(datosInput.ccl);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		
		var diff = BlackScholes.calcDateDiff(vencimiento);
		Double precioDesde = pu$d;
		Double precioHasta = pu$d + 1d;
		
		{
			double valor$ = pu$d * ccl;
			System.out.print("U$S;");
			System.out.printf("%.2f", pu$d);
			System.out.print(";$;");
			System.out.print((long)valor$);
			System.out.print(";Valores Teoricos ");
			System.out.print(System.getProperty("tipo"));
			
			for (double volatility = 0.3; volatility <= 0.8; volatility = volatility + 0.05) {
				System.out.print(";");
				var price = BlackScholes.doCalc(letraCallOrPut, valor$, strike, diff, Constantes.TASA_LIBRE_RIESGO, volatility);				
				System.out.print((long)Math.floor(price));				
				System.out.print(" ");
				price = dosDecimales(price);
				precioVolatilidad.add(new PrecioVolatilidad(dosDecimales(volatility), price));
			}
			System.out.println();
		}
		
		return precioVolatilidad;
	}
}
