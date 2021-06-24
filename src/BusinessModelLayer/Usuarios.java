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
public class Usuarios {
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idUsuario;
    private int idSucursal;
    private String tipoUsuario;
    private String nombre;
    private int idContacto;
    private String usuario;
    private String password;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, int idSucursal, String tipoUsuario, String nombre, int idContacto, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
        this.idContacto = idContacto;
        this.usuario = usuario;
        this.password = password;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT * FROM Usuarios";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM Usuarios WHERE idusuario = " + idUsuario;
        DefaultTableModel res = dataAccess.Query(query);
        idUsuario = (int) res.getValueAt(0, 0);
        idSucursal = (int) res.getValueAt(0, 1);
        tipoUsuario = (String) res.getValueAt(0, 2);
        nombre = (String) res.getValueAt(0, 3);
        idContacto = (int) res.getValueAt(0, 4);
        usuario = (String) res.getValueAt(0, 5);
        password = (String) res.getValueAt(0, 6);
    }

    public boolean Add() {
        String query = "INSERT INTO Usuarios (idSucursal, tipoUsuario, nombre, idContacto, usuario, password) " + "VALUES('" + idSucursal + "','" + tipoUsuario + "','" + nombre + "','" + idContacto + "','" + usuario + "','" + password + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM Usuarios WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Usuarios SET "
                + "idSucursal = '" + idSucursal + "', "
                + "tipoUsuario = '" + tipoUsuario + "', "
                + "nombre = '" + nombre + "', "
                + "idContacto = '" + idContacto + "', "
                + "usuario = '" + usuario + "', "
                + "password = '" + password + "', "
                + "WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1;
    }
}
