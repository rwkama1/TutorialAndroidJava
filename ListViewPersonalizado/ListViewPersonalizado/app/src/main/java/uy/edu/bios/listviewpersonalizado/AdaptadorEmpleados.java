package uy.edu.bios.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Raul on 26/9/2017.
 */

public class AdaptadorEmpleados extends BaseAdapter {

    private Context contexto;
    private List<Empleado> empleados;


    public AdaptadorEmpleados(Context contexto, List<Empleado> empleados) {
        this.contexto = contexto;
        this.empleados = empleados;
    }


    @Override
    public int getCount() {
        return empleados.size();
    }

    @Override
    public Empleado getItem(int position) {
        return empleados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*LayoutInflater inflador = LayoutInflater.from(contexto);
        View item = inflador.inflate(R.layout.listitem_empleado, parent, false);

        TextView tvCedula = (TextView)item.findViewById(R.id.tvCedula);
        TextView tvNombreCompleto = (TextView)item.findViewById(R.id.tvNombreCompleto);

        tvCedula.setText(String.valueOf(empleados.get(position).getCedula()));
        tvNombreCompleto.setText(empleados.get(position).getNombreCompleto());

        return item;*/

        View item = convertView;
        EmpleadoViewHolder empleadoViewHolder;

        if (item == null) {
            LayoutInflater inflador = LayoutInflater.from(contexto);
            item = inflador.inflate(R.layout.listitem_empleado, parent, false);

            empleadoViewHolder = new EmpleadoViewHolder(item);
            item.setTag(empleadoViewHolder);
        } else {
            empleadoViewHolder = (EmpleadoViewHolder)item.getTag();
        }

        empleadoViewHolder.enlazarEmpleado(empleados.get(position));

        return item;
    }


    protected class EmpleadoViewHolder {

        private TextView tvCedula;
        private TextView tvNombreCompleto;


        public EmpleadoViewHolder(View vista) {
            tvCedula = (TextView)vista.findViewById(R.id.tvCedula);
            tvNombreCompleto = (TextView)vista.findViewById(R.id.tvNombreCompleto);
        }


        public void enlazarEmpleado(Empleado empleado) {
            tvCedula.setText(String.valueOf(empleado.getCedula()));
            tvNombreCompleto.setText(empleado.getNombreCompleto());
        }

    }

}
