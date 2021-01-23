package com.example.todolistapp;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Todo.class},version = 1)
public abstract class TodoRoomDatabase extends RoomDatabase {

    private static TodoRoomDatabase INSTANCE;


    public abstract TodoDao todoDao();

    public static TodoRoomDatabase getInstance(final Context context) {
        if(INSTANCE == null) {
            synchronized (TodoRoomDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodoRoomDatabase.class, "todo_database")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private TodoDao todoDao;
        public PopulateDbAsync(TodoRoomDatabase instance) {
            todoDao = instance.todoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
