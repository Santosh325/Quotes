package com.example.todolistapp;

import android.app.Application;
import android.app.AsyncNotedAppOp;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoRepository {
    private TodoDao todoDao;
    private LiveData<List<Todo>> allTodos;

    public TodoRepository(Application application) {
        TodoRoomDatabase db = TodoRoomDatabase.getInstance(application);
        todoDao = db.todoDao();
        allTodos = todoDao.getAllTodo();
    }

    LiveData<List<Todo>> getAllTodos() {
        return allTodos;
    }

    void insert(Todo todo) {
        new insertAsyncTask(todoDao).execute(todo);
    }

    private class insertAsyncTask extends AsyncTask<Todo,Void,Void> {
        private TodoDao asyncTaskDao;
        public insertAsyncTask(TodoDao todoDao) {
            asyncTaskDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
