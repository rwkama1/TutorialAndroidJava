package uy.edu.bios.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        private ImageView imgvAvatar;
        private TextView tvCedula;
        private TextView tvNombreCompleto;


        public EmpleadoViewHolder(View vista) {
            imgvAvatar = (ImageView)vista.findViewById(R.id.imgvAvatar);
            tvCedula = (TextView)vista.findViewById(R.id.tvCedula);
            tvNombreCompleto = (TextView)vista.findViewById(R.id.tvNombreCompleto);
        }


        private int getIdImagenAvatar(int cedula) {
            Map<Integer, Integer> idsImagenes = new HashMap();

            idsImagenes.put(11111111, R.drawable.empleado_11111111);
            idsImagenes.put(22222222, R.drawable.empleado_22222222);
            idsImagenes.put(33333333, R.drawable.empleado_33333333);
            idsImagenes.put(44444444, R.drawable.empleado_44444444);
            idsImagenes.put(55555555, R.drawable.empleado_55555555);
            idsImagenes.put(66666666, R.drawable.empleado_66666666);
            idsImagenes.put(77777777, R.drawable.empleado_77777777);
            idsImagenes.put(88888888, R.drawable.empleado_88888888);
            idsImagenes.put(99999999, R.drawable.empleado_99999999);
            idsImagenes.put(10101010, R.drawable.empleado_10101010);
            idsImagenes.put(11111110, R.drawable.empleado_11111110);
            idsImagenes.put(12121212, R.drawable.empleado_12121212);

            return idsImagenes.get(cedula);
        }

        public void enlazarEmpleado(Empleado empleado) {
            int idImagenAvatar = getIdImagenAvatar(empleado.getCedula());
            imgvAvatar.setImageResource(idImagenAvatar);

            tvCedula.setText(String.valueOf(empleado.getCedula()));
            tvNombreCompleto.setText(empleado.getNombreCompleto());
        }

    }

}
