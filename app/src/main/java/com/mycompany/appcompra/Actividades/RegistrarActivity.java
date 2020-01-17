package com.mycompany.appcompra.Actividades;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mycompany.appcompra.Entidades.Producto;
import com.mycompany.appcompra.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrarActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText Nombre,Precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Nombre=findViewById(R.id.txtNombre);
        Precio=findViewById(R.id.txtPrecio);
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void ingresar(View view){
        String nombre=Nombre.getText().toString();
        String precio=Precio.getText().toString();

        Map<String,Object>DatosProducto=new HashMap<>();
        DatosProducto.put("Nombre del Producto : ",nombre);
        DatosProducto.put("Precio del Producto : ",precio);

        Producto producto=new Producto("","");

        databaseReference.child("Producto").child(producto.Codigo()).setValue(DatosProducto);
    }
}
