package com.example.quiz.DB;

import android.provider.BaseColumns;

public class MyDataBaseHelper {
    public static final String TABLE_NAME = "FirstTable";
    public static final String COLUMN_NAME_FIO = "Name";
    public static final String COLUMN_NAME_PASSWORD = "PASS";
    public static final String COLUMN_NAME_ALL_DECIDED = "ALLD";
    public static final String COLUMN_NAME_ALL_MISTAKES = "ALLM";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MyDataBaseHelper.TABLE_NAME + " (" +
                    MyDataBaseHelper.COLUMN_NAME_FIO + " TEXT," +
                    MyDataBaseHelper.COLUMN_NAME_PASSWORD + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MyDataBaseHelper.TABLE_NAME;

}
