package pe.area51.clase03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by alumno on 2/20/17.
 */

public class DetalleActivity extends AppCompatActivity {
    private TextView Resultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //vinculamos el diseño con la clase java
        setContentView(R.layout.activity_detalle);

        Resultado = (TextView) findViewById(R.id.tvResultado);
        // validamos que este llegando datos
        if (getIntent() != null){
            //validamos que en el intet se traiga el dato del ruc
            if (getIntent().hasExtra("ruc")){
                //obtenemos el ruc
                String ruc = getIntent().getStringExtra("ruc");
                //seteamos en textView con el valor de ruc
                Resultado.setText(ruc);
            }
            if (getIntent().hasExtra("razon")){
                //obtenemos el ruc
                String razon = getIntent().getStringExtra("razon");
                //seteamos en textView con el valor de ruc
                Resultado.setText(razon);
            }
        }

    }
}
