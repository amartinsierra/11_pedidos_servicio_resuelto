package graficos.curso.ejercicios.a11_pedidos_servicio_resuelto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceptorLibreria extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int cp=intent.getIntExtra("capacidad",0);
        Toast.makeText(context,"Exceso de capacidad "+cp,Toast.LENGTH_LONG).show();
    }
}
