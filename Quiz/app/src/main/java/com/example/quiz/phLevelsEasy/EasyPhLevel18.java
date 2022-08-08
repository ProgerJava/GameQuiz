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

public class EasyPhLevel18 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textPhEasyAnsLvl18_1, textPhEasyAnsLvl18_2, textPhEasyAnsLvl18_3, textPhEasyAnsLvl18_4, textMonitorPhEasyLvl18;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_ph_level18);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textPhEasyAnsLvl18_1 = findViewById(R.id.textPhEasyAnsLvl18_1);
        textPhEasyAnsLvl18_2 = findViewById(R.id.textPhEasyAnsLvl18_2);
        textPhEasyAnsLvl18_3 = findViewById(R.id.textPhEasyAnsLvl18_3);
        textPhEasyAnsLvl18_4 = findViewById(R.id.textPhEasyAnsLvl18_4);
        //Инициализация поля "монитор":
        textMonitorPhEasyLvl18 = findViewById(R.id.textMonitorPhEasyLvl18);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityPhEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textPhEasyAnsLvl18_1.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl18_1.getText().toString().equals(getString(R.string.activityEasyPhLevel18Ans3))) {
                textPhEasyAnsLvl18_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl18_1);
            } else {
                textPhEasyAnsLvl18_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl18_1);
            }
        });
        textPhEasyAnsLvl18_2.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl18_2.getText().toString().equals(getString(R.string.activityEasyPhLevel18Ans3))) {
                textPhEasyAnsLvl18_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl18_2);
            }else {
                textPhEasyAnsLvl18_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl18_2);
            }
        });
        textPhEasyAnsLvl18_3.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl18_3.getText().toString().equals(getString(R.string.activityEasyPhLevel18Ans3))) {
                textPhEasyAnsLvl18_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl18_3);
            }else {
                textPhEasyAnsLvl18_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl18_3);
            }
        });
        textPhEasyAnsLvl18_4.setOnClickListener(view -> {
            if (!textPhEasyAnsLvl18_4.getText().toString().equals(getString(R.string.activityEasyPhLevel18Ans3))) {
                textPhEasyAnsLvl18_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textPhEasyAnsLvl18_4);
            }else {
                textPhEasyAnsLvl18_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textPhEasyAnsLvl18_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("PhSave", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyPhLevel19.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("PhLevel", 1);
                    if (level > 18) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("PhLevel", 19);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorPhEasyLvl18.setVisibility(View.VISIBLE);
            textMonitorPhEasyLvl18.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("PhLevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("PhLevelFalse", level);
            editor.commit();
            textMonitorPhEasyLvl18.setVisibility(View.VISIBLE);
            textMonitorPhEasyLvl18.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorPhEasyLvl18.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textPhEasyAnsLvl18_1.setClickable(false);
        textPhEasyAnsLvl18_2.setClickable(false);
        textPhEasyAnsLvl18_3.setClickable(false);
        textPhEasyAnsLvl18_4.setClickable(false);
    }
    public void setClickableTrue () {
        textPhEasyAnsLvl18_1.setClickable(true);
        textPhEasyAnsLvl18_2.setClickable(true);
        textPhEasyAnsLvl18_3.setClickable(true);
        textPhEasyAnsLvl18_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyPhLevel18Ans1);
        listOfRandom.add(R.string.activityEasyPhLevel18Ans2);
        listOfRandom.add(R.string.activityEasyPhLevel18Ans3);
        listOfRandom.add(R.string.activityEasyPhLevel18Ans4);
        Collections.shuffle(listOfRandom);
        textPhEasyAnsLvl18_1.setText(listOfRandom.get(0));
        textPhEasyAnsLvl18_2.setText(listOfRandom.get(1));
        textPhEasyAnsLvl18_3.setText(listOfRandom.get(2));
        textPhEasyAnsLvl18_4.setText(listOfRandom.get(3));
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