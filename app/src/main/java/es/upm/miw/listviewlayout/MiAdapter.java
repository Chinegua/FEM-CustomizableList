package es.upm.miw.listviewlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by chinegua on 16/10/17.
 */

public class MiAdapter extends ArrayAdapter {

    Context contexto;
    int idResourceLayout;
    Object[] datos;

    MiAdapter(Context context, int resourceId, Object[] objects){
        super(context,resourceId,objects);
        contexto = context;
        datos = (String[]) objects;
        idResourceLayout = resourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LinearLayout vista;

        if (null!=convertView){
            vista = (LinearLayout) convertView;
        }
        else{
            LayoutInflater inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = (LinearLayout) inflador.inflate(idResourceLayout,parent,false);

        }

        TextView tvTexto = (TextView) vista.findViewById(R.id.textId);
        tvTexto.setText(String.format("%2d",position));

        ImageView img = (ImageView) vista.findViewById(R.id.imgId);

        img.setImageResource(R.mipmap.ic_miw_launcher_rounded);

        return vista;
    }
}
