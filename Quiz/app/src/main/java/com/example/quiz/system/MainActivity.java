package com.example.quiz.system;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.quiz.DB.FeedReaderDbHelper;
import com.example.quiz.DB.MyDataBaseHelper;
import com.example.quiz.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    private ImageView imageEarth, imageCloud, imageCloud2, imageCloud3;
    private Animation animationEarth, animationAppName, animationCloud, animationCloud2, animationCloud3;
    Button buttonStart;
    public boolean flag;
    public ImageView imageClipart;
    SharedPreferences saveAAA, dataBasePeople;
    SharedPreferences.Editor baseEditor;
    SQLiteDatabase db;
    FeedReaderDbHelper dbHelper;
    EditText textNamePlayer, textPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Создание анимации для первого слайда:
        animationEarth = AnimationUtils.loadAnimation(this, R.anim.anim_earth);
        animationAppName = AnimationUtils.loadAnimation(this, R.anim.anim_app_name);
        animationCloud = AnimationUtils.loadAnimation(this, R.anim.anim_cloud);
        animationCloud2 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud2);
        animationCloud3 = AnimationUtils.loadAnimation(this, R.anim.anim_cloud3);
        Window window1 = getWindow();
        window1.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Установка нулевой анимации:
        overridePendingTransition(0, 0);
        //Инициализация картинки земди:
        imageEarth = findViewById(R.id.imageEarth);
        //Инициализация облаков:
        imageCloud = findViewById(R.id.imageCloudAct1);
        imageCloud2 = findViewById(R.id.imageCloud2Act1);
        imageCloud3 = findViewById(R.id.imageCloud3Act1);
        //Инициализация кнокпи "играть":
        buttonStart = findViewById(R.id.buttonStart);
        //Работа со звуком "нота":
        imageClipart = findViewById(R.id.imageClipart);
        flag = false;
        saveAAA = getSharedPreferences("AAA", MODE_PRIVATE);
        SharedPreferences.Editor editor = saveAAA.edit();
        //Запоминаем логин при входе:
        dataBasePeople = getSharedPreferences("Base", MODE_PRIVATE);
        baseEditor = dataBasePeople.edit();
        //Подгрузка базы данных:
        dbHelper = new FeedReaderDbHelper(getApplicationContext());
        db = dbHelper.getReadableDatabase();
        textNamePlayer = findViewById(R.id.textNamePlayer);
        textPassword = findViewById(R.id.textPassword);


        editor.putInt("AAA", 1);
        if (saveAAA.getInt("AAA", 1) == 0) {
            imageClipart.setImageResource(R.drawable.clipart_false);
        }


        buttonStart.setOnClickListener(view -> {
            //Если пользователь не зарегистрирован, отправить его в окно регистрации и только после этого перевести в меню игры:
            ArrayList<String> listWithName = checkBaseName();
            ArrayList<String> listWithInfo = checkBaseNameAndPassword();
            String name = textNamePlayer.getText().toString();
            String password = textPassword.getText().toString();
            Intent intent = new Intent(this, ActivityMenu.class);

            if (!name.equals("") && !password.equals("")) {
                if (!listWithName.contains(name)) {
                    putInfoInBase(name, password);
                    baseEditor.putString("Base", name + password);
                    baseEditor.commit();
                    startActivity(intent);
                    flag = true;
                }
                if (listWithInfo.contains(name+password)) {
                    baseEditor.putString("Base", name + password);
                    baseEditor.commit();
                    startActivity(intent);
                    flag = true;
                }
            }
            if (listWithInfo.contains(dataBasePeople.getString("Base", null))) {
                startActivity(intent);
                flag = true;
            }



        });
        imageClipart.setOnClickListener(view -> {
            if (saveAAA.getInt("AAA", 1) == 1) {
                imageClipart.setImageResource(R.drawable.clipart_false);
                stopService(new Intent(this, MyService.class));
                editor.putInt("AAA", 0);
                editor.commit();
            } else {
                imageClipart.setImageResource(R.drawable.clipart);
                startService(new Intent(this, MyService.class));
                editor.putInt("AAA", 1);
                editor.commit();
            }
        });
        imageEarth.setOnClickListener(view -> {
            baseEditor.clear();
            baseEditor.commit();
            textNamePlayer.setVisibility(View.VISIBLE);
            textPassword.setVisibility(View.VISIBLE);
        });


    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageEarth.startAnimation(animationEarth);
        buttonStart.startAnimation(animationAppName);
        imageCloud.startAnimation(animationCloud);
        imageCloud2.startAnimation(animationCloud2);
        imageCloud3.startAnimation(animationCloud3);
        if (saveAAA.getInt("AAA", 1) == 0) {

        } else {
            startService(new Intent(this, MyService.class));
        }
        //Если пользователь не зарегистрирован, отправить его в окно регистрации и только после этого перевести в меню игры:
        ArrayList<String> listWithInfo = checkBaseNameAndPassword();
        if (listWithInfo.contains(dataBasePeople.getString("Base", null))) {

        } else {
            textNamePlayer.setVisibility(View.VISIBLE);
            textPassword.setVisibility(View.VISIBLE);
        }
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
    public ArrayList<String> checkBaseName () {
        String[] projection = {MyDataBaseHelper.COLUMN_NAME_FIO};
        Cursor cursor = db.query(MyDataBaseHelper.TABLE_NAME, projection, null, null, null, null, null, null);
        ArrayList <String> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            String itemName = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_NAME_FIO));
            itemIds.add(itemName);
        }
        cursor.close();
        return itemIds;
    }
    public ArrayList<String> checkBaseNameAndPassword () {
        String[] projection = {MyDataBaseHelper.COLUMN_NAME_FIO, MyDataBaseHelper.COLUMN_NAME_PASSWORD};
        Cursor cursor = db.query(MyDataBaseHelper.TABLE_NAME, projection, null, null, null, null, null, null);
        ArrayList <String> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            String itemName = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_NAME_FIO));
            String itemPass = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBaseHelper.COLUMN_NAME_PASSWORD));
            itemIds.add(itemName + itemPass);
        }
        cursor.close();
        return itemIds;
    }
    public void putInfoInBase (String name, String password) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDataBaseHelper.COLUMN_NAME_FIO, name);
        values.put(MyDataBaseHelper.COLUMN_NAME_PASSWORD, password);
        long newRowId = db.insert(MyDataBaseHelper.TABLE_NAME, null, values);
    }




}