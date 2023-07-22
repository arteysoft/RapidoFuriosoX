package edu.it.ejemplocallback;

public class Contador implements Runnable {
	private CallBack observador;
	
	public Contador(CallBack obervador) {
		this.observador = obervador;
	}

	public void run() {
		for (int x = 0; x < 1000000; x++) {
			if (x % 111 == 0) {
				observador.onData(x);
			}
		}
		observador.onFinish();
	}
	
}
