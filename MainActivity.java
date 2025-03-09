package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText taskInput;
    private Button addButton;
    private ListView taskListView;
    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        addButton = findViewById(R.id.addButton);
        taskListView = findViewById(R.id.taskListView);
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, taskList);

        taskListView.setAdapter(taskAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskText = taskInput.getText().toString();
                if (!taskText.isEmpty()) {
                    Task newTask = new Task(taskText);
                    taskList.add(newTask);
                    taskAdapter.notifyDataSetChanged();
                    taskInput.setText("");
                }
            }
        });
    }
}
