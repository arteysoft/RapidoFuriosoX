package edu.it.errores;

public class UnauthorizedException extends HTTPErrorCode {
	
	public UnauthorizedException() {
		this.codigoError = 401;
	}
}
