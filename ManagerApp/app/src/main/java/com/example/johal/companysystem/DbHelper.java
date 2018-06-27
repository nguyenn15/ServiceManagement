package com.example.johal.companysystem;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.widget.Toast.makeText;

/**
 * Created by nadim on 11/25/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static String DBNAME = "company.db";
    public static int VERSION = 4;
    public static String TableEmployee = "Employee";
    public static String TableManager = "Manager";
    SQLiteDatabase db;

    Activity context;
    public String dbName;

    //----------------------------------------------------------------------
    public DbHelper(Activity context)
    {
        super(context, DBNAME,null, VERSION);
        this.dbName = DBNAME;
        this.context = context;

    }

    public DbHelper(Activity context, String dbName, int dbVersion)
    {
        super(context, dbName,null, dbVersion);
        this.dbName = dbName;
        this.context = context;

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createEmployee = String.format("CREATE TABLE IF NOT EXISTS  %s (%s INTEGER primary key, " +
                        "%s text, %s text" +
                        ", %s INTEGER, %s text, %s text, %s text);",
                TableEmployee, "id","firstName","lastName","sin","userId","password","position");

        String createManager = String.format("CREATE TABLE IF NOT EXISTS  %s (%s INTEGER primary key, %s text, %s text" +
                        ", %s INTEGER, %s text, %s text);",
                TableManager, "id","firstName","lastName","sin","userId","password");
        try
        {
            Log.d("ggg","j");
            sqLiteDatabase.execSQL(createEmployee);
            sqLiteDatabase.execSQL(createManager);
            Toast.makeText(context, "Db created", Toast.LENGTH_SHORT).show();
        }
        catch(Exception ex)
        {
            Toast.makeText(context, "Error Db create", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropPlaylistTable = "Drop table if exists " + TableEmployee;
        String dropSongsTable = "Drop table if exists " + TableManager;
        try
        {
            Toast.makeText(context, "Dropping table...", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(dropPlaylistTable);
            sqLiteDatabase.execSQL(dropSongsTable);
            onCreate(sqLiteDatabase);
        }
        catch(Exception ex)
        {
            Toast.makeText(context, "Error Db create", Toast.LENGTH_SHORT).show();

        }
    }

    public void addEmployee(Employee employee)
    {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Id",employee.id);
        values.put("fisrtName",employee.firstname);
        values.put("lastName",employee.lastName);
        values.put("sin",employee.sin);
        values.put("userId",employee.email);
        values.put("password",employee.password);
        values.put("position",employee.position);
        result=db.insert(TableEmployee,null,values);
        if(result!=0){
            Toast.makeText(context,"data added",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"data error",Toast.LENGTH_SHORT).show();
        }


    }

    public void addManager(Manager employee)
    {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Id",employee.id);
        values.put("fisrtName",employee.firstname);
        values.put("lastName",employee.lastName);
        values.put("sin",employee.sin);
        values.put("userId",employee.email);
        values.put("password",employee.password);

        result=db.insert(TableEmployee,null,values);
        if(result!=0){
            Toast.makeText(context,"data added",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"data error",Toast.LENGTH_SHORT).show();
        }


    }


    }










