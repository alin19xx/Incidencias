package controlador;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.DAO;
import inputAsker.InputAsker;
import model.Empleado;
import model.Evento;
import model.Incidencia;

public class Controlador {

	// MongoClient mongoClient = new MongoClient("localhost", 27017);
	// MongoDatabase db = mongoClient.getDatabase("Incidencias");
	public InputAsker inputAsker = new InputAsker();
	public DAO dao = new DAO();
	public static Empleado empleado = new Empleado("", "", "");

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
		int destinatario = 0;
		boolean confirmado = true;
		String tipoIncidencia = "";
		MongoCollection<Document> coleccion = db.getCollection("Incidencia");
		List listaEmpleados = new ArrayList<>();
		listaEmpleados = bringBackEmpleados();
		System.out.println("*****  REGISTRO  *****");
		Empleado usuarioLogueado = new Empleado();
		Empleado elDestinatario = null;
		String comentario = InputAsker.pedirCadena("Introduce el comentario");
		for (int i = 0; i < listaEmpleados.size(); i++) {
			System.out.println((i) + ". " + listaEmpleados.get(i));

		}

		while (confirmado) {
			destinatario = InputAsker.pedirEntero("Elige el destinatario");
			if (destinatario < 0 || destinatario > listaEmpleados.size()) {
				System.out.println("error: Choose a correct numbaer from 0 to " + listaEmpleados.size());
			} else {

				confirmado = false;
			}
		}
		int tipo = InputAsker
				.pedirEntero("Elige el tipo de Incidencia\n" + "Pulsa 1 para normal\n" + "Pulsa 2 para urgente");
		if (tipo == 1) {
			tipoIncidencia = "normal";
		} else {
			insertarEvento(2, empleado.getUsuario());
			tipoIncidencia = "urgente";
		}
		Empleado objetoEmpleado = (Empleado) listaEmpleados.get(destinatario);

		// BasicDBObject dbEmpleado = new BasicDBObject();
		empleado.getUsuario();
		Incidencia incidencia = new Incidencia();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fecha = dateFormat.format(new Date());
		Document doc = new Document();
		doc.append("idIncidencia", incidencia.getCodigo());
		doc.append("remitente", empleado.getUsuario());
		doc.append("objeto", comentario);
		doc.append("dateInicio", fecha);
		doc.append("dateFin", "");
		doc.append("tipo", tipoIncidencia);
		doc.append("destinatario", objetoEmpleado.getUsuario());
		coleccion.insertOne(doc);
		System.out.println("Incidencia introducida correctamente");
		dao.disconnect();
	}

	/*
	 * Metodo que muestra una Incidencia a partir de su ID
	 */
	public void getIncidenciaById() {
		dao.connect();
		MongoDatabase db = dao.getDName();
		boolean confirmado = true;
		int nrIncidenica = 0;

		List<Incidencia> incidencias = new ArrayList<>();

		incidencias = bringBackIncidencias();

		for (int i = 0; i < incidencias.size(); i++) {
			System.out.println((i) + ". " + incidencias.get(i).getId());

		}
		nrIncidenica = InputAsker.pedirEntero("Introduce el id de la incidencia");
		System.out.println(incidencias.get(nrIncidenica));
		dao.disconnect();
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
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String fecha = dateFormat.format(new Date());

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
			String fechaString = mapa.get("dateInicio").toString();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime localDate = LocalDateTime.parse(fechaString, formatter);
			Incidencia i = new Incidencia();
			i.setTipo((String) mapa.get("tipo"));
			i.setObjeto((String) mapa.get("objeto"));
			i.setRemitente(e1);
			i.setDestinatario(e2);
			i.setFechaInicio(localDate);
			i.setFechaFin(null);
			i.setId(mapa.get("idIncidencia").toString());
			incidencias.add(i);

		}
		dao.disconnect();
		return incidencias;

	}

	public List<Empleado> bringBackEmpleados() {

		dao.connect();
		MongoDatabase db = dao.getDName();
		MongoCollection<Document> coleccion2 = db.getCollection("Empleado");
		FindIterable findIterable = coleccion2.find();
		Iterator<Document> iterator = findIterable.iterator();
		List<Empleado> empleados = new ArrayList<>();
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
	
	public List<Evento> bringBackEventos() {

		dao.connect();
		MongoDatabase db = dao.getDName();
		MongoCollection<Document> coleccion2 = db.getCollection("Evento");
		FindIterable findIterable = coleccion2.find();
		Iterator<Document> iterator = findIterable.iterator();
		List<Evento> eventos = new ArrayList<>();
		while (iterator.hasNext()) {
			Document document = iterator.next();
			Map<String, Object> mapa = new HashMap<>(document);
			Evento e1 = new Evento();
			String usuario = (String) mapa.get("usuario");
			String accion = (String) mapa.get("accion");
			String date = (String) mapa.get("date");

			e1.setUsuario(usuario);
			e1.setAccion(accion);
			e1.setDate(date);
			eventos.add(e1);

		}
		return eventos;
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
		String nombre = InputAsker.pedirCadena("Introduce el id del destinatario");
		List<Incidencia> incidencias = new ArrayList<>();
		List<Incidencia> listPorDestino = new ArrayList<>();
		incidencias = bringBackIncidencias();
		for (int i = 0; i < incidencias.size(); i++) {
			if (incidencias.get(i).getDestinatario().getUsuario().equalsIgnoreCase(nombre)) {
				
				listPorDestino.add(incidencias.get(i));
			}
		}
		if (listPorDestino.size() != 0) {
			insertarEvento(3, nombre);
			listPorDestino.forEach(System.out::println);
		} else {
			System.out.println("No hay incidencias con este destinatario");
		}

	}

	public void getIncidenciaByOrigen() {
		String nombre = InputAsker.pedirCadena("Introduce el id del origen");
		List<Incidencia> incidencias = new ArrayList<>();
		List<Incidencia> listPorOrigen = new ArrayList<>();

		incidencias = bringBackIncidencias();
		for (int i = 0; i < incidencias.size(); i++) {
			if (incidencias.get(i).getRemitente().getUsuario().equalsIgnoreCase(nombre)) {
				listPorOrigen.add(incidencias.get(i));
			}
		}
		if (listPorOrigen.size() != 0) {
			listPorOrigen.forEach(System.out::println);
		} else {
			System.out.println("No hay incidencias con este origen");
		}

	}

	public void insertarEvento(int numEvento, String usuario) {
		dao.connect();
		MongoDatabase db = dao.getDName();
		MongoCollection<Document> coleccion = db.getCollection("Evento");
		Evento evento = new Evento();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fecha = dateFormat.format(new Date());
		Document doc = new Document();
		String accion;
		switch (numEvento) {
		case 1:
			accion = "Login con usuario: " + empleado.getUsuario();
			doc.append("usuario", empleado.getUsuario());
			doc.append("accion", accion);
			doc.append("date", fecha);
			coleccion.insertOne(doc);
			break;
		case 2:
			accion = "Incidencia urgente de: " + empleado.getUsuario();
			doc.append("usuario", empleado.getUsuario());
			doc.append("accion", accion);
			doc.append("date", fecha);
			coleccion.insertOne(doc);
			break;
		case 3:
			accion = "Consulta de incidencias con destinatario: " + usuario;
			doc.append("usuario", empleado.getUsuario());
			doc.append("accion", accion);
			doc.append("date", fecha);
			coleccion.insertOne(doc);
			break;
		}

	}

	public void getUltimoInicioSesion() {
		List<Empleado> empleados = new ArrayList<>();
		List<Evento> eventos = new ArrayList<>();
		eventos = bringBackEventos();
		empleados = bringBackEmpleados();
		
		for (int i = 0; i < empleados.size(); i++) {
			System.out.println(i+".- " + empleados.get(i).getNombre());
		}
		int seleccionado = InputAsker.pedirEntero("Elige el empleado para ver el ultimo inicio de sesion: ");
		ArrayList<Evento> listadoFiltrado = new ArrayList<>();
		
	
//		Collections.sort(eventos, new Comparator<Evento>() {
//			  public int compare(Evento o1, Evento o2) {
//			      return o1.getDate().compareTo(o2.getDate());
//			  }
//			});
		
		Empleado selected = empleados.get(seleccionado);
		
		for (int i = 0; i < eventos.size(); i++) {
			if (eventos.get(i).getUsuario().equalsIgnoreCase(selected.getUsuario())) {
				if (eventos.get(i).getAccion().contains("Login")) {
					listadoFiltrado.add(eventos.get(i));
				}
			}
		}
		Collections.sort(listadoFiltrado);

		System.out.println(listadoFiltrado.get(listadoFiltrado.size()-1));
		listadoFiltrado.clear();

	}

	public void getRankingEmpleados() {
		dao.connect();
		MongoDatabase db = dao.getDName();
		List<Evento> eventos = bringBackEventos();
		List<Evento> eventoUrgente = new ArrayList<>();
		for(int i = 0; i < eventos.size(); i++) {
			if(eventos.get(i).getAccion().contains("urgente")) {
				eventoUrgente.add(eventos.get(i));
			}
		}
		eventoUrgente.forEach(System.out::println);
				

	}

	public boolean statusLogin() {
		dao.connect();
		MongoDatabase db = dao.getDName();
		List<Empleado> empleados = bringBackEmpleados();
		boolean status = false;
		String usuario = InputAsker.pedirCadena("Introduce el nombre de usuario");
		String pass = InputAsker.pedirCadena("Introduce la contraseña");
		for (int i = 0; i < empleados.size(); i++) {
			if (usuario.equals(empleados.get(i).getUsuario()) && pass.equals(empleados.get(i).getPassword())) {
				empleado.setNombre(empleados.get(i).getNombre());
				empleado.setUsuario(usuario);
				empleado.setPassword(pass);
				insertarEvento(1, empleado.getUsuario());
				status = true;
			}
		}
		return status;
	}

}
