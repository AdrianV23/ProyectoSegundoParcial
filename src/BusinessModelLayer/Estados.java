/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class Estados {
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idEstado;
    private String estado;
    
    public Estados(){}

    public Estados(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }
    
    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM Estados";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Estados WHERE idEstado = " + idEstado;
        DefaultTableModel res = dataAccess.Query(query);
        idEstado = (int)res.getValueAt(0, 0);
        estado = (String)res.getValueAt(0, 0);
    }
    
    public boolean Add(){
        String query = "INSERT INTO Estados ( estado ) " + "VALUES('" + estado + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Estados WHERE idEstado = " + idEstado;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Estados SET " +
                "estado = '" + estado + "', " +
                "WHERE idEstado = " + idEstado;
        return dataAccess.Execute(query) >= 1;
    }
    
}
