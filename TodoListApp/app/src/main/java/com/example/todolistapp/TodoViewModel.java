package com.example.todolistapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private TodoRepository todoRepository;
    private LiveData<List<Todo>> allTodo;
    public TodoViewModel(@NonNull Application application) {
        super(application);
        todoRepository = new TodoRepository(application);
        allTodo = todoRepository.getAllTodos();
    }
    LiveData<List<Todo>> getAllTodo() {
        return allTodo;
    }
    public void insert(Todo todo) {
        todoRepository.insert(todo);
    }
}
