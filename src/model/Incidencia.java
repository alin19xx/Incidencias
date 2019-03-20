/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author alexlin
 */
public class Incidencia extends Codificable{

	private String id;
	private Empleado remitente;
	private String objeto;
	private String tipo;
	private Empleado destinatario;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	
	
	
	/**
	 * @param codigo
	 */
	public Incidencia(String codigo) {
		super(codigo);
	}
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
	public Incidencia(String codigo, String id, Empleado remitente, String objeto, String tipo, Empleado destinatario,
			LocalDateTime fechaInicio, LocalDateTime fechaFin) {
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
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "Incidencia [id=" + id + ", remitente=" + remitente + ", objeto=" + objeto + ", tipo=" + tipo
				+ ", destinatario=" + destinatario + ", fechaInicio=" + fechaInicio.format(dateFormat) + ", fechaFin=" + fechaFin + "]";
	}
	public Incidencia() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param date the fechaInicio to set
	 */
	public void setFechaInicio(LocalDateTime date) {
		this.fechaInicio = date;
	}
	/**
	 * @return the fechaFin
	 */
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param date the fechaFin to set
	 */
	public void setFechaFin(LocalDateTime date) {
		this.fechaFin = date;
	}

	
	
	

}
