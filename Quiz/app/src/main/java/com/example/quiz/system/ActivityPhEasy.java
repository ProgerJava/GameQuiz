package com.example.quiz.system;

import static com.example.quiz.Const.LVL_PH_EASY;

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
import com.example.quiz.phLevelsEasy.EasyPhLevel1;
import com.example.quiz.phLevelsEasy.EasyPhLevel10;
import com.example.quiz.phLevelsEasy.EasyPhLevel11;
import com.example.quiz.phLevelsEasy.EasyPhLevel12;
import com.example.quiz.phLevelsEasy.EasyPhLevel13;
import com.example.quiz.phLevelsEasy.EasyPhLevel14;
import com.example.quiz.phLevelsEasy.EasyPhLevel15;
import com.example.quiz.phLevelsEasy.EasyPhLevel16;
import com.example.quiz.phLevelsEasy.EasyPhLevel17;
import com.example.quiz.phLevelsEasy.EasyPhLevel18;
import com.example.quiz.phLevelsEasy.EasyPhLevel19;
import com.example.quiz.phLevelsEasy.EasyPhLevel2;
import com.example.quiz.phLevelsEasy.EasyPhLevel20;
import com.example.quiz.phLevelsEasy.EasyPhLevel3;
import com.example.quiz.phLevelsEasy.EasyPhLevel4;
import com.example.quiz.phLevelsEasy.EasyPhLevel5;
import com.example.quiz.phLevelsEasy.EasyPhLevel6;
import com.example.quiz.phLevelsEasy.EasyPhLevel7;
import com.example.quiz.phLevelsEasy.EasyPhLevel8;
import com.example.quiz.phLevelsEasy.EasyPhLevel9;
import com.example.quiz.ui.activity.BaseActivity;

public class ActivityPhEasy extends BaseActivity {

    private ImageView imageCloudPh1, imageCloudPh2;
    private TextView imageBack;
    private TextView easyPhlevel1, easyPhlevel2, easyPhlevel3, easyPhlevel4, easyPhlevel5, easyPhlevel6, easyPhlevel7, easyPhlevel8, easyPhlevel9, easyPhlevel10, easyPhlevel11, easyPhlevel12, easyPhlevel13, easyPhlevel14, easyPhlevel15, easyPhlevel16, easyPhlevel17, easyPhlevel18, easyPhlevel19, easyPhlevel20;
    private Animation animationCloudPh1, animationCloudPh2;
    private ImageButton imageRestartEasyPh, imageDiagramEasyPh;
    private Dialog dialogPhEasyRestart, dialogPhEasyDiagram;
    private TextView PhlevelEasyRestartYes, PhlevelEasyRestartNo;
    private TextView decided, errors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_level_easy);
        //Сохрание игры:
        final int level = getSp().getInt(LVL_PH_EASY, 1);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogPhEasyRestart = new Dialog(this);
        dialogPhEasyRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhEasyRestart.setContentView(R.layout.activity_dialog_window_ph_easy_restart);
        dialogPhEasyRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogPhEasyDiagram = new Dialog(this);
        dialogPhEasyDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPhEasyDiagram.setContentView(R.layout.activity_dialog_window_ph_easy_diagram);
        dialogPhEasyDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        PhlevelEasyRestartYes = dialogPhEasyRestart.findViewById(R.id.PhlevelEasyRestartYes);
        PhlevelEasyRestartNo = dialogPhEasyRestart.findViewById(R.id.PhlevelEasyRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogPhEasyDiagram.findViewById(R.id.Phdecided);
        errors = dialogPhEasyDiagram.findViewById(R.id.Pherrors);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация облаков:
        imageCloudPh1 = findViewById(R.id.imageCloudPh1);
        imageCloudPh2 = findViewById(R.id.imageCloudPh2);
        //Кнопки перехода на уровни:
        easyPhlevel1 = findViewById(R.id.EasyPhlevel1);
        easyPhlevel2 = findViewById(R.id.EasyPhlevel2);
        easyPhlevel3 = findViewById(R.id.EasyPhlevel3);
        easyPhlevel4 = findViewById(R.id.EasyPhlevel4);
        easyPhlevel5 = findViewById(R.id.EasyPhlevel5);
        easyPhlevel6 = findViewById(R.id.EasyPhlevel6);
        easyPhlevel7 = findViewById(R.id.EasyPhlevel7);
        easyPhlevel8 = findViewById(R.id.EasyPhlevel8);
        easyPhlevel9 = findViewById(R.id.EasyPhlevel9);
        easyPhlevel10 = findViewById(R.id.EasyPhlevel10);
        easyPhlevel11 = findViewById(R.id.EasyPhlevel11);
        easyPhlevel12 = findViewById(R.id.EasyPhlevel12);
        easyPhlevel13 = findViewById(R.id.EasyPhlevel13);
        easyPhlevel14 = findViewById(R.id.EasyPhlevel14);
        easyPhlevel15 = findViewById(R.id.EasyPhlevel15);
        easyPhlevel16 = findViewById(R.id.EasyPhlevel16);
        easyPhlevel17 = findViewById(R.id.EasyPhlevel17);
        easyPhlevel18 = findViewById(R.id.EasyPhlevel18);
        easyPhlevel19 = findViewById(R.id.EasyPhlevel19);
        easyPhlevel20 = findViewById(R.id.EasyPhlevel20);
        //Кнопка рестарт:
        imageRestartEasyPh = findViewById(R.id.imageRestartEasyPh);
        //Кнопка статистики:
        imageDiagramEasyPh = findViewById(R.id.imageDiagramEasyPh);
        //Анимация облаков:
        animationCloudPh1 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math1);
        animationCloudPh2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math2);

        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            startLevel(ActivityMenu.class);
        });
        //Переход к уровню 1:
        easyPhlevel1.setOnClickListener(view -> {
            if (level >= 1) startLevel(EasyPhLevel1.class);
        });
        //Переход к уровню 2:
        easyPhlevel2.setOnClickListener(view -> {
            if (level >= 2) startLevel(EasyPhLevel2.class);
        });
        //Переход к уровню 3:
        easyPhlevel3.setOnClickListener(view -> {
            if (level >= 3) startLevel(EasyPhLevel3.class);
        });
        //Переход к уровню 4:
        easyPhlevel4.setOnClickListener(view -> {
            if (level >= 4) startLevel(EasyPhLevel4.class);
        });
        //Переход к уровню 5:
        easyPhlevel5.setOnClickListener(view -> {
            if (level >= 5) startLevel(EasyPhLevel5.class);
        });
        //Переход к уровню 6:
        easyPhlevel6.setOnClickListener(view -> {
            if (level >= 6) startLevel(EasyPhLevel6.class);
        });
        //Переход к уровню 7:
        easyPhlevel7.setOnClickListener(view -> {
            if (level >= 7) startLevel(EasyPhLevel7.class);
        });
        //Переход к уровню 8:
        easyPhlevel8.setOnClickListener(view -> {
            if (level >= 8) startLevel(EasyPhLevel8.class);
        });
        //Переход к уровню 9:
        easyPhlevel9.setOnClickListener(view -> {
            if (level >= 9) startLevel(EasyPhLevel9.class);
        });//Переход к уровню 10:
        easyPhlevel10.setOnClickListener(view -> {
            if (level >= 10) startLevel(EasyPhLevel10.class);
        });
        //Переход к уровню 11:
        easyPhlevel11.setOnClickListener(view -> {
            if (level >= 11) startLevel(EasyPhLevel11.class);
        });
        //Переход к уровню 12:
        easyPhlevel12.setOnClickListener(view -> {
            if (level >= 12) startLevel(EasyPhLevel12.class);
        });
        //Переход к уровню 13:
        easyPhlevel13.setOnClickListener(view -> {
            if (level >= 13) startLevel(EasyPhLevel13.class);
        });
        //Переход к уровню 14:
        easyPhlevel14.setOnClickListener(view -> {
            if (level >= 14) startLevel(EasyPhLevel14.class);
        });
        //Переход к уровню 15:
        easyPhlevel15.setOnClickListener(view -> {
            if (level >= 15) startLevel(EasyPhLevel15.class);
        });
        //Переход к уровню 16:
        easyPhlevel16.setOnClickListener(view -> {
            if (level >= 16) startLevel(EasyPhLevel16.class);
        });
        //Переход к уровню 17:
        easyPhlevel17.setOnClickListener(view -> {
            if (level >= 17) startLevel(EasyPhLevel17.class);
        });
        //Переход к уровню 18:
        easyPhlevel18.setOnClickListener(view -> {
            if (level >= 18) startLevel(EasyPhLevel18.class);
        });//Переход к уровню 19:
        easyPhlevel19.setOnClickListener(view -> {
            if (level >= 19) startLevel(EasyPhLevel19.class);
        });
        //Переход к уровню 20:
        easyPhlevel20.setOnClickListener(view -> {
            if (level >= 20) startLevel(EasyPhLevel20.class);
        });
        final Integer [] numberOfLevel = {
                R.id.EasyPhlevel1,
                R.id.EasyPhlevel2,
                R.id.EasyPhlevel3,
                R.id.EasyPhlevel4,
                R.id.EasyPhlevel5,
                R.id.EasyPhlevel6,
                R.id.EasyPhlevel7,
                R.id.EasyPhlevel8,
                R.id.EasyPhlevel9,
                R.id.EasyPhlevel10,
                R.id.EasyPhlevel11,
                R.id.EasyPhlevel12,
                R.id.EasyPhlevel13,
                R.id.EasyPhlevel14,
                R.id.EasyPhlevel15,
                R.id.EasyPhlevel16,
                R.id.EasyPhlevel17,
                R.id.EasyPhlevel18,
                R.id.EasyPhlevel19,
                R.id.EasyPhlevel20,
        };

        setLevelsGrid(LVL_PH_EASY, numberOfLevel, R.drawable.style_buttons_easy);

        imageRestartEasyPh.setOnClickListener(view -> {
            dialogPhEasyRestart.show();
        });
        PhlevelEasyRestartYes.setOnClickListener(view -> {
            if (level > 1) {
                resetLevels(LVL_PH_EASY, numberOfLevel, R.drawable.style_buttons_not_pass);
                startLevel(ActivityPhEasy.class);
            }
            dialogPhEasyRestart.dismiss();
        });
        PhlevelEasyRestartNo.setOnClickListener(view -> {
            dialogPhEasyRestart.dismiss();
        });
        imageDiagramEasyPh.setOnClickListener(view -> {
            dialogPhEasyDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else  {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(getAllErrorForLevel(LVL_PH_EASY));
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        imageCloudPh1.startAnimation(animationCloudPh1);
        imageCloudPh2.startAnimation(animationCloudPh2);
    }
}