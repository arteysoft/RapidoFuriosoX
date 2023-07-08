package edu.it.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FiltroToken implements Filter {	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Aca esto es asi. Si viene para /login queda exceptuado");
		System.out.println("De lo contrario, tengo que verificar que venga x-token y validar");
		
		chain.doFilter(request, response);
	}
	
}
