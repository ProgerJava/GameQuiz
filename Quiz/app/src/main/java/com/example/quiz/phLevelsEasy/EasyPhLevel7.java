package com.example.quiz.phLevelsEasy;

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
import com.example.quiz.system.ActivityPhEasy;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;

public class EasyPhLevel7 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textPhEasyAnsLvl7_1, textPhEasyAnsLvl7_2, textPhEasyAnsLvl7_3, textPhEasyAnsLvl7_4, textMonitorPhEasyLvl7;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_ph_level7);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textPhEasyAnsLvl7_1 = findViewById(R.id.textPhEasyAnsLvl7_1);
        textPhEasyAnsLvl7_2 = findViewById(R.id.textPhEasyAnsLvl7_2);
        textPhEasyAnsLvl7_3 = findViewById(R.id.textPhEasyAnsLvl7_3);
        textPhEasyAnsLvl7_4 = findViewById(R.id.textPhEasyAnsLvl7_4);
        //Инициализация поля "монитор":
        textMonitorPhEasyLvl7 = findViewById(R.id.textMonitorPhEasyLvl7);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityPhEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textPhEasyAnsLvl7_1.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl7_1.getText().toString().equals(getString(R.string.activityEasyPhLevel7Ans1))) {
                textPhEasyAnsLvl7_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl7_1);
            } else {
                textPhEasyAnsLvl7_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl7_1);
            }
        });
        textPhEasyAnsLvl7_2.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl7_2.getText().toString().equals(getString(R.string.activityEasyPhLevel7Ans1))) {
                textPhEasyAnsLvl7_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl7_2);
            }else {
                textPhEasyAnsLvl7_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl7_2);
            }
        });
        textPhEasyAnsLvl7_3.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl7_3.getText().toString().equals(getString(R.string.activityEasyPhLevel7Ans1))) {
                textPhEasyAnsLvl7_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl7_3);
            }else {
                textPhEasyAnsLvl7_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl7_3);
            }
        });
        textPhEasyAnsLvl7_4.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl7_4.getText().toString().equals(getString(R.string.activityEasyPhLevel7Ans1))) {
                textPhEasyAnsLvl7_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl7_4);
            }else {
                textPhEasyAnsLvl7_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl7_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("PhSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyPhLevel8.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("PhLevel", 1);
                    if (level > 7) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("PhLevel", 8);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorPhEasyLvl7.setVisibility(View.VISIBLE);
            textMonitorPhEasyLvl7.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("PhLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("PhLevelFalse", level);
            editor.commit();
            textMonitorPhEasyLvl7.setVisibility(View.VISIBLE);
            textMonitorPhEasyLvl7.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorPhEasyLvl7.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textPhEasyAnsLvl7_1.setClickable(false);
        textPhEasyAnsLvl7_2.setClickable(false);
        textPhEasyAnsLvl7_3.setClickable(false);
        textPhEasyAnsLvl7_4.setClickable(false);
    }
    public void setClickableTrue () {
        textPhEasyAnsLvl7_1.setClickable(true);
        textPhEasyAnsLvl7_2.setClickable(true);
        textPhEasyAnsLvl7_3.setClickable(true);
        textPhEasyAnsLvl7_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyPhLevel7Ans1);
        listOfRandom.add(R.string.activityEasyPhLevel7Ans2);
        listOfRandom.add(R.string.activityEasyPhLevel7Ans3);
        listOfRandom.add(R.string.activityEasyPhLevel7Ans4);
        Collections.shuffle(listOfRandom);
        textPhEasyAnsLvl7_1.setText(listOfRandom.get(0));
        textPhEasyAnsLvl7_2.setText(listOfRandom.get(1));
        textPhEasyAnsLvl7_3.setText(listOfRandom.get(2));
        textPhEasyAnsLvl7_4.setText(listOfRandom.get(3));
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