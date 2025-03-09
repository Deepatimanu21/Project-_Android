package com.example.todolist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var taskInput: EditText
    private lateinit var addButton: Button
    private lateinit var taskListView: ListView
    private var taskList: ArrayList<Task> = ArrayList()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskInput = findViewById(R.id.taskInput)
        addButton = findViewById(R.id.addButton)
        taskListView = findViewById(R.id.taskListView)
        taskAdapter = TaskAdapter(this, taskList)

        taskListView.adapter = taskAdapter

        addButton.setOnClickListener {
            val taskText = taskInput.text.toString()
            if (taskText.isNotEmpty()) {
                val newTask = Task(taskText)
                taskList.add(newTask)
                taskAdapter.notifyDataSetChanged()
                taskInput.text.clear()
            }
        }
    }
}
