package com.example.quiz.system;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;

import java.util.Timer;
import java.util.TimerTask;

public class ActivityMenu extends AppCompatActivity {
    private Animation animationEasy, animationNormal, animationHard;
    private long backPressedTime;
    private Toast backToast;
    private ImageView imageCloud1, imageCloud2;
    private TextView imageBackActMenu;
    private Button buttonMathematics, buttonGeography, buttonPhysics, buttonBiology;
    private Animation animationCloud1, animationCloud2;
    private Dialog dialogMath, dialogGeo, dialogPh, dialogBio;
    private TextView mathlevelEasy, mathlevelNormal, mathlevelHard, geoLevelEasy, geoLevelNormal, geoLevelHard, phLevelEasy, phLevelNormal, phLevelHard,bioLevelEasy, bioLevelNormal, bioLevelHard;
    private ProgressBar progressBarMath, progressBarGeo, progressBarBio, progressBarPh;
    private Timer timer;
    private int countMath = 0;
    private int countGeo = 0;
    private int countPh = 0;
    private int countBio = 0;
    private boolean flag;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Окно прогресса:
        progressBarMath = findViewById(R.id.progressBar);
        progressBarGeo = findViewById(R.id.progressBar2);
        progressBarBio = findViewById(R.id.progressBar4);
        progressBarPh = findViewById(R.id.progressBar3);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Диалоговое окно при нажатии на кнопку "математика":
        dialogMath = new Dialog(this);
        dialogMath.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogMath.setContentView(R.layout.activity_dialog_window_math_enh);
        dialogMath.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "география":
        dialogGeo = new Dialog(this);
        dialogGeo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGeo.setContentView(R.layout.activity_dialog_window_geo_enh);
        dialogGeo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "физика":
        dialogPh = new Dialog(this);
        dialogPh.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPh.setContentView(R.layout.activity_dialog_window_ph_enh);
        dialogPh.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "биология":
        dialogBio = new Dialog(this);
        dialogBio.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBio.setContentView(R.layout.activity_dialog_window_bio_enh);
        dialogBio.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Создание анимации:
        animationCloud1 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud);
        animationCloud2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud2);
        //Анимация диалогового окна:
        animationEasy = AnimationUtils.loadAnimation(this, R.anim.anim_easy);
        animationNormal = AnimationUtils.loadAnimation(this, R.anim.anim_normal);
        animationHard = AnimationUtils.loadAnimation(this, R.anim.anim_hard);
        //Инициализация кнопки "назад":
        imageBackActMenu = findViewById(R.id.imageBackActMenu);
        //Инициализация кнопки "buttonMathematics":
        buttonMathematics = findViewById(R.id.buttonMathematics);
        buttonGeography = findViewById(R.id.buttonGeography);
        buttonPhysics = findViewById(R.id.buttonPhysics);
        buttonBiology = findViewById(R.id.buttonBiology);
        //Инициализация облаков:
        imageCloud1 = findViewById(R.id.imageCloud1ActMenu);
        imageCloud2 = findViewById(R.id.imageCloud2ActMenu);
        //Идентификация режимов:
        mathlevelEasy = dialogMath.findViewById(R.id.MathlevelEasy);
        mathlevelNormal = dialogMath.findViewById(R.id.MathlevelNormal);
        mathlevelHard = dialogMath.findViewById(R.id.MathlevelHard);
        geoLevelEasy = dialogGeo.findViewById(R.id.GeolevelEasy);
        geoLevelNormal = dialogGeo.findViewById(R.id.GeolevelNormal);
        geoLevelHard = dialogGeo.findViewById(R.id.GeolevelHard);
        phLevelEasy = dialogPh.findViewById(R.id.PhlevelEasy);
        phLevelNormal = dialogPh.findViewById(R.id.PhlevelNormal);
        phLevelHard = dialogPh.findViewById(R.id.PhlevelHard);
        bioLevelEasy = dialogBio.findViewById(R.id.BiolevelEasy);
        bioLevelNormal = dialogBio.findViewById(R.id.BiolevelNormal);
        bioLevelHard = dialogBio.findViewById(R.id.BiolevelHard);
        flag = false;
        //Установка таймера:
        timer = new Timer();
        SharedPreferences saveMath = getSharedPreferences("Save", MODE_PRIVATE);
        SharedPreferences saveMath1 = getSharedPreferences("SaveNormal", MODE_PRIVATE);
        SharedPreferences saveMath2 = getSharedPreferences("SaveHard", MODE_PRIVATE);
        setProgress(saveMath.getInt("Level", 1), saveMath1.getInt("LevelNormal", 1), saveMath2.getInt("LevelHard", 1), countMath, progressBarMath);
        SharedPreferences saveGeo = getSharedPreferences("GeoSave", MODE_PRIVATE);
        SharedPreferences saveGeo1 = getSharedPreferences("GeoSaveNormal", MODE_PRIVATE);
        SharedPreferences saveGeo2 = getSharedPreferences("GeoSaveHard", MODE_PRIVATE);
        setProgress (saveGeo.getInt("GeoLevel", 1), saveGeo1.getInt("GeoLevelNormal", 1), saveGeo2.getInt("GeoLevelHard", 1), countGeo, progressBarGeo);
        SharedPreferences savePh = getSharedPreferences("PhSave", MODE_PRIVATE);
        SharedPreferences savePh1 = getSharedPreferences("PhSaveNormal", MODE_PRIVATE);
        SharedPreferences savePh2 = getSharedPreferences("PhSaveHard", MODE_PRIVATE);
        setProgress (savePh.getInt("PhLevel", 1), savePh1.getInt("PhLevelNormal", 1), savePh2.getInt("PhLevelHard", 1), countPh, progressBarPh);
        SharedPreferences saveBio = getSharedPreferences("BioSave", MODE_PRIVATE);
        SharedPreferences saveBio1 = getSharedPreferences("BioSaveNormal", MODE_PRIVATE);
        SharedPreferences saveBio2 = getSharedPreferences("BioSaveHard", MODE_PRIVATE);
        setProgress (saveBio.getInt("BioLevel", 1), saveBio1.getInt("BioLevelNormal", 1), saveBio2.getInt("BioLevelHard", 1), countBio, progressBarBio);



        imageBackActMenu.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            flag = true;
        });
        buttonMathematics.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                timer.schedule(new TimerTask() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void run() {
                        countMath++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (countMath >= 2) {
                                    progressBarMath.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                },0, 500);
            }
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                dialogWindowMath();
                timer.cancel();
                timer = new Timer();
                countMath = 0;
                progressBarMath.setVisibility(View.INVISIBLE);
            }
            return false;
        });
        buttonGeography.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                timer.schedule(new TimerTask() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void run() {
                        countGeo++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (countGeo >= 2) {
                                    progressBarGeo.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                },0, 500);
            }
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                dialogWindowGeo();
                timer.cancel();
                timer = new Timer();
                countGeo = 0;
                progressBarGeo.setVisibility(View.INVISIBLE);
            }
            return false;
        });
        buttonPhysics.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                timer.schedule(new TimerTask() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void run() {
                        countPh++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (countPh >= 2) {
                                    progressBarPh.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                },0, 500);
            }
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                dialogWindowPh();
                timer.cancel();
                timer = new Timer();
                countPh = 0;
                progressBarPh.setVisibility(View.INVISIBLE);
            }
            return false;
        });
        buttonBiology.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                timer.schedule(new TimerTask() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void run() {
                        countBio++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (countBio >= 2) {
                                    progressBarBio.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }
                },0, 500);
            }
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                dialogWindowBio();
                timer.cancel();
                timer = new Timer();
                countBio = 0;
                progressBarBio.setVisibility(View.INVISIBLE);
            }
            return false;
        });

        mathlevelEasy.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityMathematicsEasy.class);
            startActivity(intent);
            dialogMath.dismiss();
            flag = true;
        });
        mathlevelNormal.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityMathematicsNormal.class);
            startActivity(intent);
            dialogMath.dismiss();
            flag = true;
        });
        mathlevelHard.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityMathematicsHard.class);
            startActivity(intent);
            dialogMath.dismiss();
            flag = true;
        });
        geoLevelEasy.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityGeoEasy.class);
            startActivity(intent);
            dialogGeo.dismiss();
            flag = true;
        });
        geoLevelNormal.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityGeoNormal.class);
            startActivity(intent);
            dialogGeo.dismiss();
            flag = true;
        });
        geoLevelHard.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityGeoHard.class);
            startActivity(intent);
            dialogGeo.dismiss();
            flag = true;
        });
        phLevelEasy.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityPhEasy.class);
            startActivity(intent);
            dialogPh.dismiss();
            flag = true;
        });
        phLevelNormal.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityPhNormal.class);
            startActivity(intent);
            dialogPh.dismiss();
            flag = true;
        });
        phLevelHard.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityPhHard.class);
            startActivity(intent);
            dialogPh.dismiss();
            flag = true;
        });
        bioLevelEasy.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityBioEasy.class);
            startActivity(intent);
            dialogBio.dismiss();
            flag = true;
        });
        bioLevelNormal.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityBioNormal.class);
            startActivity(intent);
            dialogBio.dismiss();
            flag = true;
        });
        bioLevelHard.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityMenu.this, ActivityBioHard.class);
            startActivity(intent);
            dialogBio.dismiss();
            flag = true;
        });


    }
    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
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

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onResume() {
        super.onResume();
        imageCloud1.startAnimation(animationCloud1);
        imageCloud2.startAnimation(animationCloud2);
        SharedPreferences saveMath = getSharedPreferences("Save", MODE_PRIVATE);
        SharedPreferences saveMath1 = getSharedPreferences("SaveNormal", MODE_PRIVATE);
        SharedPreferences saveMath2 = getSharedPreferences("SaveHard", MODE_PRIVATE);
        setProgress(saveMath.getInt("Level", 1), saveMath1.getInt("LevelNormal", 1), saveMath2.getInt("LevelHard", 1), countMath, progressBarMath);
        SharedPreferences saveGeo = getSharedPreferences("GeoSave", MODE_PRIVATE);
        SharedPreferences saveGeo1 = getSharedPreferences("GeoSaveNormal", MODE_PRIVATE);
        SharedPreferences saveGeo2 = getSharedPreferences("GeoSaveHard", MODE_PRIVATE);
        setProgress (saveGeo.getInt("GeoLevel", 1), saveGeo1.getInt("GeoLevelNormal", 1), saveGeo2.getInt("GeoLevelHard", 1), countGeo, progressBarGeo);
        SharedPreferences savePh = getSharedPreferences("PhSave", MODE_PRIVATE);
        SharedPreferences savePh1 = getSharedPreferences("PhSaveNormal", MODE_PRIVATE);
        SharedPreferences savePh2 = getSharedPreferences("PhSaveHard", MODE_PRIVATE);
        setProgress (savePh.getInt("PhLevel", 1), savePh1.getInt("PhLevelNormal", 1), savePh2.getInt("PhLevelHard", 1), countPh, progressBarPh);
        SharedPreferences saveBio = getSharedPreferences("BioSave", MODE_PRIVATE);
        SharedPreferences saveBio1 = getSharedPreferences("BioSaveNormal", MODE_PRIVATE);
        SharedPreferences saveBio2 = getSharedPreferences("BioSaveHard", MODE_PRIVATE);
        setProgress (saveBio.getInt("BioLevel", 1), saveBio1.getInt("BioLevelNormal", 1), saveBio2.getInt("BioLevelHard", 1), countBio, progressBarBio);

        ///////////////////////////////////////////
        //работа с музыкой
        SharedPreferences saveAAA = getSharedPreferences("AAA", MODE_PRIVATE);
        if (saveAAA.getInt("AAA", 1) == 0) {
        } else {
            startService(new Intent(this, MyService.class));
        }
        ///////////////////////////////////////////
    }

    public void setProgress( int level, int level1, int level2, int count, ProgressBar bar) {
        if (level != 1) {
            for (int i = 1; i <= level; i++) {
                count++;
            }
        }
        if (level1 != 1) {
            for (int i = 1; i <= level1; i++) {
                count++;
            }
        }
        if (level2 != 1) {
            for (int i = 1; i <= level2; i++) {
                count++;
            }
        }
        bar.setProgress(count);

        if (bar.getProgress() == 60) {
            bar.setProgressDrawable(getDrawable(R.drawable.style_progress_win));
        }
    }

    public void dialogWindowMath () {
        dialogMath.show();
        mathlevelEasy.startAnimation(animationEasy);
        mathlevelNormal.startAnimation(animationNormal);
        mathlevelHard.startAnimation(animationHard);
    }
    public void dialogWindowGeo () {
        dialogGeo.show();
        geoLevelEasy.startAnimation(animationEasy);
        geoLevelNormal.startAnimation(animationNormal);
        geoLevelHard.startAnimation(animationHard);
    }
    public void dialogWindowPh () {
        dialogPh.show();
        phLevelEasy.startAnimation(animationEasy);
        phLevelNormal.startAnimation(animationNormal);
        phLevelHard.startAnimation(animationHard);
    }
    public void dialogWindowBio () {
        dialogBio.show();
        bioLevelEasy.startAnimation(animationEasy);
        bioLevelNormal.startAnimation(animationNormal);
        bioLevelHard.startAnimation(animationHard);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (flag == false) {
            stopService(new Intent(this, MyService.class));
        }
    }


}