package edu.it.utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import edu.it.errores.HTTP500Revento;

public class Utiles {
	public static String leerInputTCP(HttpServletRequest request) {
		try {
			var isreader = new InputStreamReader(request.getInputStream());
			var buffReader = new BufferedReader(isreader);
			
			StringBuilder strBld = new StringBuilder();
			
			for (String linea = buffReader.readLine();linea != null;linea = buffReader.readLine()) {
				strBld.append(linea);
			}
			
			return strBld.toString();
		}
		catch (Exception ex) {
			throw new HTTP500Revento();
		}
	}
}
