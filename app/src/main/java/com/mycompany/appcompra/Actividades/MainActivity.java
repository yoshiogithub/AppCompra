package com.mycompany.appcompra.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mycompany.appcompra.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Registrar(View view){
        Intent registrar=new Intent(this,RegistrarActivity.class);
        startActivity(registrar);
    }

    public void Buscar(View view){
        Intent buscar=new Intent(this,BuscarActivity.class);
        startActivity(buscar);
    }


}
