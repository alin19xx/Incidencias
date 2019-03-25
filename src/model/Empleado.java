/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author alexlin
 */
public class Empleado extends Codificable{
	private String usuario;
	private String nombre;
	private String password;
	

	/**
	 * @param incidencias the incidencias to set
	 */
//	public void setIncidencias(List<Incidencia> incidencias) {
//		this.incidencias = incidencias;
//	}
	
	

	/**
	 * @param idEmpleado
	 * @param usuario
	 * @param nombre
	 * @param password
	 */
	public Empleado( String usuario, String nombre, String password) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.password = password;
	}
	

	public Empleado() {
		
	}

	/**
	 * @param incidencias
	 */
//	public Empleado(List<Incidencia> incidencias) {
//		super();
//		this.incidencias = incidencias;
//	}

	

	

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Empleado [usuario=" + usuario + ", nombre=" + nombre + "]";
	}

}
