package com.example.hasantarek.departmentmanagement;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.net.URI;

public class Fcmmessagingservice extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String title = remoteMessage.getNotification().getTitle();
        String msg = remoteMessage.getNotification().getBody();

        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
        notification.setContentTitle(title);
        notification.setContentText(msg);



        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        notification.setSound(soundUri);
        //Vibrator vibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
       // vibrator.vibrate(1000);

        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setAutoCancel(true);
        notification.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification.build());
    }
}