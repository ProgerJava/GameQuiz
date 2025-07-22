package com.example.quiz.system;

import static com.example.quiz.Const.LVL_GEO_EASY;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel1;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel10;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel11;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel12;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel13;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel14;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel15;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel16;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel17;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel18;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel19;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel2;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel20;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel3;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel4;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel5;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel6;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel7;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel8;
import com.example.quiz.geoLevelsEasy.EasyGeoLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityGeoEasy extends BaseActivity {

    private ImageView imageCloudGeo1, imageCloudGeo2;
    private TextView imageBack;
    private TextView easyGeolevel1, easyGeolevel2, easyGeolevel3, easyGeolevel4, easyGeolevel5, easyGeolevel6, easyGeolevel7, easyGeolevel8, easyGeolevel9, easyGeolevel10, easyGeolevel11, easyGeolevel12, easyGeolevel13, easyGeolevel14, easyGeolevel15, easyGeolevel16, easyGeolevel17, easyGeolevel18, easyGeolevel19, easyGeolevel20;
    private Animation animationCloudGeo1, animationCloudGeo2;
    private ImageButton imageRestartEasyGeo, imageDiagramEasyGeo;
    private Dialog dialogGeoEasyRestart, dialogGeoEasyDiagram;
    private TextView GeolevelEasyRestartYes, GeolevelEasyRestartNo;
    private TextView decided, errors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_level_easy);
        //Сохрание игры:
        final int level = getSp().getInt(LVL_GEO_EASY, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogGeoEasyRestart = new Dialog(this);
        dialogGeoEasyRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGeoEasyRestart.setContentView(R.layout.activity_dialog_window_geo_easy_restart);
        dialogGeoEasyRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogGeoEasyDiagram = new Dialog(this);
        dialogGeoEasyDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGeoEasyDiagram.setContentView(R.layout.activity_dialog_window_geo_easy_diagram);
        dialogGeoEasyDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        GeolevelEasyRestartYes = dialogGeoEasyRestart.findViewById(R.id.GeolevelEasyRestartYes);
        GeolevelEasyRestartNo = dialogGeoEasyRestart.findViewById(R.id.GeolevelEasyRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogGeoEasyDiagram.findViewById(R.id.decided);
        errors = dialogGeoEasyDiagram.findViewById(R.id.errors);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация облаков:
        imageCloudGeo1 = findViewById(R.id.imageCloudGeo1);
        imageCloudGeo2 = findViewById(R.id.imageCloudGeo2);
        //Кнопки перехода на уровни:
        easyGeolevel1 = findViewById(R.id.EasyGeolevel1);
        easyGeolevel2 = findViewById(R.id.EasyGeolevel2);
        easyGeolevel3 = findViewById(R.id.EasyGeolevel3);
        easyGeolevel4 = findViewById(R.id.EasyGeolevel4);
        easyGeolevel5 = findViewById(R.id.EasyGeolevel5);
        easyGeolevel6 = findViewById(R.id.EasyGeolevel6);
        easyGeolevel7 = findViewById(R.id.EasyGeolevel7);
        easyGeolevel8 = findViewById(R.id.EasyGeolevel8);
        easyGeolevel9 = findViewById(R.id.EasyGeolevel9);
        easyGeolevel10 = findViewById(R.id.EasyGeolevel10);
        easyGeolevel11 = findViewById(R.id.EasyGeolevel11);
        easyGeolevel12 = findViewById(R.id.EasyGeolevel12);
        easyGeolevel13 = findViewById(R.id.EasyGeolevel13);
        easyGeolevel14 = findViewById(R.id.EasyGeolevel14);
        easyGeolevel15 = findViewById(R.id.EasyGeolevel15);
        easyGeolevel16 = findViewById(R.id.EasyGeolevel16);
        easyGeolevel17 = findViewById(R.id.EasyGeolevel17);
        easyGeolevel18 = findViewById(R.id.EasyGeolevel18);
        easyGeolevel19 = findViewById(R.id.EasyGeolevel19);
        easyGeolevel20 = findViewById(R.id.EasyGeolevel20);
        //Кнопка рестарт:
        imageRestartEasyGeo = findViewById(R.id.imageRestartEasyGeo);
        //Кнопка статистики:
        imageDiagramEasyGeo = findViewById(R.id.imageDiagramEasyGeo);
        //Анимация облаков:
        animationCloudGeo1 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math1);
        animationCloudGeo2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math2);
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        easyGeolevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(EasyGeoLevel1.class);
        });
        //Переход к уровню 2:
        easyGeolevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(EasyGeoLevel2.class);
        });
        //Переход к уровню 3:
        easyGeolevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(EasyGeoLevel3.class);
        });
        //Переход к уровню 4:
        easyGeolevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(EasyGeoLevel4.class);
        });
        //Переход к уровню 5:
        easyGeolevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(EasyGeoLevel5.class);
        });
        //Переход к уровню 6:
        easyGeolevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(EasyGeoLevel6.class);
        });
        //Переход к уровню 7:
        easyGeolevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(EasyGeoLevel7.class);
        });
        //Переход к уровню 8:
        easyGeolevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(EasyGeoLevel8.class);
        });
        //Переход к уровню 9:
        easyGeolevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(EasyGeoLevel9.class);
        });//Переход к уровню 10:
        easyGeolevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(EasyGeoLevel10.class);
        });
        //Переход к уровню 11:
        easyGeolevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(EasyGeoLevel11.class);
        });
        //Переход к уровню 12:
        easyGeolevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(EasyGeoLevel12.class);
        });
        //Переход к уровню 13:
        easyGeolevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(EasyGeoLevel13.class);
        });
        //Переход к уровню 14:
        easyGeolevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(EasyGeoLevel14.class);
        });
        //Переход к уровню 15:
        easyGeolevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(EasyGeoLevel15.class);
        });
        //Переход к уровню 16:
        easyGeolevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(EasyGeoLevel16.class);
        });
        //Переход к уровню 17:
        easyGeolevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(EasyGeoLevel17.class);
        });
        //Переход к уровню 18:
        easyGeolevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(EasyGeoLevel18.class);
        });//Переход к уровню 19:
        easyGeolevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(EasyGeoLevel19.class);
        });
        //Переход к уровню 20:
        easyGeolevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(EasyGeoLevel20.class);
        });
        final Integer [] numberOfLevel = {
                R.id.EasyGeolevel1,
                R.id.EasyGeolevel2,
                R.id.EasyGeolevel3,
                R.id.EasyGeolevel4,
                R.id.EasyGeolevel5,
                R.id.EasyGeolevel6,
                R.id.EasyGeolevel7,
                R.id.EasyGeolevel8,
                R.id.EasyGeolevel9,
                R.id.EasyGeolevel10,
                R.id.EasyGeolevel11,
                R.id.EasyGeolevel12,
                R.id.EasyGeolevel13,
                R.id.EasyGeolevel14,
                R.id.EasyGeolevel15,
                R.id.EasyGeolevel16,
                R.id.EasyGeolevel17,
                R.id.EasyGeolevel18,
                R.id.EasyGeolevel19,
                R.id.EasyGeolevel20,
        };

        setLevelsGrid(LVL_GEO_EASY, numberOfLevel, R.drawable.style_buttons_easy);

        imageRestartEasyGeo.setOnClickListener(view -> {
            dialogGeoEasyRestart.show();
        });

        GeolevelEasyRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_GEO_EASY, numberOfLevel, R.drawable.style_buttons_not_pass);
                startLevel(ActivityGeoEasy.class);
            }
            dialogGeoEasyRestart.dismiss();

        });
        GeolevelEasyRestartNo.setOnClickListener(view -> {
            dialogGeoEasyRestart.dismiss();
        });
        imageDiagramEasyGeo.setOnClickListener(view -> {
            dialogGeoEasyDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else  {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_GEO_EASY));
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        imageCloudGeo1.startAnimation(animationCloudGeo1);
        imageCloudGeo2.startAnimation(animationCloudGeo2);
    }
}