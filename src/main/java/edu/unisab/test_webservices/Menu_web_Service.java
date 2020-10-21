package edu.unisab.test_webservices;

import java.util.InputMismatchException;
import java.util.Scanner;

//mvn exec:java -Dexec.mainClass=“edu.unisab.test_webservices.Menu_web_Service”

public class Menu_web_Service  {
 
    public static void main(String[] args) throws Exception {
 
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        Integer opcion;
   
        System.out.println("¿Que tipo de Servicio Web desea validar? Elija una Opción\n");
        
        while (!salir) {
        	
            System.out.println("1.Opción para Automatizar Servicios Get");
            System.out.println("2.Opción para Automatizar Servicios Post");
            System.out.println("3.Opción para Automatizar Servicios SOAP");
            System.out.println("4. Salir\n");
 
            try {
 
                System.out.println("Ingrese una Opción");
                opcion = entrada.nextInt(); 
                	
        
                switch (opcion) {
                    case 1:
                        System.out.println("Esta opción es para automatizar el metodo Get de un servicio web \n");
                        Test_Rest_Get swget = new  edu.unisab.test_webservices.Test_Rest_Get();
                      swget.Rest_Get();
                    break;
                    case 2:
                        System.out.println("Esta opción es para automatizar el metodo Post de un servicio web \n");
                        Test_Rest_Post swpost = new  edu.unisab.test_webservices.Test_Rest_Post();
                        swpost.Rest_Post();
                        break;
                    case 3:
                        System.out.println("Esta opción es para automatizar el Servicio Web SOAP \n");
                        Test_Soap swsoap = new edu.unisab.test_webservices.Test_Soap();
                        swsoap.WebServiceSoap();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Las Opciones solo son del 1 al 4 \n");
                }
            	
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar una Opcion\n");
                entrada.next();
            }
        }   
        entrada.close();
    }
}