package com.example.quiz.system;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.example.quiz.R;

public class MyService extends Service {
    private static final String TAG = "MyService";
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.music_first_act);
    }

    @Override
    public void onDestroy() {
        player.stop();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player.isPlaying()) {

        }else {
            player.start();
        }
        return START_REDELIVER_INTENT;
    }

}