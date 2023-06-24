package edu.it.errores;

public abstract class HTTPErrorCode extends RuntimeException {
	protected int codigoError;
	
	public int getErrorCode() {
		return this.codigoError;
	}
}
