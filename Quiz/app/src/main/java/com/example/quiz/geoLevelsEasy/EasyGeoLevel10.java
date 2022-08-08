package com.example.quiz.geoLevelsEasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.system.ActivityGeoEasy;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;

public class EasyGeoLevel10 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textGeoEasyAnsLvl10_1, textGeoEasyAnsLvl10_2, textGeoEasyAnsLvl10_3, textGeoEasyAnsLvl10_4, textMonitorGeoEasyLvl10;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_geo_level10);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textGeoEasyAnsLvl10_1 = findViewById(R.id.textGeoEasyAnsLvl10_1);
        textGeoEasyAnsLvl10_2 = findViewById(R.id.textGeoEasyAnsLvl10_2);
        textGeoEasyAnsLvl10_3 = findViewById(R.id.textGeoEasyAnsLvl10_3);
        textGeoEasyAnsLvl10_4 = findViewById(R.id.textGeoEasyAnsLvl10_4);
        //Инициализация поля "монитор":
        textMonitorGeoEasyLvl10 = findViewById(R.id.textMonitorGeoEasyLvl10);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textGeoEasyAnsLvl10_1.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl10_1.getText().toString().equals(getString(R.string.activityEasyGeoLevel10Ans2))) {
                textGeoEasyAnsLvl10_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl10_1);
            } else {
                textGeoEasyAnsLvl10_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl10_1);
            }
        });
        textGeoEasyAnsLvl10_2.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl10_2.getText().toString().equals(getString(R.string.activityEasyGeoLevel10Ans2))) {
                textGeoEasyAnsLvl10_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl10_2);
            }else {
                textGeoEasyAnsLvl10_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl10_2);
            }
        });
        textGeoEasyAnsLvl10_3.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl10_3.getText().toString().equals(getString(R.string.activityEasyGeoLevel10Ans2))) {
                textGeoEasyAnsLvl10_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl10_3);
            }else {
                textGeoEasyAnsLvl10_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl10_3);
            }
        });
        textGeoEasyAnsLvl10_4.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl10_4.getText().toString().equals(getString(R.string.activityEasyGeoLevel10Ans2))) {
                textGeoEasyAnsLvl10_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl10_4);
            }else {
                textGeoEasyAnsLvl10_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl10_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("GeoSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyGeoLevel11.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("GeoLevel", 1);
                    if (level > 10) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("GeoLevel", 11);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorGeoEasyLvl10.setVisibility(View.VISIBLE);
            textMonitorGeoEasyLvl10.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("GeoLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("GeoLevelFalse", level);
            editor.commit();
            textMonitorGeoEasyLvl10.setVisibility(View.VISIBLE);
            textMonitorGeoEasyLvl10.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorGeoEasyLvl10.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textGeoEasyAnsLvl10_1.setClickable(false);
        textGeoEasyAnsLvl10_2.setClickable(false);
        textGeoEasyAnsLvl10_3.setClickable(false);
        textGeoEasyAnsLvl10_4.setClickable(false);
    }
    public void setClickableTrue () {
        textGeoEasyAnsLvl10_1.setClickable(true);
        textGeoEasyAnsLvl10_2.setClickable(true);
        textGeoEasyAnsLvl10_3.setClickable(true);
        textGeoEasyAnsLvl10_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyGeoLevel10Ans1);
        listOfRandom.add(R.string.activityEasyGeoLevel10Ans2);
        listOfRandom.add(R.string.activityEasyGeoLevel10Ans3);
        listOfRandom.add(R.string.activityEasyGeoLevel10Ans4);
        Collections.shuffle(listOfRandom);
        textGeoEasyAnsLvl10_1.setText(listOfRandom.get(0));
        textGeoEasyAnsLvl10_2.setText(listOfRandom.get(1));
        textGeoEasyAnsLvl10_3.setText(listOfRandom.get(2));
        textGeoEasyAnsLvl10_4.setText(listOfRandom.get(3));
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ///////////////////////////////////////////
        //работа с музыкой
        SharedPreferences saveAAA = getSharedPreferences("AAA", MODE_PRIVATE);
        if (saveAAA.getInt("AAA", 1) == 0) {
        } else {
            startService(new Intent(this, MyService.class));
        }
        ///////////////////////////////////////////
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (flagMusic == false) {
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