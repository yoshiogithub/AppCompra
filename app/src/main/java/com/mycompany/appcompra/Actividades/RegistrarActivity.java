package com.mycompany.appcompra.Actividades;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mycompany.appcompra.R;

import java.util.HashMap;
import java.util.Map;

public class RegistrarActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText Nombre,Precio,Buscar,Cantidad;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Nombre=findViewById(R.id.txtNombre);
        Precio=findViewById(R.id.txtPrecio);
        Buscar=findViewById(R.id.txtBuscar);
        Cantidad=findViewById(R.id.txtCantidad);
        textView=findViewById(R.id.textView6);
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }


    public void ingresar(View view){
        String nombre=Nombre.getText().toString();
        String precio=Precio.getText().toString();

        Map<String,Object>DatosProducto=new HashMap<>();
        DatosProducto.put("Producto",nombre);
        DatosProducto.put("Precio",precio);

        databaseReference.child("Producto").child(nombre).setValue(DatosProducto);

        Toast.makeText(this, "PRODUCTO INGRESADO ("+nombre+")", Toast.LENGTH_SHORT).show();
    }

    public void buscar(View view){
        String busqueda=Buscar.getText().toString();
        final int cantidad=Integer.parseInt(Cantidad.getText().toString());

        databaseReference.child("Producto").child(busqueda).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    String nombreProducto=dataSnapshot.child("Producto").getValue().toString();
                    String precioProducto=dataSnapshot.child("Precio").getValue().toString();

                    int precio=Integer.parseInt(precioProducto.toString());
                    int total=precio*cantidad;

                    textView.setText("NOMBRE DEL PLATO : "+nombreProducto+"\nPRECIO : s/."+precioProducto+"\nCANTIDAD : "+cantidad+
                            "\nTOTAL : s/."+total);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
