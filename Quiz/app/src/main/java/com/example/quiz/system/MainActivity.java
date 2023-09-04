package com.example.quiz.system;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    private ImageView imageEarth, imageCloud, imageCloud2, imageCloud3;
    private Animation animationEarth, animationAppName, animationCloud, animationCloud2, animationCloud3;
    Button buttonStart;
    public boolean flag;
    public ImageView imageClipart;
    SharedPreferences saveAAA, dataBasePeople;
    SharedPreferences.Editor baseEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Создание анимации для первого слайда:
        animationEarth = AnimationUtils.loadAnimation(this, R.anim.anim_earth);
        animationAppName = AnimationUtils.loadAnimation(this, R.anim.anim_app_name);
        animationCloud = AnimationUtils.loadAnimation(this, R.anim.anim_cloud);
        animationCloud2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud2);
        animationCloud3 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud3);
        Window window1 = getWindow();
        window1.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
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
        flag = false;
        saveAAA = getSharedPreferences("AAA", MODE_PRIVATE);
        SharedPreferences.Editor editor = saveAAA.edit();
        //Запоминаем логин при входе:
        dataBasePeople = getSharedPreferences("Base", MODE_PRIVATE);
        baseEditor = dataBasePeople.edit();


        editor.putInt("AAA", 1);
        if (saveAAA.getInt("AAA", 1) == 0) {
            imageClipart.setImageResource(R.drawable.clipart_false);
        }


        buttonStart.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        imageClipart.setOnClickListener(view -> {
            if (saveAAA.getInt("AAA", 1) == 1) {
                imageClipart.setImageResource(R.drawable.clipart_false);
                stopService(new Intent(this, MyService.class));
                editor.putInt("AAA", 0);
                editor.apply();
            } else {
                imageClipart.setImageResource(R.drawable.clipart);
                startService(new Intent(this, MyService.class));
                editor.putInt("AAA", 1);
                editor.apply();
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
        if (saveAAA.getInt("AAA", 1) == 0) {

        } else {
            startService(new Intent(this, MyService.class));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (flag == false) {
            stopService(new Intent(this, MyService.class));
        }
    }


    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
