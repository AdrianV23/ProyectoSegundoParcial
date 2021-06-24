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
public class Clientes {
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idCliente;
    private String nombre;
    private int idContacto;
    private int activo;
    
    public Clientes(){}

    public Clientes(int idCliente, String nombre, int idContacto, int activo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.idContacto = idContacto;
        this.activo = activo;
    }

    public Clientes(int i, String text, Object selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public DataAccess getDataAccess() {
        return dataAccess;
    }
    
    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        String query = "SELECT * FROM Clientes";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Clientes WHERE idCliente = " + idCliente;
        DefaultTableModel res = dataAccess.Query(query);
        idCliente = (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        idContacto = (int)res.getValueAt(0, 2);
        activo = (int)res.getValueAt(0, 3);
    }
    
    public boolean Add(){
        String query = "INSERT INTO Clientes(nombre, idContacto, activo ) " + "VALUES('" + nombre + "','"  + idContacto + "','" + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Clientes WHERE idCliente = " + idCliente;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Categorias SET " +
                "nombre = '" + nombre + "', " +
                "idContacto = '" + idContacto + "', " +
                "activo = " + activo + " " +
                "WHERE idCliente = " + idCliente;
        return dataAccess.Execute(query) >= 1;
    }
}
