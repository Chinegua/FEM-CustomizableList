package es.upm.miw.listviewlayout;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MuestraDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_elemento);

        // Recupero el recurso asociado en la vista
        TextView tvElementoElegido = (TextView) findViewById(R.id.tvMostrarElemento);

        // Recupero el bundle con los datos
//        String elementoElegido = getIntent().getStringExtra("MI_OPCION");
        Bundle bundle = this.getIntent().getExtras();
        String elementoElegido = bundle.getString(ActividadPrincipal.KEY_OPT_NAME);

        // Mostrar opción en la vista
        tvElementoElegido.setText(elementoElegido);

        // Mostrar el icono back
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setResult(RESULT_OK);
        // finish();
    }
}
