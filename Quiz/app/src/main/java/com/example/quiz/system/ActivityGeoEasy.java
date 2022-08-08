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
import com.example.quiz.mathLevelsEasy.EasyMathLevel1;
import com.example.quiz.mathLevelsEasy.EasyMathLevel10;
import com.example.quiz.mathLevelsEasy.EasyMathLevel11;
import com.example.quiz.mathLevelsEasy.EasyMathLevel12;
import com.example.quiz.mathLevelsEasy.EasyMathLevel13;
import com.example.quiz.mathLevelsEasy.EasyMathLevel14;
import com.example.quiz.mathLevelsEasy.EasyMathLevel15;
import com.example.quiz.mathLevelsEasy.EasyMathLevel16;
import com.example.quiz.mathLevelsEasy.EasyMathLevel17;
import com.example.quiz.mathLevelsEasy.EasyMathLevel18;
import com.example.quiz.mathLevelsEasy.EasyMathLevel19;
import com.example.quiz.mathLevelsEasy.EasyMathLevel2;
import com.example.quiz.mathLevelsEasy.EasyMathLevel20;
import com.example.quiz.mathLevelsEasy.EasyMathLevel3;
import com.example.quiz.mathLevelsEasy.EasyMathLevel4;
import com.example.quiz.mathLevelsEasy.EasyMathLevel5;
import com.example.quiz.mathLevelsEasy.EasyMathLevel6;
import com.example.quiz.mathLevelsEasy.EasyMathLevel7;
import com.example.quiz.mathLevelsEasy.EasyMathLevel8;
import com.example.quiz.mathLevelsEasy.EasyMathLevel9;

public class ActivityGeoEasy extends AppCompatActivity {

    private ImageView imageCloudGeo1, imageCloudGeo2;
    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView easyGeolevel1, easyGeolevel2, easyGeolevel3, easyGeolevel4, easyGeolevel5, easyGeolevel6, easyGeolevel7, easyGeolevel8, easyGeolevel9, easyGeolevel10, easyGeolevel11, easyGeolevel12, easyGeolevel13, easyGeolevel14, easyGeolevel15, easyGeolevel16, easyGeolevel17, easyGeolevel18, easyGeolevel19, easyGeolevel20;
    private Animation animationCloudGeo1, animationCloudGeo2;
    private ImageButton imageRestartEasyGeo, imageDiagramEasyGeo;
    private Dialog dialogGeoEasyRestart, dialogGeoEasyDiagram;
    private TextView GeolevelEasyRestartYes, GeolevelEasyRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_level_easy);
        //Сохрание игры:
        SharedPreferences save = getSharedPreferences("GeoSave", MODE_PRIVATE);
        final int level = save.getInt("GeoLevel", 1);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        easyGeolevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, EasyGeoLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        easyGeolevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, EasyGeoLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        easyGeolevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, EasyGeoLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        easyGeolevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, EasyGeoLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        easyGeolevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, EasyGeoLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        easyGeolevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, EasyGeoLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        easyGeolevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, EasyGeoLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        easyGeolevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, EasyGeoLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        easyGeolevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, EasyGeoLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        easyGeolevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, EasyGeoLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        easyGeolevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, EasyGeoLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        easyGeolevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, EasyGeoLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        easyGeolevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, EasyGeoLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        easyGeolevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, EasyGeoLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        easyGeolevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, EasyGeoLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        easyGeolevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, EasyGeoLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        easyGeolevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, EasyGeoLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        easyGeolevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, EasyGeoLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        easyGeolevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, EasyGeoLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        easyGeolevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, EasyGeoLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        final int [] numberOfLevel = {
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
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_easy));
            textView.setText(""+(i+1));
        }
        imageRestartEasyGeo.setOnClickListener(view -> {
            dialogGeoEasyRestart.show();
        });
        GeolevelEasyRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoEasy.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("GeoLevel", 1);
                editor.putInt("GeoLevelFalse", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass));
                    textView.setText("X");
                }
                dialogGeoEasyRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
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
            errors.setText(String.valueOf(save.getInt("GeoLevelFalse", 0)));
        });

    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageCloudGeo1.startAnimation(animationCloudGeo1);
        imageCloudGeo2.startAnimation(animationCloudGeo2);
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