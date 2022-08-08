package com.example.quiz.system;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.bioLevelsEasy.EasyBioLevel1;
import com.example.quiz.bioLevelsEasy.EasyBioLevel10;
import com.example.quiz.bioLevelsEasy.EasyBioLevel11;
import com.example.quiz.bioLevelsEasy.EasyBioLevel12;
import com.example.quiz.bioLevelsEasy.EasyBioLevel13;
import com.example.quiz.bioLevelsEasy.EasyBioLevel14;
import com.example.quiz.bioLevelsEasy.EasyBioLevel15;
import com.example.quiz.bioLevelsEasy.EasyBioLevel16;
import com.example.quiz.bioLevelsEasy.EasyBioLevel17;
import com.example.quiz.bioLevelsEasy.EasyBioLevel18;
import com.example.quiz.bioLevelsEasy.EasyBioLevel19;
import com.example.quiz.bioLevelsEasy.EasyBioLevel2;
import com.example.quiz.bioLevelsEasy.EasyBioLevel20;
import com.example.quiz.bioLevelsEasy.EasyBioLevel3;
import com.example.quiz.bioLevelsEasy.EasyBioLevel4;
import com.example.quiz.bioLevelsEasy.EasyBioLevel5;
import com.example.quiz.bioLevelsEasy.EasyBioLevel6;
import com.example.quiz.bioLevelsEasy.EasyBioLevel7;
import com.example.quiz.bioLevelsEasy.EasyBioLevel8;
import com.example.quiz.bioLevelsEasy.EasyBioLevel9;

public class ActivityBioEasy extends AppCompatActivity {

    private ImageView imageCloudBio1, imageCloudBio2;
    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView easyBiolevel1, easyBiolevel2, easyBiolevel3, easyBiolevel4, easyBiolevel5, easyBiolevel6, easyBiolevel7, easyBiolevel8, easyBiolevel9, easyBiolevel10, easyBiolevel11, easyBiolevel12, easyBiolevel13, easyBiolevel14, easyBiolevel15, easyBiolevel16, easyBiolevel17, easyBiolevel18, easyBiolevel19, easyBiolevel20;
    private Animation animationCloudBio1, animationCloudBio2;
    private ImageButton imageRestartEasyBio, imageDiagramEasyBio;
    private Dialog dialogBioEasyRestart, dialogBioEasyDiagram;
    private TextView BiolevelEasyRestartYes, BiolevelEasyRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_level_easy);
        //Сохрание игры:
        SharedPreferences save = getSharedPreferences("BioSave", MODE_PRIVATE);
        final int level = save.getInt("BioLevel", 1);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogBioEasyRestart = new Dialog(this);
        dialogBioEasyRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioEasyRestart.setContentView(R.layout.activity_dialog_window_bio_easy_restart);
        dialogBioEasyRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogBioEasyDiagram = new Dialog(this);
        dialogBioEasyDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogBioEasyDiagram.setContentView(R.layout.activity_dialog_window_bio_easy_diagram);
        dialogBioEasyDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        BiolevelEasyRestartYes = dialogBioEasyRestart.findViewById(R.id.BiolevelEasyRestartYes);
        BiolevelEasyRestartNo = dialogBioEasyRestart.findViewById(R.id.BiolevelEasyRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogBioEasyDiagram.findViewById(R.id.Biodecided);
        errors = dialogBioEasyDiagram.findViewById(R.id.Bioerrors);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация облаков:
        imageCloudBio1 = findViewById(R.id.imageCloudBio1);
        imageCloudBio2 = findViewById(R.id.imageCloudBio2);
        //Кнопки перехода на уровни:
        easyBiolevel1 = findViewById(R.id.EasyBiolevel1);
        easyBiolevel2 = findViewById(R.id.EasyBiolevel2);
        easyBiolevel3 = findViewById(R.id.EasyBiolevel3);
        easyBiolevel4 = findViewById(R.id.EasyBiolevel4);
        easyBiolevel5 = findViewById(R.id.EasyBiolevel5);
        easyBiolevel6 = findViewById(R.id.EasyBiolevel6);
        easyBiolevel7 = findViewById(R.id.EasyBiolevel7);
        easyBiolevel8 = findViewById(R.id.EasyBiolevel8);
        easyBiolevel9 = findViewById(R.id.EasyBiolevel9);
        easyBiolevel10 = findViewById(R.id.EasyBiolevel10);
        easyBiolevel11 = findViewById(R.id.EasyBiolevel11);
        easyBiolevel12 = findViewById(R.id.EasyBiolevel12);
        easyBiolevel13 = findViewById(R.id.EasyBiolevel13);
        easyBiolevel14 = findViewById(R.id.EasyBiolevel14);
        easyBiolevel15 = findViewById(R.id.EasyBiolevel15);
        easyBiolevel16 = findViewById(R.id.EasyBiolevel16);
        easyBiolevel17 = findViewById(R.id.EasyBiolevel17);
        easyBiolevel18 = findViewById(R.id.EasyBiolevel18);
        easyBiolevel19 = findViewById(R.id.EasyBiolevel19);
        easyBiolevel20 = findViewById(R.id.EasyBiolevel20);
        //Кнопка рестарт:
        imageRestartEasyBio = findViewById(R.id.imageRestartEasyBio);
        //Кнопка статистики:
        imageDiagramEasyBio = findViewById(R.id.imageDiagramEasyBio);
        //Анимация облаков:
        animationCloudBio1 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math1);
        animationCloudBio2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud_math2);
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        easyBiolevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, EasyBioLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        easyBiolevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, EasyBioLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        easyBiolevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, EasyBioLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        easyBiolevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, EasyBioLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        easyBiolevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, EasyBioLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        easyBiolevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, EasyBioLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        easyBiolevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, EasyBioLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        easyBiolevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, EasyBioLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        easyBiolevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, EasyBioLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        easyBiolevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, EasyBioLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        easyBiolevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, EasyBioLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        easyBiolevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, EasyBioLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        easyBiolevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, EasyBioLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        easyBiolevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, EasyBioLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        easyBiolevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, EasyBioLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        easyBiolevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, EasyBioLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        easyBiolevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, EasyBioLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        easyBiolevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, EasyBioLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        easyBiolevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, EasyBioLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        easyBiolevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, EasyBioLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        final int [] numberOfLevel = {
                R.id.EasyBiolevel1,
                R.id.EasyBiolevel2,
                R.id.EasyBiolevel3,
                R.id.EasyBiolevel4,
                R.id.EasyBiolevel5,
                R.id.EasyBiolevel6,
                R.id.EasyBiolevel7,
                R.id.EasyBiolevel8,
                R.id.EasyBiolevel9,
                R.id.EasyBiolevel10,
                R.id.EasyBiolevel11,
                R.id.EasyBiolevel12,
                R.id.EasyBiolevel13,
                R.id.EasyBiolevel14,
                R.id.EasyBiolevel15,
                R.id.EasyBiolevel16,
                R.id.EasyBiolevel17,
                R.id.EasyBiolevel18,
                R.id.EasyBiolevel19,
                R.id.EasyBiolevel20,
        };
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_easy));
            textView.setText(""+(i+1));
        }
        imageRestartEasyBio.setOnClickListener(view -> {
            dialogBioEasyRestart.show();
        });
        BiolevelEasyRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityBioEasy.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("BioLevel", 1);
                editor.putInt("BioLevelFalse", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass));
                    textView.setText("X");
                }
                dialogBioEasyRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
        });
        BiolevelEasyRestartNo.setOnClickListener(view -> {
            dialogBioEasyRestart.dismiss();
        });
        imageDiagramEasyBio.setOnClickListener(view -> {
            dialogBioEasyDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else  {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(String.valueOf(save.getInt("BioLevelFalse", 0)));
        });

    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageCloudBio1.startAnimation(animationCloudBio1);
        imageCloudBio2.startAnimation(animationCloudBio2);
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
        if (flag == false) {
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