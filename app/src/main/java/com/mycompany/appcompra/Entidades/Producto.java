package com.mycompany.appcompra.Entidades;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.concurrent.ThreadLocalRandom;

public class Producto {
    private String nombre;
    private String precio;
    private String msg;

    public Producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
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

    private String nomCodigo(){
        return nombre.substring(0,3);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int numAleatorio(){
        return ThreadLocalRandom.current().nextInt(100,999);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  String Codigo(){
        return msg=nomCodigo()+numAleatorio();
    }
}
