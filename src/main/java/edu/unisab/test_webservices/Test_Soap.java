package edu.unisab.test_webservices;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;

public class Test_Soap {


	public void WebServiceSoap() {
		
		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		try {
			
		 entrada = new FileInputStream("Url_Soap.properties");
			propiedades.load(entrada);
			
			System.out.println(propiedades.getProperty("baseURLandPort"));
			System.out.println(propiedades.getProperty("Urlpost"));
			
			FileInputStream fileinputstream = new FileInputStream ("Request_Soap.properties");
			
			RestAssured.baseURI=(propiedades.getProperty("baseURLandPort")); 
			
			Response  response =
		    		   
			   given()
			   .header("Content-Type","text/xml")
			   .and()
			   .body(IOUtils.toByteArray(fileinputstream))
			   .when().post(propiedades.getProperty("Urlpost"))
			   .then()
			   .log().status().extract().response();  
			             
			 	if(response.statusCode() != 200) {
			 		System.out.println("Existe un fallo!!! ");
			 		
			 	}
			 	else {
			 		System.out.println("Peticion Exitosa!!! \n");
			 	}
			 	Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
		} 
		catch(IOException e) {
			System.out.println(e); 
		}
	}

}