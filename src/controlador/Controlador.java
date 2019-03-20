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

	/*
	 * NOS HEMOS QUEDADO AQUI TENEMOS QUE INSERTAR LAS INCIDENCIAS TENEMOS QUE
	 * IMPRIMIR AQUI ABAJO LOS EMPLEADOS Y QUE SE ELIJA EL DESTINATARIO
	 */

	public void insertIncidencia() {
		dao.connect();
		MongoDatabase db = dao.getDName();
		MongoCollection<Document> coleccion = db.getCollection("Incidencia");
		List listaEmpleados = new ArrayList<>();
		listaEmpleados = bringBackEmpleados();
		System.out.println("*****  REGISTRO  *****");
		Empleado usuarioLogueado = new Empleado();
		String comentario = InputAsker.pedirCadena("Introduce el comentario");
		for (int i = 0; i < listaEmpleados.size(); i++) {

		}

		String pass = InputAsker.pedirCadena("Introduce la contraseña");
		Empleado empleado = new Empleado();
		// BasicDBObject dbEmpleado = new BasicDBObject();
		Document doc = new Document("usuario", empleado.getCodigo()).append("nombre", nombre).append("pass", pass);
		coleccion.insertOne(doc);
		System.out.println("Empleado introducido correctamente");

	}

	public void getIncidenciaById() {
		String nombre = InputAsker.pedirCadena("Introduce el origen");
		List<Incidencia> incidencias = new ArrayList<>();
		incidencias = bringBackIncidencias();
		for (int i = 0; i < incidencias.size(); i++) {
			if (incidencias.get(i).getRemitente().getUsuario().equalsIgnoreCase(nombre)) {
				System.out.println(incidencias.get(i));
			}
		}

	}

	/*
	 * Metodo que nos devuelve todas las incidencias de la nuestra base de datos
	 * mongo.
	 */
	public void selectAllIncidencias() {

		List incidencias = new ArrayList<>();
		incidencias = bringBackIncidencias();
		incidencias.forEach(System.out::println);

	}

	public List bringBackIncidencias() {
		dao.connect();
		MongoDatabase db = dao.getDName();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy",
		// Locale.ENGLISH);
		MongoCollection<Document> coleccion2 = db.getCollection("Incidencia");
		FindIterable findIterable = coleccion2.find();
		Iterator<Document> iterator = findIterable.iterator();

		List incidencias = new ArrayList<>();
		while (iterator.hasNext()) {
			Document document = iterator.next();
			// document.remove("_id");
			Map<String, Object> mapa = new HashMap<>(document);
			// System.out.println(Arrays.toString(mapa.entrySet().toArray()));

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

		}
		dao.disconnect();
		return incidencias;

	}

	public List bringBackEmpleados() {

		dao.connect();
		MongoDatabase db = dao.getDName();
		MongoCollection<Document> coleccion2 = db.getCollection("Empleado");
		FindIterable findIterable = coleccion2.find();
		Iterator<Document> iterator = findIterable.iterator();
		List empleados = new ArrayList<>();
		while (iterator.hasNext()) {
			Document document = iterator.next();
			Map<String, Object> mapa = new HashMap<>(document);
			Empleado e1 = new Empleado();
			String username = (String) mapa.get("usuario");
			String name = (String) mapa.get("nombre");
			String pass = (String) mapa.get("pass");

			e1.setUsuario(username);
			e1.setNombre(name);
			e1.setPassword(pass);
			empleados.add(e1);

		}
		return empleados;
	}

	/*
	 * Metodo que nos devuelve un empleado a traves de su nombre de usuario.
	 */
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
		for (int i = 0; i < listado.size(); i++) {
			if (listado.get(i).getUsuario().equalsIgnoreCase(username)) {
				e = listado.get(i);
			}
		}
		return e;

	}

	public void getIncidenciaByDestino() {
		String nombre = InputAsker.pedirCadena("Introduce el destinatario");
		List<Incidencia> incidencias = new ArrayList<>();
		incidencias = bringBackIncidencias();
		for (int i = 0; i < incidencias.size(); i++) {
			if (incidencias.get(i).getDestinatario().getUsuario().equalsIgnoreCase(nombre)) {
				System.out.println(incidencias.get(i));
			}
		}

	}

	public void getIncidenciaByOrigen() {
		String nombre = InputAsker.pedirCadena("Introduce el origen");
		List<Incidencia> incidencias = new ArrayList<>();
		incidencias = bringBackIncidencias();
		for (int i = 0; i < incidencias.size(); i++) {
			if (incidencias.get(i).getRemitente().getUsuario().equalsIgnoreCase(nombre)) {
				System.out.println(incidencias.get(i));
			}
		}

	}

	public void insertarEvento() {

	}

	public void getUltimoInicioSesion() {

	}

	public void getRankingEmpleados() {

	}

}
