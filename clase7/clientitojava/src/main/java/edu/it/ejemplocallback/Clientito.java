package edu.it.ejemplocallback;

public class Clientito implements CallBack {
	public void onData(int x) {
		System.out.println("Se encontro un multiplo de 111 :" + x);
	}
	public void onFinish() {
		System.out.println("Me informan que termino el proceso");
		
	}	
}
