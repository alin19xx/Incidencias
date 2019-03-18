package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.DAO;
import inputAsker.InputAsker;
import model.Empleado;
import model.Incidencia;

public class Controlador {

	// MongoClient mongoClient = new MongoClient("localhost", 27017);
	// MongoDatabase db = mongoClient.getDatabase("Incidencias");
	public InputAsker inputAsker = new InputAsker();
	public DAO dao = new DAO();

	public void insertEmpleado() {
		dao.connect();
		MongoDatabase db = dao.getDName();
		MongoCollection<Document> coleccion = db.getCollection("Empleado");
		System.out.println("*****  REGISTRO  *****");
		String nombre = InputAsker.pedirCadena("Introduce el nombre");
		String pass = InputAsker.pedirCadena("Introduce la contraseña");
		Empleado empleado = new Empleado();
		// BasicDBObject dbEmpleado = new BasicDBObject();
		Document doc = new Document("usuario", empleado.getCodigo()).append("nombre", nombre).append("pass", pass);
		coleccion.insertOne(doc);
		System.out.println("Empleado introducido correctamente");

	}

	public void removeEmpleado() {

	}

	public void updateEmpleado() {

	}

	public void insertIncidencia() {

	}

	public void getIncidenciaById() {

	}

	public void selectAllIncidencias() {

		dao.connect();
		MongoDatabase db = dao.getDName();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		MongoCollection<Document> coleccion2 = db.getCollection("Incidencia");
		FindIterable findIterable = coleccion2.find();
		Iterator<Document> iterator = findIterable.iterator();
		
		
		
		
		while (iterator.hasNext()) {
			Document document = iterator.next();
			// document.remove("_id");
			Map<String, Object> mapa = new HashMap<>(document);
			// System.out.println(Arrays.toString(mapa.entrySet().toArray()));
			
			
			List incidencias = new ArrayList<>();
			Empleado e1 = new Empleado();
			Empleado e2 = new Empleado();
			String username = (String) mapa.get("remitente");
			String username2 = (String) mapa.get("destinatario");
			e1 = getEmpleadoByUsername(username);
			e2 = getEmpleadoByUsername(username2);
			String fechaString = (String) mapa.get("dateInicio");
			LocalDateTime date = LocalDateTime.parse(fechaString, dateFormat);
		
			
			
			
			

			Incidencia i = new Incidencia();
			i.setTipo((String) mapa.get("tipo"));
			i.setObjeto((String) mapa.get("objeto"));
			i.setRemitente(e1);
			i.setDestinatario(e2);
			i.setFechaInicio(date);
			i.setFechaFin(date);
			
			incidencias.add(i);
			System.out.println(i);

		}
		dao.disconnect();

	}

	public Empleado getEmpleadoByUsername(String username) {
		dao.connect();
		MongoDatabase db = dao.getDName();
		MongoCollection<Document> coleccion = db.getCollection("Empleado");
		FindIterable findIterable = coleccion.find();
		Iterator<Document> iterator = findIterable.iterator();
		Empleado e = null;
		List<Empleado> listado = new ArrayList<>();
		while (iterator.hasNext()) {
			Document document = iterator.next();
			Map<String, Object> mapa = new HashMap<>(document);
			e = new Empleado();
			e.setUsuario((String) mapa.get("usuario"));
			e.setNombre((String) mapa.get("nombre"));
			e.setPassword((String) mapa.get("pass"));
			listado.add(e);
			
		}
		for(int i = 0;i<listado.size();i++) {
			if(listado.get(i).getUsuario()== username) {
				e=listado.get(i);
			}
		}
		return e;
	
	}

//    public void getIncidenciaByDestino() {
//    	dao.connect();
//    	MongoDatabase db = dao.getDName();
//    	MongoCollection<Document> coleccion2 = db.getCollection("Incidencia");
//    	DBObject dbo =  coleccion2.find().first()
//    	String tipo = (String) dbo.get("tipo");
//    	int remitente = (int) dbo.get("remitente");
//    	System.out.println(tipo + " " + remitente);
//    	dao.disconnect();
//    }

	public void getIncidenciaByOrigen() {

	}

	public void insertarEvento() {

	}

	public void getUltimoInicioSesion() {

	}

	public void getRankingEmpleados() {

	}

}
