package es.upm.miw.listviewlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity {

    public final static String KEY_OPT_NAME = "OPCION_ELEGIDA";
    public final static String KEY_POSITION = "NUMERO_OPCION";

    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Identificar el recurso en la vista
        listView = (ListView) findViewById(R.id.lvListadoElementos);

        // Crear adaptador a partir del recurso (ArrayAdapter.createFromResource)
//        String[] misDatos = {
//                "Texto 01",
//                "Texto 02",
//                "Texto 03",
//                "Texto 04",
//        };
//        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                misDatos
//        );


        String []datos = getResources().getStringArray(R.array.datos);
        MiAdapter adaptador = new MiAdapter(this,R.layout.list_view, datos);

        // Asignar el adaptador al recurso
        listView.setAdapter(adaptador);

        // Al seleccionar un elemento del recurso -> mostrarlo en un Toast
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Recupero el texto de la opción elegida
                String opcionElegida = listView.getItemAtPosition(position).toString();

                Log.i("MiW", "Opción elegida: " + opcionElegida + ", i=" + String.valueOf(id));
//                Toast.makeText(getApplicationContext(), opcionElegida, Toast.LENGTH_SHORT).show();

                Intent nuevoIntent = new Intent(ActividadPrincipal.this, MuestraDetalle.class);

//                nuevoIntent.putExtra("MI_OPCION", opcionElegida);

                Bundle bundle = new Bundle();
                bundle.putString(KEY_OPT_NAME, opcionElegida);
                bundle.putInt(KEY_POSITION, position);
                nuevoIntent.putExtras(bundle);

                startActivity(nuevoIntent);
            }
        });

    }
}
