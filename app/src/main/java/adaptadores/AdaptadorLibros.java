package adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import beans.Pedidos;
import graficos.curso.ejercicios.a11_pedidos_servicio_resuelto.R;

/**
 * Created by antonio on 26/09/2017.
 */

public class AdaptadorLibros extends BaseAdapter {
    private Context ctx;
    private List<Pedidos> pedidos;
    LayoutInflater inflater;
    public AdaptadorLibros(Context ctx, List<Pedidos> pedidos){
        this.ctx=ctx;
        this.pedidos=pedidos;
        inflater= LayoutInflater.from(ctx);
    }


    @Override
    public int getCount() {
        return pedidos.size();
    }

    @Override
    public Object getItem(int i) {
        return pedidos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Pedidos l=pedidos.get(i);
        //asigna al View que representa cada posiciÃ³n de la lista la plantilla
        //que define cada elemento de una fila
        view= inflater.inflate(R.layout.fila, null);
        TextView tTitulo=view.findViewById(R.id.tvTitulo);
        tTitulo.setText(l.getProducto());
        TextView tPrecio=view.findViewById(R.id.tvPrecio);
        tPrecio.setText(l.getPrecio()+"");
        TextView tAutor=view.findViewById(R.id.tvAutor);
        tAutor.setText(l.getSeccion()+"");
        System.out.println("crea fila "+i);
        return view;
    }
}

