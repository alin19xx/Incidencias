/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author alexlin
 */
public class Incidencia{

	private int id;
	private Empleado remitente;
	private String objeto;
	private String tipo;
	private Empleado destinatario;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	
	/**
	 * @param codigo
	 */
//	public Incidencia(String codigo) {
//		super(codigo);
//	}
	/**
	 * @param codigo
	 * @param id
	 * @param remitente
	 * @param objeto
	 * @param tipo
	 * @param destinatario
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Incidencia(String codigo, int id, Empleado remitente, String objeto, String tipo, Empleado destinatario,
			Date fechaInicio, Date fechaFin) {
//		super(codigo);
		this.id = id;
		this.remitente = remitente;
		this.objeto = objeto;
		this.tipo = tipo;
		this.destinatario = destinatario;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", remitente=" + remitente + ", objeto=" + objeto + ", tipo=" + tipo
				+ ", destinatario=" + destinatario + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	public Incidencia() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the remitente
	 */
	public Empleado getRemitente() {
		return remitente;
	}
	/**
	 * @param remitente the remitente to set
	 */
	public void setRemitente(Empleado remitente) {
		this.remitente = remitente;
	}
	/**
	 * @return the objeto
	 */
	public String getObjeto() {
		return objeto;
	}
	/**
	 * @param objeto the objeto to set
	 */
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the destinatario
	 */
	public Empleado getDestinatario() {
		return destinatario;
	}
	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(Empleado destinatario) {
		this.destinatario = destinatario;
	}
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	
	
	

}
