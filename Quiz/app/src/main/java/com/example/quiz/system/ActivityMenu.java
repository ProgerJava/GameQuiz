package com.example.quiz.system;

import static com.example.quiz.Const.LVL_BIO_EASY;
import static com.example.quiz.Const.LVL_BIO_HARD;
import static com.example.quiz.Const.LVL_BIO_NORMAL;
import static com.example.quiz.Const.LVL_GEO_EASY;
import static com.example.quiz.Const.LVL_GEO_HARD;
import static com.example.quiz.Const.LVL_GEO_NORMAL;
import static com.example.quiz.Const.LVL_MATH_EASY;
import static com.example.quiz.Const.LVL_MATH_HARD;
import static com.example.quiz.Const.LVL_MATH_NORMAL;
import static com.example.quiz.Const.LVL_PH_EASY;
import static com.example.quiz.Const.LVL_PH_HARD;
import static com.example.quiz.Const.LVL_PH_NORMAL;

import androidx.annotation.RequiresApi;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.ui.activity.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ActivityMenu extends BaseActivity {
    private Animation animationEasy, animationNormal, animationHard;
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
        //Установка таймера:
        timer = new Timer();

        imageBackActMenu.setOnClickListener(view -> {
            startLevel(MainActivity.class);
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
            startLevel(ActivityMathematicsEasy.class);
            dialogMath.dismiss();
        });
        mathlevelNormal.setOnClickListener(view -> {
            startLevel(ActivityMathematicsNormal.class);
            dialogMath.dismiss();
        });
        mathlevelHard.setOnClickListener(view -> {
            startLevel(ActivityMathematicsHard.class);
            dialogMath.dismiss();
        });
        geoLevelEasy.setOnClickListener(view -> {
            startLevel(ActivityGeoEasy.class);
            dialogMath.dismiss();
        });
        geoLevelNormal.setOnClickListener(view -> {
            startLevel(ActivityGeoNormal.class);
            dialogMath.dismiss();
        });
        geoLevelHard.setOnClickListener(view -> {
            startLevel(ActivityGeoHard.class);
            dialogMath.dismiss();
        });
        phLevelEasy.setOnClickListener(view -> {
            startLevel(ActivityPhEasy.class);
            dialogMath.dismiss();
        });
        phLevelNormal.setOnClickListener(view -> {
            startLevel(ActivityPhNormal.class);
            dialogMath.dismiss();
        });
        phLevelHard.setOnClickListener(view -> {
            startLevel(ActivityPhHard.class);
            dialogMath.dismiss();
        });
        bioLevelEasy.setOnClickListener(view -> {
            startLevel(ActivityBioEasy.class);
            dialogMath.dismiss();
        });
        bioLevelNormal.setOnClickListener(view -> {
            startLevel(ActivityBioNormal.class);
            dialogMath.dismiss();
        });
        bioLevelHard.setOnClickListener(view -> {
            startLevel(ActivityBioHard.class);
            dialogMath.dismiss();
        });

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onResume() {
        super.onResume();
        imageCloud1.startAnimation(animationCloud1);
        imageCloud2.startAnimation(animationCloud2);
        setProgress(getSp().getInt(LVL_BIO_EASY, 1), getSp().getInt(LVL_BIO_NORMAL, 1), getSp().getInt(LVL_BIO_HARD, 1), countBio, progressBarBio);
        setProgress (getSp().getInt(LVL_GEO_EASY, 1), getSp().getInt(LVL_GEO_NORMAL, 1), getSp().getInt(LVL_GEO_HARD, 1), countGeo, progressBarGeo);
        setProgress (getSp().getInt(LVL_MATH_EASY, 1), getSp().getInt(LVL_MATH_NORMAL, 1), getSp().getInt(LVL_MATH_HARD, 1), countMath, progressBarMath);
        setProgress (getSp().getInt(LVL_PH_EASY, 1), getSp().getInt(LVL_PH_NORMAL, 1), getSp().getInt(LVL_PH_HARD, 1), countPh, progressBarPh);
    }

    public void setProgress( int level, int level1, int level2, int count, ProgressBar bar) {
        if (level != 1) count+=level;
        if (level1 != 1) count += level1;
        if (level2 != 1) count +=level2;

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

}