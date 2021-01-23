package com.example.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Todo> todoList;

    public TodoListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
       if(todoList != null) {
           Todo current = todoList.get(position);
           holder.todoTextView.setText(current.getTodo());
       } else {
           holder.todoTextView.setText("There is no todo");
       }
    }

    void setTodos(List<Todo> todos) {
        todoList = todos;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(todoList != null) {
            return todoList.size();
        } else {
            return 0;
        }
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView todoTextView;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            todoTextView = itemView.findViewById(R.id.textView);
        }
    }
}
