package pe.area51.clase03;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ruc, razonsocial;
    private RadioButton rbActivo, rbInactivo;
    private CheckBox ckNoti;
    private Button btVerifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ruc = (EditText) findViewById(R.id.ruc);
        razonsocial = (EditText) findViewById(R.id.razonsocial);
        rbActivo = (RadioButton) findViewById(R.id.rbActivo);
        rbInactivo = (RadioButton) findViewById(R.id.rbInactivo);
        ckNoti = (CheckBox) findViewById(R.id.ckNoti);
        btVerifica = (Button) findViewById(R.id.btVerifica);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btVerifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // obtener los datos

                String dRuc = ruc.getText().toString();
                String dRazon = razonsocial.getText().toString();
                String estado = (
                                rbActivo.isChecked()?
                                        rbActivo.getText().toString():
                                        rbInactivo.getText().toString()
                                );
                /*String dato="";
                if (rbActivo.isChecked()){
                    dato = rbActivo.getText().toString();
                }else if (){

                }*/

                boolean recNoti = ckNoti.isChecked();

                //validaciones

                if (dRuc.trim().length() == 0){
                    ruc.setError("Ingrese un Ruc");
                    return;
                }else {
                    ruc.setError(null);
                }

                if (dRazon.trim().length() == 0){
                    razonsocial.setError("Ingrese una Razon Social");
                    return;
                }else {
                    razonsocial.setError(null);
                }

                //enviar datos al detalle activiti
                Intent intent= new Intent(MainActivity.this, DetalleActivity.class);
                //enviamos datos a traves del intent
                intent.putExtra("ruc", dRuc);
                intent.putExtra("razon", dRazon);
                intent.putExtra("estado", estado);
                intent.putExtra("noti", recNoti);

                //ejecuta la sentencia que estamos poniendo
                startActivity(intent);

                Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
