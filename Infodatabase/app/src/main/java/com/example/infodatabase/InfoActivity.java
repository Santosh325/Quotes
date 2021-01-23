package com.example.infodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.infodatabase.InfoContract.InfoListEntry.TABLE_NAME;

public class InfoActivity extends AppCompatActivity {
    private EditText editTextName, editTextAddress,editTextPhoneNumber;
    private InfoDbHelper mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        editTextName = findViewById(R.id.name);
        editTextAddress = findViewById(R.id.address);
        editTextPhoneNumber = findViewById(R.id.phoneNo);
    }




}