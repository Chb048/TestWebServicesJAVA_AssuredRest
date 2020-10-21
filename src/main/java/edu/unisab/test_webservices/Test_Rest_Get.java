package edu.unisab.test_webservices;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Test_Rest_Get {
	
	@Test
	public void Rest_Get() {
		
		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		try {
			
		 entrada = new FileInputStream("Url_Rest_Get.properties");
         propiedades.load(entrada);
         System.out.println(propiedades.getProperty("url"));
        
		Response response = RestAssured.get(propiedades.getProperty("url"));
			 
			if (response.getStatusCode() == 200) {
				System.out.println("Status Code is: " + response.getStatusLine());
		        System.out.println(" La Respuesta fue Exitosa \n");			
				}
			else {
				System.out.println("Status Code is: " + response.getStatusLine());
				System.out.println("Existe un fallo ");
			  	 }
			Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");	
			
		} 
		catch(IOException e) {
			System.out.println(e); 
		}
	}
	
}