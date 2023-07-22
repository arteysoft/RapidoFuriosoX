package edu.it;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import edu.it.model.InputConsultaOpciones;
import edu.it.model.PrecioVolatilidad;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class App {
	private static void llamadaServicio(InputConsultaOpciones inputConsultaOpciones) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
      		  .build();
      		MediaType mediaType = MediaType.parse("application/json");
      		// RequestBody body = RequestBody.create(mediaType, "{\r\n    \"tipo\":\"call\",\r\n    \"vencimiento\":\"ago\",\r\n    \"precio\":\"15.37\",\r\n    \"strike\":\"10000\",\r\n    \"ccl\":\"539\"\r\n}");
      		RequestBody body = RequestBody.create(mediaType, new Gson().toJson(inputConsultaOpciones));
      		Request request = new Request.Builder()
      		  .url("http://localhost:8080/api/opciones")
      		  .method("POST", body)
      		  .addHeader("Content-Type", "application/json")
      		  .build();
      		
      		Response response = client.newCall(request).execute();
      		
      		System.out.println(response.code());
      		String respuestaJson = response.body().string(); 
      		
      		
      		var res = new Gson().fromJson(respuestaJson, PrecioVolatilidad[].class);
      		
      		for (var pv : res) {
      			System.out.print(pv.precio);
      			System.out.print(" - ");
      			System.out.print(pv.volatilidad);
      			System.out.println("----------------------");
      		}
	}
    public static void main(String[] args) throws Exception {
        System.out.println("Curso patrones - Bienvenidos");
        
        Double precio = 15.37;
        
        for (int z : new int[10]) {
        	precio = precio + 0.1;
        	
        	llamadaServicio(
        			InputConsultaOpciones
        						.build()
        						.setTipo("call")
        						.setVencimiento("ago")
        						.setPrecio("15.37")
        						.setStrike("10000")
        						.setCcl("539")
        						.listo()
        			);
        	
        	Thread.sleep(10000);
        }
    }
}
