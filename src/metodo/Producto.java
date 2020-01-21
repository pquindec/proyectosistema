/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodo;

/**
 *
 * @author usuario
 */
public class Producto {
    int id;
    String nombre;
    double nprecio;
    double dprecio;
    int cantidad;
    String tipo;
    public Producto(){
        
    }
    public Producto(int id,String nombre, double nprecio,double dprecio,int cantidad,String tipo){
    this.id=id;
    this.nombre=nombre;
    this.nprecio=nprecio;
    this.dprecio=dprecio;
    this.cantidad=cantidad;
    this.tipo=tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNprecio() {
        return nprecio;
    }

    public void setNprecio(double nprecio) {
        this.nprecio = nprecio;
    }

    public double getDprecio() {
        return dprecio;
    }

    public void setDprecio(double dprecio) {
        this.dprecio = dprecio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
