package com.example.quiz.system;

import static com.example.quiz.Const.LVL_BIO_NORMAL;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.quiz.R;
import com.example.quiz.bioLevelsNormal.NormalBioLevel1;
import com.example.quiz.bioLevelsNormal.NormalBioLevel10;
import com.example.quiz.bioLevelsNormal.NormalBioLevel11;
import com.example.quiz.bioLevelsNormal.NormalBioLevel12;
import com.example.quiz.bioLevelsNormal.NormalBioLevel13;
import com.example.quiz.bioLevelsNormal.NormalBioLevel14;
import com.example.quiz.bioLevelsNormal.NormalBioLevel15;
import com.example.quiz.bioLevelsNormal.NormalBioLevel16;
import com.example.quiz.bioLevelsNormal.NormalBioLevel17;
import com.example.quiz.bioLevelsNormal.NormalBioLevel18;
import com.example.quiz.bioLevelsNormal.NormalBioLevel19;
import com.example.quiz.bioLevelsNormal.NormalBioLevel2;
import com.example.quiz.bioLevelsNormal.NormalBioLevel20;
import com.example.quiz.bioLevelsNormal.NormalBioLevel3;
import com.example.quiz.bioLevelsNormal.NormalBioLevel4;
import com.example.quiz.bioLevelsNormal.NormalBioLevel5;
import com.example.quiz.bioLevelsNormal.NormalBioLevel6;
import com.example.quiz.bioLevelsNormal.NormalBioLevel7;
import com.example.quiz.bioLevelsNormal.NormalBioLevel8;
import com.example.quiz.bioLevelsNormal.NormalBioLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityBioNormal extends BaseActivity {

    private TextView imageBack;
    private TextView normalBiolevel1, normalBiolevel2, normalBiolevel3, normalBiolevel4, normalBiolevel5, normalBiolevel6, normalBiolevel7, normalBiolevel8, normalBiolevel9, normalBiolevel10, normalBiolevel11, normalBiolevel12, normalBiolevel13, normalBiolevel14, normalBiolevel15, normalBiolevel16, normalBiolevel17, normalBiolevel18, normalBiolevel19, normalBiolevel20;
    private ImageButton imageRestartNormalBio, imageDiagramNormalBio;
    private Dialog dialogBioNormalRestart, dialogBioNormalDiagram;
    private TextView BiolevelNormalRestartYes, BiolevelNormalRestartNo;
    private TextView decided, errors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_normal);
        final int level = getSp().getInt(LVL_BIO_NORMAL, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogBioNormalRestart = new Dialog(this);
        dialogBioNormalRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioNormalRestart.setContentView(R.layout.activity_dialog_window_bio_normal_restart);
        dialogBioNormalRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogBioNormalDiagram = new Dialog(this);
        dialogBioNormalDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioNormalDiagram.setContentView(R.layout.activity_dialog_window_bio_normal_diagram);
        dialogBioNormalDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        BiolevelNormalRestartYes = dialogBioNormalRestart.findViewById(R.id.BiolevelNormalRestartYes);
        BiolevelNormalRestartNo = dialogBioNormalRestart.findViewById(R.id.BiolevelNormalRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogBioNormalDiagram.findViewById(R.id.BiodecidedNormal);
        errors = dialogBioNormalDiagram.findViewById(R.id.BioerrorsNormal);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        normalBiolevel1 = findViewById(R.id.NormalBiolevel1);
        normalBiolevel2 = findViewById(R.id.NormalBiolevel2);
        normalBiolevel3 = findViewById(R.id.NormalBiolevel3);
        normalBiolevel4 = findViewById(R.id.NormalBiolevel4);
        normalBiolevel5 = findViewById(R.id.NormalBiolevel5);
        normalBiolevel6 = findViewById(R.id.NormalBiolevel6);
        normalBiolevel7 = findViewById(R.id.NormalBiolevel7);
        normalBiolevel8 = findViewById(R.id.NormalBiolevel8);
        normalBiolevel9 = findViewById(R.id.NormalBiolevel9);
        normalBiolevel10 = findViewById(R.id.NormalBiolevel10);
        normalBiolevel11 = findViewById(R.id.NormalBiolevel11);
        normalBiolevel12 = findViewById(R.id.NormalBiolevel12);
        normalBiolevel13 = findViewById(R.id.NormalBiolevel13);
        normalBiolevel14 = findViewById(R.id.NormalBiolevel14);
        normalBiolevel15 = findViewById(R.id.NormalBiolevel15);
        normalBiolevel16 = findViewById(R.id.NormalBiolevel16);
        normalBiolevel17 = findViewById(R.id.NormalBiolevel17);
        normalBiolevel18 = findViewById(R.id.NormalBiolevel18);
        normalBiolevel19 = findViewById(R.id.NormalBiolevel19);
        normalBiolevel20 = findViewById(R.id.NormalBiolevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartNormalBio = findViewById(R.id.imageRestartNormalBio);
        imageDiagramNormalBio = findViewById(R.id.imageDiagramNormalBio);
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        normalBiolevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(NormalBioLevel1.class);
        });
        //Переход к уровню 2:
        normalBiolevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(NormalBioLevel2.class);
        });
        //Переход к уровню 3:
        normalBiolevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(NormalBioLevel3.class);
        });
        //Переход к уровню 4:
        normalBiolevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(NormalBioLevel4.class);
        });
        //Переход к уровню 5:
        normalBiolevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(NormalBioLevel5.class);
        });
        //Переход к уровню 6:
        normalBiolevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(NormalBioLevel6.class);
        });
        //Переход к уровню 7:
        normalBiolevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(NormalBioLevel7.class);
        });
        //Переход к уровню 8:
        normalBiolevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(NormalBioLevel8.class);
        });
        //Переход к уровню 9:
        normalBiolevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(NormalBioLevel9.class);
        });//Переход к уровню 10:
        normalBiolevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(NormalBioLevel10.class);
        });
        //Переход к уровню 11:
        normalBiolevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(NormalBioLevel11.class);
        });
        //Переход к уровню 12:
        normalBiolevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(NormalBioLevel12.class);
        });
        //Переход к уровню 13:
        normalBiolevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(NormalBioLevel13.class);
        });
        //Переход к уровню 14:
        normalBiolevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(NormalBioLevel14.class);
        });
        //Переход к уровню 15:
        normalBiolevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(NormalBioLevel15.class);
        });
        //Переход к уровню 16:
        normalBiolevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(NormalBioLevel16.class);
        });
        //Переход к уровню 17:
        normalBiolevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(NormalBioLevel17.class);
        });
        //Переход к уровню 18:
        normalBiolevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(NormalBioLevel18.class);
        });//Переход к уровню 19:
        normalBiolevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(NormalBioLevel19.class);
        });
        //Переход к уровню 20:
        normalBiolevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(NormalBioLevel20.class);
        });

        final Integer [] numberOfLevel = {
                R.id.NormalBiolevel1,
                R.id.NormalBiolevel2,
                R.id.NormalBiolevel3,
                R.id.NormalBiolevel4,
                R.id.NormalBiolevel5,
                R.id.NormalBiolevel6,
                R.id.NormalBiolevel7,
                R.id.NormalBiolevel8,
                R.id.NormalBiolevel9,
                R.id.NormalBiolevel10,
                R.id.NormalBiolevel11,
                R.id.NormalBiolevel12,
                R.id.NormalBiolevel13,
                R.id.NormalBiolevel14,
                R.id.NormalBiolevel15,
                R.id.NormalBiolevel16,
                R.id.NormalBiolevel17,
                R.id.NormalBiolevel18,
                R.id.NormalBiolevel19,
                R.id.NormalBiolevel20,
        };

        setLevelsGrid(LVL_BIO_NORMAL, numberOfLevel, R.drawable.style_buttons_normal);

        imageRestartNormalBio.setOnClickListener(view -> {
            dialogBioNormalRestart.show();
        });

        BiolevelNormalRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_BIO_NORMAL, numberOfLevel, R.drawable.style_buttons_not_pass_normal);
                startLevel(ActivityBioNormal.class);
            }
            dialogBioNormalRestart.dismiss();
        });
        BiolevelNormalRestartNo.setOnClickListener(view -> {
            dialogBioNormalRestart.dismiss();
        });
        imageDiagramNormalBio.setOnClickListener(view -> {
            dialogBioNormalDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            }
            else {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_BIO_NORMAL));
        });

    }
}