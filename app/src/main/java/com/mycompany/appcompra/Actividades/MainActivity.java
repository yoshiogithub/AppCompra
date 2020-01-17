package com.mycompany.appcompra.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.mycompany.appcompra.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Registrar(View view){
        Intent registrar=new Intent(this,RegistrarActivity.class);
        registrar.putExtra("ir","registrar");
        startActivity(registrar);
    }



    public void Comprar(View view){

    }
}
