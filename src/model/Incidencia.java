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
public class Incidencia {

	private int idRemitente;
	private String objeto;
	private String tipo;
	private int idDestinatario;
	private Date fechaInicio;
	private Date fechaFin;

	/**
	 * @param idRemitente
	 * @param objeto
	 * @param tipo
	 * @param idDestinatario
	 * @param fechaInicio
	 * @param fechaFin
	 */
	public Incidencia(int idRemitente, String objeto, String tipo, int idDestinatario, Date fechaInicio,
			Date fechaFin) {
		super();
		this.idRemitente = idRemitente;
		this.objeto = objeto;
		this.tipo = tipo;
		this.idDestinatario = idDestinatario;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the idRemitente
	 */
	public int getIdRemitente() {
		return idRemitente;
	}

	/**
	 * @param idRemitente the idRemitente to set
	 */
	public void setIdRemitente(int idRemitente) {
		this.idRemitente = idRemitente;
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
	 * @return the idDestinatario
	 */
	public int getIdDestinatario() {
		return idDestinatario;
	}

	/**
	 * @param idDestinatario the idDestinatario to set
	 */
	public void setIdDestinatario(int idDestinatario) {
		this.idDestinatario = idDestinatario;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Incidencia [idRemitente=" + idRemitente + ", objeto=" + objeto + ", tipo=" + tipo + ", idDestinatario="
				+ idDestinatario + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	

}
