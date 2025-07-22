package com.example.quiz.system;

import static com.example.quiz.Const.LVL_GEO_NORMAL;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel1;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel10;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel11;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel12;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel13;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel14;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel15;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel16;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel17;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel18;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel19;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel2;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel20;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel3;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel4;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel5;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel6;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel7;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel8;
import com.example.quiz.geoLevelsNormal.NormalGeoLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityGeoNormal extends BaseActivity {

    private TextView imageBack;
    private TextView normalGeolevel1, normalGeolevel2, normalGeolevel3, normalGeolevel4, normalGeolevel5, normalGeolevel6, normalGeolevel7, normalGeolevel8, normalGeolevel9, normalGeolevel10, normalGeolevel11, normalGeolevel12, normalGeolevel13, normalGeolevel14, normalGeolevel15, normalGeolevel16, normalGeolevel17, normalGeolevel18, normalGeolevel19, normalGeolevel20;
    private ImageButton imageRestartNormalGeo, imageDiagramNormalGeo;
    private Dialog dialogGeoNormalRestart, dialogGeoNormalDiagram;
    private TextView GeolevelNormalRestartYes, GeolevelNormalRestartNo;
    private TextView decided, errors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_level_normal);
        final int level = getSp().getInt(LVL_GEO_NORMAL, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogGeoNormalRestart = new Dialog(this);
        dialogGeoNormalRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGeoNormalRestart.setContentView(R.layout.activity_dialog_window_geo_normal_restart);
        dialogGeoNormalRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogGeoNormalDiagram = new Dialog(this);
        dialogGeoNormalDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGeoNormalDiagram.setContentView(R.layout.activity_dialog_window_geo_normal_diagram);
        dialogGeoNormalDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        GeolevelNormalRestartYes = dialogGeoNormalRestart.findViewById(R.id.GeolevelNormalRestartYes);
        GeolevelNormalRestartNo = dialogGeoNormalRestart.findViewById(R.id.GeolevelNormalRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogGeoNormalDiagram.findViewById(R.id.GeodecidedNormal);
        errors = dialogGeoNormalDiagram.findViewById(R.id.GeoerrorsNormal);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        normalGeolevel1 = findViewById(R.id.NormalGeolevel1);
        normalGeolevel2 = findViewById(R.id.NormalGeolevel2);
        normalGeolevel3 = findViewById(R.id.NormalGeolevel3);
        normalGeolevel4 = findViewById(R.id.NormalGeolevel4);
        normalGeolevel5 = findViewById(R.id.NormalGeolevel5);
        normalGeolevel6 = findViewById(R.id.NormalGeolevel6);
        normalGeolevel7 = findViewById(R.id.NormalGeolevel7);
        normalGeolevel8 = findViewById(R.id.NormalGeolevel8);
        normalGeolevel9 = findViewById(R.id.NormalGeolevel9);
        normalGeolevel10 = findViewById(R.id.NormalGeolevel10);
        normalGeolevel11 = findViewById(R.id.NormalGeolevel11);
        normalGeolevel12 = findViewById(R.id.NormalGeolevel12);
        normalGeolevel13 = findViewById(R.id.NormalGeolevel13);
        normalGeolevel14 = findViewById(R.id.NormalGeolevel14);
        normalGeolevel15 = findViewById(R.id.NormalGeolevel15);
        normalGeolevel16 = findViewById(R.id.NormalGeolevel16);
        normalGeolevel17 = findViewById(R.id.NormalGeolevel17);
        normalGeolevel18 = findViewById(R.id.NormalGeolevel18);
        normalGeolevel19 = findViewById(R.id.NormalGeolevel19);
        normalGeolevel20 = findViewById(R.id.NormalGeolevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartNormalGeo = findViewById(R.id.imageRestartNormalGeo);
        imageDiagramNormalGeo = findViewById(R.id.imageDiagramNormalGeo);
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        normalGeolevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(NormalGeoLevel1.class);
        });
        //Переход к уровню 2:
        normalGeolevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(NormalGeoLevel2.class);
        });
        //Переход к уровню 3:
        normalGeolevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(NormalGeoLevel3.class);
        });
        //Переход к уровню 4:
        normalGeolevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(NormalGeoLevel4.class);
        });
        //Переход к уровню 5:
        normalGeolevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(NormalGeoLevel5.class);
        });
        //Переход к уровню 6:
        normalGeolevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(NormalGeoLevel6.class);
        });
        //Переход к уровню 7:
        normalGeolevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(NormalGeoLevel7.class);
        });
        //Переход к уровню 8:
        normalGeolevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(NormalGeoLevel8.class);
        });
        //Переход к уровню 9:
        normalGeolevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(NormalGeoLevel9.class);
        });//Переход к уровню 10:
        normalGeolevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(NormalGeoLevel10.class);
        });
        //Переход к уровню 11:
        normalGeolevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(NormalGeoLevel11.class);
        });
        //Переход к уровню 12:
        normalGeolevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(NormalGeoLevel12.class);
        });
        //Переход к уровню 13:
        normalGeolevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(NormalGeoLevel13.class);
        });
        //Переход к уровню 14:
        normalGeolevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(NormalGeoLevel14.class);
        });
        //Переход к уровню 15:
        normalGeolevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(NormalGeoLevel15.class);
        });
        //Переход к уровню 16:
        normalGeolevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(NormalGeoLevel16.class);
        });
        //Переход к уровню 17:
        normalGeolevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(NormalGeoLevel17.class);
        });
        //Переход к уровню 18:
        normalGeolevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(NormalGeoLevel18.class);
        });//Переход к уровню 19:
        normalGeolevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(NormalGeoLevel19.class);
        });
        //Переход к уровню 20:
        normalGeolevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(NormalGeoLevel20.class);
        });

        final Integer [] numberOfLevel = {
                R.id.NormalGeolevel1,
                R.id.NormalGeolevel2,
                R.id.NormalGeolevel3,
                R.id.NormalGeolevel4,
                R.id.NormalGeolevel5,
                R.id.NormalGeolevel6,
                R.id.NormalGeolevel7,
                R.id.NormalGeolevel8,
                R.id.NormalGeolevel9,
                R.id.NormalGeolevel10,
                R.id.NormalGeolevel11,
                R.id.NormalGeolevel12,
                R.id.NormalGeolevel13,
                R.id.NormalGeolevel14,
                R.id.NormalGeolevel15,
                R.id.NormalGeolevel16,
                R.id.NormalGeolevel17,
                R.id.NormalGeolevel18,
                R.id.NormalGeolevel19,
                R.id.NormalGeolevel20,
        };

        setLevelsGrid(LVL_GEO_NORMAL, numberOfLevel, R.drawable.style_buttons_normal);

        imageRestartNormalGeo.setOnClickListener(view -> {
            dialogGeoNormalRestart.show();
        });

        GeolevelNormalRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_GEO_NORMAL, numberOfLevel, R.drawable.style_buttons_not_pass_normal);
                startLevel(ActivityGeoNormal.class);
            }
            dialogGeoNormalRestart.dismiss();
        });
        GeolevelNormalRestartNo.setOnClickListener(view -> {
            dialogGeoNormalRestart.dismiss();
        });
        imageDiagramNormalGeo.setOnClickListener(view -> {
            dialogGeoNormalDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            }
            else {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_GEO_NORMAL));
        });

    }
}