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
import com.example.quiz.mathLevelsEasy.EasyMathLevel2;
import com.example.quiz.system.ActivityGeoEasy;
import com.example.quiz.system.ActivityMathematicsEasy;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;

public class EasyGeoLevel1 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textGeoEasyAnsLvl1_1, textGeoEasyAnsLvl1_2, textGeoEasyAnsLvl1_3, textGeoEasyAnsLvl1_4, textMonitorGeoEasyLvl1;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_geo_level1);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textGeoEasyAnsLvl1_1 = findViewById(R.id.textGeoEasyAnsLvl1_1);
        textGeoEasyAnsLvl1_2 = findViewById(R.id.textGeoEasyAnsLvl1_2);
        textGeoEasyAnsLvl1_3 = findViewById(R.id.textGeoEasyAnsLvl1_3);
        textGeoEasyAnsLvl1_4 = findViewById(R.id.textGeoEasyAnsLvl1_4);
        //Инициализация поля "монитор":
        textMonitorGeoEasyLvl1 = findViewById(R.id.textMonitorGeoEasyLvl1);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textGeoEasyAnsLvl1_1.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl1_1.getText().toString().equals(getString(R.string.activityEasyGeoLevel1Ans1))) {
                textGeoEasyAnsLvl1_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl1_1);
            } else {
                textGeoEasyAnsLvl1_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl1_1);
            }
        });
        textGeoEasyAnsLvl1_2.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl1_2.getText().toString().equals(getString(R.string.activityEasyGeoLevel1Ans1))) {
                textGeoEasyAnsLvl1_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl1_2);
            }else {
                textGeoEasyAnsLvl1_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl1_2);
            }
        });
        textGeoEasyAnsLvl1_3.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl1_3.getText().toString().equals(getString(R.string.activityEasyGeoLevel1Ans1))) {
                textGeoEasyAnsLvl1_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl1_3);
            }else {
                textGeoEasyAnsLvl1_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl1_3);
            }
        });
        textGeoEasyAnsLvl1_4.setOnClickListener(view -> {
            if (!textGeoEasyAnsLvl1_4.getText().toString().equals(getString(R.string.activityEasyGeoLevel1Ans1))) {
                textGeoEasyAnsLvl1_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textGeoEasyAnsLvl1_4);
            }else {
                textGeoEasyAnsLvl1_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textGeoEasyAnsLvl1_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("GeoSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyGeoLevel2.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("GeoLevel", 1);
                    if (level > 1) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("GeoLevel", 2);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorGeoEasyLvl1.setVisibility(View.VISIBLE);
            textMonitorGeoEasyLvl1.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("GeoLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("GeoLevelFalse", level);
            editor.commit();
            textMonitorGeoEasyLvl1.setVisibility(View.VISIBLE);
            textMonitorGeoEasyLvl1.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorGeoEasyLvl1.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textGeoEasyAnsLvl1_1.setClickable(false);
        textGeoEasyAnsLvl1_2.setClickable(false);
        textGeoEasyAnsLvl1_3.setClickable(false);
        textGeoEasyAnsLvl1_4.setClickable(false);
    }
    public void setClickableTrue () {
        textGeoEasyAnsLvl1_1.setClickable(true);
        textGeoEasyAnsLvl1_2.setClickable(true);
        textGeoEasyAnsLvl1_3.setClickable(true);
        textGeoEasyAnsLvl1_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyGeoLevel1Ans1);
        listOfRandom.add(R.string.activityEasyGeoLevel1Ans2);
        listOfRandom.add(R.string.activityEasyGeoLevel1Ans3);
        listOfRandom.add(R.string.activityEasyGeoLevel1Ans4);
        Collections.shuffle(listOfRandom);
        textGeoEasyAnsLvl1_1.setText(listOfRandom.get(0));
        textGeoEasyAnsLvl1_2.setText(listOfRandom.get(1));
        textGeoEasyAnsLvl1_3.setText(listOfRandom.get(2));
        textGeoEasyAnsLvl1_4.setText(listOfRandom.get(3));
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