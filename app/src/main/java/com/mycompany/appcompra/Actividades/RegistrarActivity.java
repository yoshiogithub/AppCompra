package com.mycompany.appcompra.Actividades;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mycompany.appcompra.R;
import java.util.HashMap;
import java.util.Map;

public class RegistrarActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText Nombre,Precio;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Nombre=findViewById(R.id.txtNombre);
        Precio=findViewById(R.id.txtPrecio);
        textView=findViewById(R.id.textView6);
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }


    public void ingresar(View view){
        String nombre=Nombre.getText().toString();
        String precio=Precio.getText().toString();

        if(nombre.isEmpty() || precio.isEmpty()){
            Toast.makeText(this, "Complete los campos correspondientes", Toast.LENGTH_SHORT).show();
        }else {
            Map<String, Object> DatosProducto = new HashMap<>();
            DatosProducto.put("Producto", nombre);
            DatosProducto.put("Precio", precio);

            databaseReference.child("Producto").child(nombre).setValue(DatosProducto);

            Toast.makeText(this, "PRODUCTO INGRESADO (" + nombre + ")", Toast.LENGTH_SHORT).show();
            limpiar();
        }

    }

    private void limpiar() {
        Nombre.setText("");
        Precio.setText("");
    }
}
