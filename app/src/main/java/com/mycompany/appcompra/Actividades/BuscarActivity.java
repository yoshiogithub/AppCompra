package com.mycompany.appcompra.Actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mycompany.appcompra.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BuscarActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText Buscar,Cantidad,Cliente;
    TextView textView;
    String nombreProducto;
    String precioProducto;
    String busqueda;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String currentDateandTime = simpleDateFormat.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar2);

        Buscar=findViewById(R.id.txtBuscar);
        Cantidad=findViewById(R.id.txtCantidad);
        Cliente=findViewById(R.id.txtCliente);
        textView=findViewById(R.id.textView6);
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }

    public void buscar(View view){
        busqueda=Buscar.getText().toString();
        String cant_Producto = Cantidad.getText().toString();


        if(busqueda.isEmpty() || cant_Producto.isEmpty()) {
            Toast.makeText(BuscarActivity.this, "Complete los campos correspondientes", Toast.LENGTH_SHORT).show();

        }else{

            final int cantidad=Integer.parseInt(cant_Producto.toString());

            databaseReference.child("Producto").child(busqueda).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if(dataSnapshot.exists()){
                        nombreProducto=dataSnapshot.child("Producto").getValue().toString();
                        precioProducto=dataSnapshot.child("Precio").getValue().toString();

                        int precio=Integer.parseInt(precioProducto.toString());
                        int total=precio*cantidad;

                        textView.setText("NOMBRE DEL PLATO : "+nombreProducto+"\nPRECIO : s/."+precioProducto+"\nCANTIDAD : "+cantidad+
                                "\nTOTAL : s/."+total);
                        limpiar();
                    }else{
                        textView.setText(busqueda+" no existe");
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
    }

    public void agregar(View view){

        String NumeroCliente=Cliente.getText().toString();

        if(!NumeroCliente.isEmpty()){
            String NombreProducto=nombreProducto.toString();
            String PrecioProducto=precioProducto.toString();
            int No_Cliente=Integer.parseInt(NumeroCliente.toString());

            Map<String,Object> DatosProducto=new HashMap<>();
            DatosProducto.put("Producto",NombreProducto);
            DatosProducto.put("Precio",PrecioProducto);

            databaseReference.child("Cliente-"+No_Cliente+"("+currentDateandTime+")").child("Pedido").child(NombreProducto).setValue(DatosProducto);

            Toast.makeText(this, "PRODUCTO INGRESADO ("+NombreProducto+")", Toast.LENGTH_SHORT).show();
            limpiar();
            textView.setText("");
        }else{
            Toast.makeText(this, "Introduzca el numero del cliente", Toast.LENGTH_SHORT).show();
        }
    }


    private void limpiar() {
        Buscar.setText("");
        Cantidad.setText("");
        Cliente.setText("");

    }
}
