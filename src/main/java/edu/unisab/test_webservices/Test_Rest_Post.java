package edu.unisab.test_webservices;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.internal.util.IOUtils;
import static io.restassured.RestAssured.*;




public class Test_Rest_Post {

	@Test
	public void Rest_Post() {
		
	
			Properties propiedades = new Properties();
			InputStream entrada = null;
			
			try {
				
			 entrada = new FileInputStream("Url_Rest_Post.properties");
				propiedades.load(entrada);
			
				System.out.println(propiedades.getProperty("url"));
				
				FileInputStream fileproperties = new FileInputStream ("Request_Rest_Post.properties");

			    Response  response=	
						
				given().
				    header("Content-Type","application/json").
				    contentType(ContentType.JSON).                        
				    accept(ContentType.JSON).body(IOUtils.toByteArray(fileproperties)).
				when().
					post(propiedades.getProperty("url")).
				then().
				log().status().extract().response();
				 
				if (response.getStatusCode() == 201) { 
					Assert.assertEquals(response.getStatusLine(), response.getStatusLine());
		 			System.out.println("Se Creo Correctamente !!! \n ");
				}
				else if (response.getStatusCode() == 200) {
					Assert.assertEquals(response.getStatusLine(), response.getStatusLine());
					System.out.println("Petición Correctamente!! \n");
		 		}
				else {
		 			Assert.fail(response.getStatusLine());
		 			System.out.println("Error en la Petición !!!");
				}
			}

			catch(IOException e) {
				System.out.println(e); 
			}
		}

	}
