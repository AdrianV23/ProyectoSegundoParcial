/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

/**
 *
 * @author Adrian
 */
public class ProductosProveedores {
    private int idProductoProveedor;
    private int idProveedor;
    private int idProducto;
    
    public ProductosProveedores(){}

    public ProductosProveedores(int idProductoProveedor, int idProveedor, int idProducto) {
        this.idProductoProveedor = idProductoProveedor;
        this.idProveedor = idProveedor;
        this.idProducto = idProducto;
    }

    public int getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(int idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
