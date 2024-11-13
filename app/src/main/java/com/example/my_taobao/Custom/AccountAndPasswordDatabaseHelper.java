package com.example.my_taobao.Custom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountAndPasswordDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AccountAndPasswordDatabaseHelper.db"; // 数据库名称
    private static final int DATABASE_VERSION = 1; // 数据库版本

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS my_table (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "text TEXT, " +
            "price TEXT, " +
            "quantity TEXT, " +
            "picture Integer)";

    public AccountAndPasswordDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS my_table");
        onCreate(db);
    }
}
