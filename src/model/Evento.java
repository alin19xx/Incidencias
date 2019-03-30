/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alexlin
 */
public class Evento implements Comparable<Evento> {
	String usuario;
	String accion;
	String date;
	/**
	 * @param usuario
	 * @param accion
	 * @param date
	 */
	public Evento(String usuario, String accion, String date) {
		super();
		this.usuario = usuario;
		this.accion = accion;
		this.date = date;
	}
	public Evento() {
		// TODO Auto-generated constructor stub
	}
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
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}
	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Evento [usuario=" + usuario + ", accion=" + accion + ", date=" + date + "]";
	}

	  @Override
	  public int compareTo(Evento evento) {
	    return getDate().compareTo(evento.getDate());
	  }

	
	
    
}
