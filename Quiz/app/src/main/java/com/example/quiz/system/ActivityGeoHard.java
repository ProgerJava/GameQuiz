package com.example.quiz.system;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.R;
import com.example.quiz.geoLevelsHard.HardGeoLevel1;
import com.example.quiz.geoLevelsHard.HardGeoLevel10;
import com.example.quiz.geoLevelsHard.HardGeoLevel11;
import com.example.quiz.geoLevelsHard.HardGeoLevel12;
import com.example.quiz.geoLevelsHard.HardGeoLevel13;
import com.example.quiz.geoLevelsHard.HardGeoLevel14;
import com.example.quiz.geoLevelsHard.HardGeoLevel15;
import com.example.quiz.geoLevelsHard.HardGeoLevel16;
import com.example.quiz.geoLevelsHard.HardGeoLevel17;
import com.example.quiz.geoLevelsHard.HardGeoLevel18;
import com.example.quiz.geoLevelsHard.HardGeoLevel19;
import com.example.quiz.geoLevelsHard.HardGeoLevel2;
import com.example.quiz.geoLevelsHard.HardGeoLevel20;
import com.example.quiz.geoLevelsHard.HardGeoLevel3;
import com.example.quiz.geoLevelsHard.HardGeoLevel4;
import com.example.quiz.geoLevelsHard.HardGeoLevel5;
import com.example.quiz.geoLevelsHard.HardGeoLevel6;
import com.example.quiz.geoLevelsHard.HardGeoLevel7;
import com.example.quiz.geoLevelsHard.HardGeoLevel8;
import com.example.quiz.geoLevelsHard.HardGeoLevel9;


public class ActivityGeoHard extends AppCompatActivity {

    private TextView imageBack;
    private long backPressedTime;
    private Toast backToast;
    private TextView hardGeolevel1, hardGeolevel2, hardGeolevel3, hardGeolevel4, hardGeolevel5, hardGeolevel6, hardGeolevel7, hardGeolevel8, hardGeolevel9, hardGeolevel10, hardGeolevel11, hardGeolevel12, hardGeolevel13, hardGeolevel14, hardGeolevel15, hardGeolevel16, hardGeolevel17, hardGeolevel18, hardGeolevel19, hardGeolevel20;
    private ImageButton imageRestartHardGeo, imageDiagramHardGeo;
    private Dialog dialogGeoHardRestart, dialogGeoHardDiagram;
    private TextView GeolevelHardRestartYes, GeolevelHardRestartNo;
    private TextView decided, errors;
    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_level_hard);
        //Сохрание игры:
        SharedPreferences save1 = getSharedPreferences("GeoSaveHard", MODE_PRIVATE);
        final int level = save1.getInt("GeoLevelHard", 1);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Диалоговое окно при нажатии на кнопку "restart":
        dialogGeoHardRestart = new Dialog(this);
        dialogGeoHardRestart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGeoHardRestart.setContentView(R.layout.activity_dialog_window_geo_hard_restart);
        dialogGeoHardRestart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Диалоговое окно при нажатии на кнопку "Diagram":
        dialogGeoHardDiagram = new Dialog(this);
        dialogGeoHardDiagram.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGeoHardDiagram.setContentView(R.layout.activity_dialog_window_geo_hard_diagram);
        dialogGeoHardDiagram.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //Кнопки на диалоговом окне: "Да", "Нет":
        GeolevelHardRestartYes = dialogGeoHardRestart.findViewById(R.id.GeolevelHardRestartYes);
        GeolevelHardRestartNo = dialogGeoHardRestart.findViewById(R.id.GeolevelHardRestartNo);
        //Инициализация полей "Количество ошибок" и "Решено всего":
        decided = dialogGeoHardDiagram.findViewById(R.id.GeodecidedHard);
        errors = dialogGeoHardDiagram.findViewById(R.id.GeoerrorsHard);
        //Кнопка "назад":
        imageBack = findViewById(R.id.imageBack);
        //Инициализация уровней:
        hardGeolevel1 = findViewById(R.id.HardGeolevel1);
        hardGeolevel2 = findViewById(R.id.HardGeolevel2);
        hardGeolevel3 = findViewById(R.id.HardGeolevel3);
        hardGeolevel4 = findViewById(R.id.HardGeolevel4);
        hardGeolevel5 = findViewById(R.id.HardGeolevel5);
        hardGeolevel6 = findViewById(R.id.HardGeolevel6);
        hardGeolevel7 = findViewById(R.id.HardGeolevel7);
        hardGeolevel8 = findViewById(R.id.HardGeolevel8);
        hardGeolevel9 = findViewById(R.id.HardlGeolevel9);
        hardGeolevel10 = findViewById(R.id.HardGeolevel10);
        hardGeolevel11 = findViewById(R.id.HardGeolevel11);
        hardGeolevel12 = findViewById(R.id.HardGeolevel12);
        hardGeolevel13 = findViewById(R.id.HardGeolevel13);
        hardGeolevel14 = findViewById(R.id.HardGeolevel14);
        hardGeolevel15 = findViewById(R.id.HardGeolevel15);
        hardGeolevel16 = findViewById(R.id.HardGeolevel16);
        hardGeolevel17 = findViewById(R.id.HardGeolevel17);
        hardGeolevel18 = findViewById(R.id.HardGeolevel18);
        hardGeolevel19 = findViewById(R.id.HardGeolevel19);
        hardGeolevel20 = findViewById(R.id.HardGeolevel20);
        //Кнопка "Статистика" и "Рестарт":
        imageRestartHardGeo = findViewById(R.id.imageRestartHardGeo);
        imageDiagramHardGeo = findViewById(R.id.imageDiagramHardGeo);
        flag = false;
        //Переход на предыдущую страницу:
        imageBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMenu.class);
            startActivity(intent);
            flag = true;
        });
        //Переход к уровню 1:
        hardGeolevel1.setOnClickListener(view -> {
            if (level >= 1) {
                Intent intent = new Intent(this, HardGeoLevel1.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 2:
        hardGeolevel2.setOnClickListener(view -> {
            if (level >= 2) {
                Intent intent = new Intent(this, HardGeoLevel2.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 3:
        hardGeolevel3.setOnClickListener(view -> {
            if (level >= 3) {
                Intent intent = new Intent(this, HardGeoLevel3.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 4:
        hardGeolevel4.setOnClickListener(view -> {
            if (level >= 4) {
                Intent intent = new Intent(this, HardGeoLevel4.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 5:
        hardGeolevel5.setOnClickListener(view -> {
            if (level >= 5) {
                Intent intent = new Intent(this, HardGeoLevel5.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 6:
        hardGeolevel6.setOnClickListener(view -> {
            if (level >= 6) {
                Intent intent = new Intent(this, HardGeoLevel6.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 7:
        hardGeolevel7.setOnClickListener(view -> {
            if (level >= 7) {
                Intent intent = new Intent(this, HardGeoLevel7.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 8:
        hardGeolevel8.setOnClickListener(view -> {
            if (level >= 8) {
                Intent intent = new Intent(this, HardGeoLevel8.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 9:
        hardGeolevel9.setOnClickListener(view -> {
            if (level >= 9) {
                Intent intent = new Intent(this, HardGeoLevel9.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 10:
        hardGeolevel10.setOnClickListener(view -> {
            if (level >= 10) {
                Intent intent = new Intent(this, HardGeoLevel10.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 11:
        hardGeolevel11.setOnClickListener(view -> {
            if (level >= 11) {
                Intent intent = new Intent(this, HardGeoLevel11.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 12:
        hardGeolevel12.setOnClickListener(view -> {
            if (level >= 12) {
                Intent intent = new Intent(this, HardGeoLevel12.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 13:
        hardGeolevel13.setOnClickListener(view -> {
            if (level >= 13) {
                Intent intent = new Intent(this, HardGeoLevel13.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 14:
        hardGeolevel14.setOnClickListener(view -> {
            if (level >= 14) {
                Intent intent = new Intent(this, HardGeoLevel14.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 15:
        hardGeolevel15.setOnClickListener(view -> {
            if (level >= 15) {
                Intent intent = new Intent(this, HardGeoLevel15.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 16:
        hardGeolevel16.setOnClickListener(view -> {
            if (level >= 16) {
                Intent intent = new Intent(this, HardGeoLevel16.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 17:
        hardGeolevel17.setOnClickListener(view -> {
            if (level >= 17) {
                Intent intent = new Intent(this, HardGeoLevel17.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 18:
        hardGeolevel18.setOnClickListener(view -> {
            if (level >= 18) {
                Intent intent = new Intent(this, HardGeoLevel18.class);
                startActivity(intent);flag = true;
            } else {

            }
        });//Переход к уровню 19:
        hardGeolevel19.setOnClickListener(view -> {
            if (level >= 19) {
                Intent intent = new Intent(this, HardGeoLevel19.class);
                startActivity(intent);flag = true;
            } else {

            }
        });
        //Переход к уровню 20:
        hardGeolevel20.setOnClickListener(view -> {
            if (level >= 20) {
                Intent intent = new Intent(this, HardGeoLevel20.class);
                startActivity(intent);flag = true;
            } else {

            }
        });

        final int [] numberOfLevel = {
                R.id.HardGeolevel1,
                R.id.HardGeolevel2,
                R.id.HardGeolevel3,
                R.id.HardGeolevel4,
                R.id.HardGeolevel5,
                R.id.HardGeolevel6,
                R.id.HardGeolevel7,
                R.id.HardGeolevel8,
                R.id.HardlGeolevel9,
                R.id.HardGeolevel10,
                R.id.HardGeolevel11,
                R.id.HardGeolevel12,
                R.id.HardGeolevel13,
                R.id.HardGeolevel14,
                R.id.HardGeolevel15,
                R.id.HardGeolevel16,
                R.id.HardGeolevel17,
                R.id.HardGeolevel18,
                R.id.HardGeolevel19,
                R.id.HardGeolevel20,
        };
        for (int i = 0; i < level; i++) {
            TextView textView = findViewById(numberOfLevel[i]);
            textView.setBackground(getDrawable(R.drawable.style_buttons_math_hard));
            textView.setText(""+(i+1));
        }
        imageRestartHardGeo.setOnClickListener(view -> {
            dialogGeoHardRestart.show();
        });

        GeolevelHardRestartYes.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityGeoHard.class);
            if (level > 1) {
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("GeoLevelHard", 1);
                editor.putInt("GeoLevelFalseHard", 0);
                editor.commit();
                for (int i = 1; i < level; i++) {
                    TextView textView = findViewById(numberOfLevel[i]);
                    textView.setBackground(getDrawable(R.drawable.style_buttons_not_pass_hard));
                    textView.setText("X");
                }
                dialogGeoHardRestart.dismiss();
                flag = true;
                startActivity(intent);
            }
        });
        GeolevelHardRestartNo.setOnClickListener(view -> {
            dialogGeoHardRestart.dismiss();
        });
        imageDiagramHardGeo.setOnClickListener(view -> {
            dialogGeoHardDiagram.show();
            if (level == 20) {
                decided.setText(String.valueOf(level));
            } else  {
                decided.setText(String.valueOf(level-1));
            }
            errors.setText(String.valueOf(save1.getInt("GeoLevelFalseHard", 0)));
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