package graficos.curso.ejercicios.a11_pedidos_servicio_resuelto;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


import adaptadores.AdaptadorLibros;
import beans.Pedidos;
import modelo.GestionPedidos;
import graficos.curso.ejercicios.a11_pedidos_servicio_resuelto.R;
public class MainActivity extends Activity {
    public static Handler manejador;
    ListView lstLibros;
    EditText edtBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstLibros=this.findViewById(R.id.lista);
        manejador=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                List<Pedidos> pedidos=(List<Pedidos>)msg.obj;
                if(pedidos.size()>3){
                    MainActivity.this.sendBroadcast(new Intent("acciones.personales.EXCESOMATERIAL"));
                }
                AdaptadorLibros adp=new AdaptadorLibros(MainActivity.this,pedidos);
                lstLibros.setAdapter(adp);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.startService(new Intent(this,ServicioPedidos.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.stopService(new Intent(this,ServicioPedidos.class));
    }
}
