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
public class Contactos {
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idContacto;
    private String codigoPostal;
    private String entidad;
    private String comuna;
    private String calle;
    private String telefono;
    
    public Contactos(){}

    public Contactos(int idContacto, String codigoPostal, String entidad, String comuna, String calle, String telefono) {
        this.idContacto = idContacto;
        this.codigoPostal = codigoPostal;
        this.entidad = entidad;
        this.comuna = comuna;
        this.calle = calle;
        this.telefono = telefono;
    }
    
    public DataAccess getDataAccess() {
        return dataAccess;
    }
    
    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM Contactos";
        return dataAccess.Query(query);
    }
    
    public void GetById(){
        String query = "SELECT * FROM Contactos WHERE idContacto = " + idContacto;
        DefaultTableModel res = dataAccess.Query(query);
        idContacto = (int)res.getValueAt(0, 0);
        codigoPostal = (String)res.getValueAt(0, 1);
        entidad = (String)res.getValueAt(0, 2);
        comuna = (String)res.getValueAt(0, 3);
        calle = (String)res.getValueAt(0, 4);
        telefono = (String)res.getValueAt(0, 5);
    }
    
    public boolean Add(){
        String query = "INSERT INTO Contactos (nombre, idContacto, activo ) " + "VALUES('" + codigoPostal + "','"  + entidad + "','" + comuna + "','"  + calle + "','"  + telefono + ");";
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Delete(){
        String query = "DELETE FROM Contactos WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1;
    }
    
    public boolean Update(){
        String query = "UPDATE Contactos SET " +
                "codigoPostal = '" + codigoPostal + "', " +
                "entidad = '" + entidad + "', " +
                "comuna = '" + comuna + "', " +
                "calle = '" + calle + "', " +
                "telefono = '" + telefono + "', " +
                "WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1;
    }
}
