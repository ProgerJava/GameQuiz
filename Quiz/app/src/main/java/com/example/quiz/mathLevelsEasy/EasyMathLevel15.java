package com.example.quiz.mathLevelsEasy;

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
import com.example.quiz.system.ActivityMathematicsEasy;
import com.example.quiz.system.ArrayOfMonitorsSet;
import com.example.quiz.system.MyService;

import java.util.ArrayList;
import java.util.Collections;

public class EasyMathLevel15 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView imageBack, textMathEasyAnsLvl15_1, textMathEasyAnsLvl15_2, textMathEasyAnsLvl15_3, textMathEasyAnsLvl15_4, textMonitorMathEasyLvl15;
    private Handler handler;
    private ArrayList<Integer> listOfRandom;
    private boolean flagMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_math_level15);
        //Инициализация поля "назад":
        imageBack = findViewById(R.id.imageBack);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализаци ответов на вопросы:
        textMathEasyAnsLvl15_1 = findViewById(R.id.textMathEasyAnsLvl15_1);
        textMathEasyAnsLvl15_2 = findViewById(R.id.textMathEasyAnsLvl15_2);
        textMathEasyAnsLvl15_3 = findViewById(R.id.textMathEasyAnsLvl15_3);
        textMathEasyAnsLvl15_4 = findViewById(R.id.textMathEasyAnsLvl15_4);
        //Инициализация поля "монитор":
        textMonitorMathEasyLvl15 = findViewById(R.id.textMonitorMathEasyLvl15);
        //Handler:
        handler = new Handler();
        flagMusic = false;


        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMathematicsEasy.class);
            startActivity(intent);
            flagMusic = true;
        });
        textMathEasyAnsLvl15_1.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl15_1.getText().toString().equals(getString(R.string.activityEasyMathLevel15Ans1))) {
                textMathEasyAnsLvl15_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl15_1);
            } else {
                textMathEasyAnsLvl15_1.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl15_1);
            }
        });
        textMathEasyAnsLvl15_2.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl15_2.getText().toString().equals(getString(R.string.activityEasyMathLevel15Ans1))) {
                textMathEasyAnsLvl15_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl15_2);
            }else {
                textMathEasyAnsLvl15_2.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl15_2);
            }
        });
        textMathEasyAnsLvl15_3.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl15_3.getText().toString().equals(getString(R.string.activityEasyMathLevel15Ans1))) {
                textMathEasyAnsLvl15_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl15_3);
            }else {
                textMathEasyAnsLvl15_3.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl15_3);
            }
        });
        textMathEasyAnsLvl15_4.setOnClickListener(view -> {
            if (!textMathEasyAnsLvl15_4.getText().toString().equals(getString(R.string.activityEasyMathLevel15Ans1))) {
                textMathEasyAnsLvl15_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_false));
                monitorSetText(false, textMathEasyAnsLvl15_4);
            }else {
                textMathEasyAnsLvl15_4.setBackground(getDrawable(R.drawable.style_buttons_math_easy_true));
                monitorSetText(true, textMathEasyAnsLvl15_4);
            }
        });

    }
    public void monitorSetText (boolean flag, TextView textNum) {
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        ArrayOfMonitorsSet arrayOfMonitorsSet = new ArrayOfMonitorsSet();
        Intent intent = new Intent(this, EasyMathLevel16.class);
        int numberOfArray = (int) (Math.random()*6);
        setClickableFalse();
        if (flag == true) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    startActivity(intent);
                    flagMusic = true;
                    final int level = save.getInt("Level", 1);
                    if (level > 15) {

                    } else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level", 16);
                        editor.commit();
                    }
                }
            }, 700);
            textMonitorMathEasyLvl15.setVisibility(View.VISIBLE);
            textMonitorMathEasyLvl15.setText(arrayOfMonitorsSet.arrayOfTrue[numberOfArray]);
        } else if (flag == false) {
            int level = save.getInt("LevelFalse", 0);
            level++;
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("LevelFalse", level);
            editor.commit();
            textMonitorMathEasyLvl15.setVisibility(View.VISIBLE);
            textMonitorMathEasyLvl15.setText(arrayOfMonitorsSet.arrayOfFalse[numberOfArray]);
            handler.postDelayed(new Runnable() {
                public void run() {
                    textNum.setBackgroundResource(R.drawable.style_buttons_math_easy);
                    textMonitorMathEasyLvl15.setVisibility(View.INVISIBLE);
                    setClickableTrue();
                    setListOfRandom();
                }
            }, 700);

        }
    }

    public void setClickableFalse () {
        textMathEasyAnsLvl15_1.setClickable(false);
        textMathEasyAnsLvl15_2.setClickable(false);
        textMathEasyAnsLvl15_3.setClickable(false);
        textMathEasyAnsLvl15_4.setClickable(false);
    }
    public void setClickableTrue () {
        textMathEasyAnsLvl15_1.setClickable(true);
        textMathEasyAnsLvl15_2.setClickable(true);
        textMathEasyAnsLvl15_3.setClickable(true);
        textMathEasyAnsLvl15_4.setClickable(true);
    }

    public void setListOfRandom () {
        listOfRandom = new ArrayList<>();
        listOfRandom.add(R.string.activityEasyMathLevel15Ans1);
        listOfRandom.add(R.string.activityEasyMathLevel15Ans2);
        listOfRandom.add(R.string.activityEasyMathLevel15Ans3);
        listOfRandom.add(R.string.activityEasyMathLevel15Ans4);
        Collections.shuffle(listOfRandom);
        textMathEasyAnsLvl15_1.setText(listOfRandom.get(0));
        textMathEasyAnsLvl15_2.setText(listOfRandom.get(1));
        textMathEasyAnsLvl15_3.setText(listOfRandom.get(2));
        textMathEasyAnsLvl15_4.setText(listOfRandom.get(3));
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }
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