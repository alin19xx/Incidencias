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
public class RankingTO {
	
	String nombreDeUsuario;
	int numberToCount;
	
	/**
	 * @param nombreDeUsuario
	 * @param numberToCount
	 */
	public RankingTO(String nombreDeUsuario, int numberToCount) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.numberToCount = numberToCount;
	}
	/**
	 * 
	 */
	public RankingTO() {
		super();
	}
	/**
	 * @return the nombreDeUsuario
	 */
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	/**
	 * @param nombreDeUsuario the nombreDeUsuario to set
	 */
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	/**
	 * @return the numberToCount
	 */
	public int getNumberToCount() {
		return numberToCount;
	}
	/**
	 * @param numberToCount the numberToCount to set
	 */
	public void setNumberToCount(int numberToCount) {
		this.numberToCount = numberToCount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RankingTO [nombreDeUsuario=" + nombreDeUsuario + ", numberToCount=" + numberToCount + "]";
	}
	
	
	
    
}
