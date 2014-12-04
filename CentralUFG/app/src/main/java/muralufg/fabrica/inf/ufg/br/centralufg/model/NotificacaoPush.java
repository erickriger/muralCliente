package muralufg.fabrica.inf.ufg.br.centralufg.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import muralufg.fabrica.inf.ufg.br.centralufg.R;
import muralufg.fabrica.inf.ufg.br.centralufg.util.view.cartao.DetalheActivity;

public class NotificacaoPush {

    public static int NOTIFICATION_ID = 1;

    public void mostraNotificacao(String msg, Context context) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Nova Mensagem")
                        .setNumber(NOTIFICATION_ID++)
                        .setContentText((NOTIFICATION_ID) + " mensagem(s) recebida(s)");
        Intent resultIntent = new Intent(context, DetalheActivity.class);
        resultIntent.putExtra("mensagem_recebida", msg);
        resultIntent.putExtra("qtde_msgs", NOTIFICATION_ID);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(DetalheActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        Notification notification = mBuilder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.number = NOTIFICATION_ID;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
            }
}


