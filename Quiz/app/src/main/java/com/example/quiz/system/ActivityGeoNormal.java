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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.quiz.mathLevelsNormal.NormalMathLevel1;
import com.example.quiz.mathLevelsNormal.NormalMathLevel10;
import com.example.quiz.mathLevelsNormal.NormalMathLevel11;
import com.example.quiz.mathLevelsNormal.NormalMathLevel12;
import com.example.quiz.mathLevelsNormal.NormalMathLevel13;
import com.example.quiz.mathLevelsNormal.NormalMathLevel14;
import com.example.quiz.mathLevelsNormal.NormalMathLevel15;
import com.example.quiz.mathLevelsNormal.NormalMathLevel16;
import com.example.quiz.mathLevelsNormal.NormalMathLevel17;
import com.example.quiz.mathLevelsNormal.NormalMathLevel18;
import com.example.quiz.mathLevelsNormal.NormalMathLevel19;
import com.example.quiz.mathLevelsNormal.NormalMathLevel2;
import com.example.quiz.mathLevelsNormal.NormalMathLevel20;
import com.example.quiz.mathLevelsNormal.NormalMathLevel3;
import com.example.quiz.mathLevelsNormal.NormalMathLevel4;
import com.example.quiz.mathLevelsNormal.NormalMathLevel5;
import com.example.quiz.mathLevelsNormal.NormalMathLevel6;
import com.example.quiz.mathLevelsNormal.NormalMathLevel7;
import com.example.quiz.mathLevelsNormal.NormalMathLevel8;
import com.example.quiz.mathLevelsNormal.NormalMathLevel9;

public class ActivityGeoNormal extends AppCompatActivity {

    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView normalGeolevel1, normalGeolevel2, normalGeolevel3, normalGeolevel4, normalGeolevel5, normalGeolevel6, normalGeolevel7, normalGeolevel8, normalGeolevel9, normalGeolevel10, normalGeolevel11, normalGeolevel12, normalGeolevel13, normalGeolevel14, normalGeolevel15, normalGeolevel16, normalGeolevel17, normalGeolevel18, normalGeolevel19, normalGeolevel20;
    private ImageButton imageRestartNormalGeo, imageDiagramNormalGeo;
    private Dialog dialogGeoNormalRestart, dialogGeoNormalDiagram;
    private TextView GeolevelNormalRestartYes, GeolevelNormalRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_level_normal);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//Сохрание игры:
        SharedPreferences save1 = getSharedPreferences("GeoSaveNormal", MODE_PRIVATE);
        final int level = save1.getInt("GeoLevelNormal", 1);
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
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        normalGeolevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, NormalGeoLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        normalGeolevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, NormalGeoLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        normalGeolevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, NormalGeoLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        normalGeolevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, NormalGeoLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        normalGeolevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, NormalGeoLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        normalGeolevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, NormalGeoLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        normalGeolevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, NormalGeoLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        normalGeolevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, NormalGeoLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        normalGeolevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, NormalGeoLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        normalGeolevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, NormalGeoLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        normalGeolevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, NormalGeoLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        normalGeolevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, NormalGeoLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        normalGeolevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, NormalGeoLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        normalGeolevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, NormalGeoLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        normalGeolevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, NormalGeoLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        normalGeolevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, NormalGeoLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        normalGeolevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, NormalGeoLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        normalGeolevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, NormalGeoLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        normalGeolevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, NormalGeoLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        normalGeolevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, NormalGeoLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });

        final int [] numberOfLevel = {
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
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_normal));
            textView.setText(""+(i+1));
        }
        imageRestartNormalGeo.setOnClickListener(view -> {
            dialogGeoNormalRestart.show();
        });

        GeolevelNormalRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoNormal.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("GeoLevelNormal", 1);
                editor.putInt("GeoLevelFalseNormal", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass_normal));
                    textView.setText("X");
                }
                dialogGeoNormalRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
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
            errors.setText(String.valueOf(save1.getInt("GeoLevelFalseNormal", 0)));
        });

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