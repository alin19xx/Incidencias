/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaincidencias;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.bson.Document;
import org.bson.json.JsonParseException;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import controlador.Controlador;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alexlin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    	Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
    	rootLogger.setLevel(Level.OFF);
    	

    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 int opcion = 0;
    	 Controlador controlador = new Controlador();
    	 
    	
    	do {
            System.out.println("\n          *Incidencias MongoDB*\n------------------------------");
            System.out.println("1-.Insertar Empleado");
            System.out.println("2-.Modificar Empleado");
            System.out.println("3-.Borrar Empleado");
            System.out.println("4-.Ver Incidencfias por ID");
            System.out.println("5-.Ver Incidencias");
            System.out.println("6-.Insertar Incidencias");
            System.out.println("7-.Ver Incidencias por Destino");
            System.out.println("8-.Ver Insidencias por Origen");
            System.out.println("9-.Insertar Evento");
            System.out.println("10-.Ver Ultimo inicio sesion");
            System.out.println("11-.Ver Ranking Empleados");
            System.out.println("0-.Salir");
           

            try {
                try {
					opcion = Integer.parseInt(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } catch (NumberFormatException nfe) {

            }

            switch (opcion) {

                case 1: {
                   controlador.insertEmpleado();
                    break;
                }
                case 2: {
                	controlador.updateEmpleado();
                    break;
                }
                case 3: {
                	controlador.removeEmpleado();
                    break;
                }
                case 4: {
                   controlador.getIncidenciaById();
                    break;
                }
                case 5: {
                    controlador.selectAllIncidencias();;
                     break;
                 }
                case 6: {
                    controlador.insertIncidencia();
                     break;
                 }
                case 7: {
                     controlador.getIncidenciaByDestino();
                     break;
                 }
                case 8: {
                    controlador.getIncidenciaByOrigen();
                     break;
                 }
                case 9: {
                    controlador.insertarEvento();
                     break;
                 }
                case 10: {
                    controlador.getUltimoInicioSesion();
                     break;
                 }
                case 11: {
                    controlador.getRankingEmpleados();
                     break;
                 }
             
                case 0: {
                    System.err.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Opcion incorrecta");

                }

            }

        } while (opcion != 5);

    }

    }
    

