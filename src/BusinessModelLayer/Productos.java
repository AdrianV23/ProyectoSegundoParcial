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
public class Productos {
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idProducto;
    private int idCategoria;
    private String nombre;
    private String precio;
    private String caducidad;
    private String descuento;
    private int activo;
    
    public Productos(){}

    public Productos(int idProducto, int idCategoria, String nombre, String precio, String caducidad, String descuento, int activo) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.precio = precio;
        this.caducidad = caducidad;
        this.descuento = descuento;
        this.activo = activo;
    }

    public int getIdProducto() {
        return idProducto;
    }
    
    public DataAccess getDataAccess() {
        return dataAccess;
    }
    
    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM Productos";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Productos WHERE idProducto = " + idProducto;
        DefaultTableModel res = dataAccess.Query(query);
        idProducto = (int)res.getValueAt(0, 0);
        idCategoria = (int)res.getValueAt(0, 1);
        nombre = (String)res.getValueAt(0, 2);
        precio = (String)res.getValueAt(0, 3);
        caducidad = (String)res.getValueAt(0, 4);
        descuento = (String)res.getValueAt(0, 5);
        activo = (int)res.getValueAt(0, 6);
    }
    
    public boolean Add(){
        String query = "INSERT INTO Contactos (idCategoria, nombre, precio, caducidad, descuento, activo) " + "VALUES('" + idCategoria + "','"  + nombre + "','" + precio + "','"  + caducidad + "','"  + descuento + "','" + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Productos WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Productos SET " +
                "idCategoria = '" + idCategoria + "', " +
                "nombre = '" + nombre + "', " +
                "precio = '" + precio + "', " +
                "caducidad = '" + caducidad + "', " +
                "descuento = '" + descuento + "', " +
                "activo = '" + activo + "', " +
                "WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1;
    }
}
