package com.schfr.ToDoList.service;

import com.schfr.ToDoList.model.HandleDataBase;
import com.schfr.ToDoList.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService
{
    public List<ToDo> getAll()
    {
        HandleDataBase handleDataBase = HandleDataBase.getInstance();
        ArrayList<ToDo> dailyTasks = new ArrayList<>();

        dailyTasks.add(new ToDo(handleDataBase.getTaskInput()));


        return dailyTasks;
    }
}
