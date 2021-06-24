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
public class Sucursales {
   private DataAccess dataAccess = DataAccess.Instance();
    
   private int idSucursal;
   private String nombre;
   private int idContacto;
   private int activo;
   
   public Sucursales(){}

    public Sucursales(int idSucursal, String nombre, int idContacto, int activo) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.idContacto = idContacto;
        this.activo = activo;
    }
    
    public DataAccess getDataAccess() {
        return dataAccess;
    }
    
    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public int getidSucursal() {
        return idSucursal;
    }

    public void setidSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
   
   public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM Sucursales";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Sucursales WHERE idSucursal = " + idSucursal;
        DefaultTableModel res = dataAccess.Query(query);
        idSucursal = (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        idContacto = (int)res.getValueAt(0, 2);
        activo = (int)res.getValueAt(0, 3);
    }
    
    public boolean Add(){
        String query = "INSERT INTO Sucursales (nombre, idContacto, activo) " + "VALUES('" + nombre + "','" + idContacto + "','"  + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Sucursales WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Proveedor SET " +
                "nombre = '" + nombre + "', " +
                "idContacto = '" + idContacto + "', " +
                "activo = '" + activo + "', " +
                "WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1;
    }
}
