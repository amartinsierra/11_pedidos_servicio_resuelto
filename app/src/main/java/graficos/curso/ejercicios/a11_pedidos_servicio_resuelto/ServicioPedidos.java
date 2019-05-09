package graficos.curso.ejercicios.a11_pedidos_servicio_resuelto;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.Message;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import adaptadores.AdaptadorLibros;
import beans.Pedidos;
import modelo.GestionPedidos;

public class ServicioPedidos extends Service {
    Timer timer=new Timer();
    public ServicioPedidos() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ComunicacionPedidos com=new ComunicacionPedidos();
                com.execute();
            }
        },0,5000);
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
    private class ComunicacionPedidos extends AsyncTask<Void,Void,List<Pedidos>> {
        @Override
        protected void onPostExecute(List<Pedidos> pedidos) {
            System.out.println("llegan "+pedidos.size());
            super.onPostExecute(pedidos);
            Message m=new Message();
            m.obj=pedidos;
            MainActivity.manejador.sendMessage(m);

        }

        @Override
        protected List<Pedidos> doInBackground(Void... args) {
            GestionPedidos gpedidos=new GestionPedidos();
            return gpedidos.obtenerPedidos();
        }
    }
}
