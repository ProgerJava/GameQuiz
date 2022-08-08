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

public class EasyGeoLevel11 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textGeoEasyAnsLvl11_1, textGeoEasyAnsLvl11_2, textGeoEasyAnsLvl11_3, textGeoEasyAnsLvl11_4, textMonitorGeoEasyLvl11;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_geo_level11);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textGeoEasyAnsLvl11_1 = findViewById(R.id.textGeoEasyAnsLvl11_1);
        textGeoEasyAnsLvl11_2 = findViewById(R.id.textGeoEasyAnsLvl11_2);
        textGeoEasyAnsLvl11_3 = findViewById(R.id.textGeoEasyAnsLvl11_3);
        textGeoEasyAnsLvl11_4 = findViewById(R.id.textGeoEasyAnsLvl11_4);
        //Инициализация поля "монитор":
        textMonitorGeoEasyLvl11 = findViewById(R.id.textMonitorGeoEasyLvl11);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textGeoEasyAnsLvl11_1.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl11_1.getText().toString().equals(getString(R.string.activityEasyGeoLevel11Ans4))) {
                textGeoEasyAnsLvl11_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl11_1);
            } else {
                textGeoEasyAnsLvl11_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl11_1);
            }
        });
        textGeoEasyAnsLvl11_2.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl11_2.getText().toString().equals(getString(R.string.activityEasyGeoLevel11Ans4))) {
                textGeoEasyAnsLvl11_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl11_2);
            }else {
                textGeoEasyAnsLvl11_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl11_2);
            }
        });
        textGeoEasyAnsLvl11_3.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl11_3.getText().toString().equals(getString(R.string.activityEasyGeoLevel11Ans4))) {
                textGeoEasyAnsLvl11_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl11_3);
            }else {
                textGeoEasyAnsLvl11_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl11_3);
            }
        });
        textGeoEasyAnsLvl11_4.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl11_4.getText().toString().equals(getString(R.string.activityEasyGeoLevel11Ans4))) {
                textGeoEasyAnsLvl11_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl11_4);
            }else {
                textGeoEasyAnsLvl11_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl11_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("GeoSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyGeoLevel12.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("GeoLevel", 1);
                    if (level > 11) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("GeoLevel", 12);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorGeoEasyLvl11.setVisibility(View.VISIBLE);
            textMonitorGeoEasyLvl11.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("GeoLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("GeoLevelFalse", level);
            editor.commit();
            textMonitorGeoEasyLvl11.setVisibility(View.VISIBLE);
            textMonitorGeoEasyLvl11.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorGeoEasyLvl11.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textGeoEasyAnsLvl11_1.setClickable(false);
        textGeoEasyAnsLvl11_2.setClickable(false);
        textGeoEasyAnsLvl11_3.setClickable(false);
        textGeoEasyAnsLvl11_4.setClickable(false);
    }
    public void setClickableTrue () {
        textGeoEasyAnsLvl11_1.setClickable(true);
        textGeoEasyAnsLvl11_2.setClickable(true);
        textGeoEasyAnsLvl11_3.setClickable(true);
        textGeoEasyAnsLvl11_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyGeoLevel11Ans1);
        listOfRandom.add(R.string.activityEasyGeoLevel11Ans2);
        listOfRandom.add(R.string.activityEasyGeoLevel11Ans3);
        listOfRandom.add(R.string.activityEasyGeoLevel11Ans4);
        Collections.shuffle(listOfRandom);
        textGeoEasyAnsLvl11_1.setText(listOfRandom.get(0));
        textGeoEasyAnsLvl11_2.setText(listOfRandom.get(1));
        textGeoEasyAnsLvl11_3.setText(listOfRandom.get(2));
        textGeoEasyAnsLvl11_4.setText(listOfRandom.get(3));
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