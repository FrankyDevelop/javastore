package com.getstarted.javastore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;

    EditText edtNombre;
    EditText edtDescripcion;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= FirebaseFirestore.getInstance();
        edtNombre= findViewById(R.id.edtNombre);
        edtDescripcion= findViewById(R.id.edtDescripcion);
        btnGuardar=findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 guardarProyecto();
                //estaba viendo unas cosas
            }
        });
    }


    private void guardarProyecto(){
        String NombreProyecto=edtNombre.getText().toString();
        String DescripcionProyecto=edtDescripcion.getText().toString();

        Map<String, Object> project = new HashMap<>();
        project.put("NombreProyecto", NombreProyecto);
        project.put("DescripcionProyecto", DescripcionProyecto);

        //y no se guarda? :v
        // nada men :'v dejame debugear conecta un cel xd
        //hay un tema con eso ,esta vaina no tiene el vtx activado :'v
        //conecte el cell haber sii con el cel tonces xd k pez dale we :v no me sale para ejecutar xd
        //ah es porque staba para sacar el sha1,da fuk ? :'v
        //solo la puedes ejecutar creando un apk? :'v
        //yes ,no me deja ni coenctar el cell igual instalalo y a ver k pez
        //no sabes algun modo de sacar debug (solo errores) asi sin emulador o sin cell?
        //a ver ahora prueba vamo a chekar ahora a probarlo XD
        db.collection("Proyectos").document("Primero").set(project).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(!task.isSuccessful()){
                    //te va a imprimir la causa del error dale instalalo otra vez, no te aparece un menase asi? ;v
                    //nada men :'v
                    Toast.makeText(MainActivity.this, "Error: "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
