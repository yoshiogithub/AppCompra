package com.mycompany.appcompra.Entidades;


public class Producto {
    private String nombre;
    private int precio;
    private int cantidad;
    private int no_cliente;

    public Producto(String nombre, int precio, int cantidad, int no_cliente) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad=cantidad;
        this.no_cliente=no_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}


    public int getNo_cliente() {return no_cliente;}

    public void setNo_cliente(int no_cliente) {this.no_cliente = no_cliente;}
}
