/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Empleado;
import model.Evento;
import model.Incidencia;
import model.RankingTO;

/**
 *
 * @author alexlin
 */
public class DAO implements iDAO{

    @Override
    public void insertEmpleado(Empleado e) {
        
    }

    @Override
    public boolean loginEmpleado(String user, String pass) {
        return false;
    }

    @Override
    public void updateEmpleado(Empleado e) {
    }

    @Override
    public void removeEmpleado(Empleado e) {
    }

    @Override
    public Incidencia getIncidenciaById(int id) {
        return null;
    }

    @Override
    public List<Incidencia> selectAllIncidencias() {
        return null;
    }

    @Override
    public void insertIncidencia(Incidencia i) {
    }

    @Override
    public List<Incidencia> getIncidenciaByDestino(Empleado e) {
        return null;
    }

    @Override
    public List<Incidencia> getIncidenciaByOrigen(Empleado e) {
        return null;
    }

    @Override
    public void insertarEvento(Evento e) {
    }

    @Override
    public Evento getUltimoInicioSesion(Empleado e) {
        return null;
    }

    @Override
    public List<RankingTO> getRankingEmpleados() {
        return null;
    }

   
}
