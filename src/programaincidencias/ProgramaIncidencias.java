/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaincidencias;



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

/**
 *
 * @author alexlin
 */
public class ProgramaIncidencias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
    	MongoDatabase db = mongoClient.getDatabase("Incidencias");
    	MongoCollection<Document> coleccion = db.getCollection("Empleado");
    	MongoCollection<Document> coleccion2 = db.getCollection("Incidencia");
    	MongoCollection<Document> coleccion3 = db.getCollection("Evento");
    	List<Document> documentos = (List<Document>) coleccion.find().into(new ArrayList<Document>());
    	List<Document> documentos2 = (List<Document>) coleccion2.find().into(new ArrayList<Document>());
    	List<Document> documentos3 = (List<Document>) coleccion3.find().into(new ArrayList<Document>());
    	
    	documentos.forEach(System.out::println);
    	documentos2.forEach(System.out::println);
    	documentos3.forEach(System.out::println);
//    	for(Document document : documentos) {
//    		System.out.println(document);
//    	}
    	mongoClient.close();
    	
//    	FindIterable<Document> iterDoc = coleccion.find();
//    	MongoCursor<Document> dbc = iterDoc.iterator();
    	
       
        
       
    	
    }
    
}
