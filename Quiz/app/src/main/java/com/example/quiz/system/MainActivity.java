package com.example.quiz.system;

import static com.example.quiz.Const.MUSIC_MODE;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.quiz.R;
import com.example.quiz.ui.activity.BaseActivity;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private ImageView imageEarth, imageCloud, imageCloud2, imageCloud3;
    private Animation animationEarth, animationAppName, animationCloud, animationCloud2, animationCloud3;
    Button buttonStart;
    public ImageView imageClipart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Создание анимации для первого слайда:
        animationEarth = AnimationUtils.loadAnimation(this, R.anim.anim_earth);
        animationAppName = AnimationUtils.loadAnimation(this, R.anim.anim_app_name);
        animationCloud = AnimationUtils.loadAnimation(this, R.anim.anim_cloud);
        animationCloud2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud2);
        animationCloud3 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Инициализация картинки земди:
        imageEarth = findViewById(R.id.imageEarth);
        //Инициализация облаков:
        imageCloud = findViewById(R.id.imageCloudAct1);
        imageCloud2 = findViewById(R.id.imageCloud2Act1);
        imageCloud3 = findViewById(R.id.imageCloud3Act1);
        //Инициализация кнокпи "играть":
        buttonStart = findViewById(R.id.buttonStart);
        //Работа со звуком "нота":
        imageClipart = findViewById(R.id.imageClipart);

        if (getSp().getInt(MUSIC_MODE, 1) == 0) {
            imageClipart.setImageResource(R.drawable.clipart_false);
        }

        buttonStart.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });

        imageClipart.setOnClickListener(view -> {
            if (getSp().getInt(MUSIC_MODE, 1) == 1) {
                imageClipart.setImageResource(R.drawable.clipart_false);
                stopService(new Intent(this, MyService.class));
                getEditor().putInt(MUSIC_MODE, 0).apply();
            } else {
                imageClipart.setImageResource(R.drawable.clipart);
                startService(new Intent(this, MyService.class));
                getEditor().putInt(MUSIC_MODE, 1).apply();
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        imageEarth.startAnimation(animationEarth);
        buttonStart.startAnimation(animationAppName);
        imageCloud.startAnimation(animationCloud);
        imageCloud2.startAnimation(animationCloud2);
        imageCloud3.startAnimation(animationCloud3);
    }
}
