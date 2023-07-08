package edu.it.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.it.errores.HTTPErrorCode;
import edu.it.errores.UnauthorizedException;

public class FiltroToken implements Filter {	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Aca esto es asi. Si viene para /login queda exceptuado");
		
		var reqHTTP = (HttpServletRequest)request;
		var resHTTP = (HttpServletResponse)response;
		
		var path = reqHTTP.getServletPath();
		if (path.equals("/login")) {
			chain.doFilter(request, response);
			return;
		}
		
		System.out.println("De lo contrario, tengo que verificar que venga x-token y validar");
		
		try {
			String token = reqHTTP.getHeader("x-token");
			if (token == null) {
				var strErr = "Se debe enviar la cabecera X-TOKEN";
				throw new UnauthorizedException();
			}
			
			// Aca, NO vamos a utilizar equals, sino que vamos a traer el token
			// validarlo con la libreria
			// y si esta todo ok. Lo dejamos pasar. con el doFilter.
			
			if (token.equals("holis")) {
				chain.doFilter(request, response);
				return;
			}
			
			throw new UnauthorizedException();
		}
		catch (HTTPErrorCode ex) {
			resHTTP.setStatus(ex.getErrorCode());
		}
		catch (Exception ex) {
			resHTTP.setStatus(500);
		}
	}
	
}
