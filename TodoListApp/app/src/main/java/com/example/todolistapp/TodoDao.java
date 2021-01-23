package com.example.todolistapp;

import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    public void insert(Todo todo);

    @Query("DElETE FROM todo_table")
    public void deleteAll();

    @Query("DELETE FROM todo_table WHERE id=:id")
    public int deleteTodoById(int id);

    @Query("SELECT * FROM todo_table ORDER BY todo_column DESC")
    LiveData<List<Todo>> getAllTodo();
}
