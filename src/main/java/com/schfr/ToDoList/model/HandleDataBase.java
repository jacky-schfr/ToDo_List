package com.schfr.ToDoList.model;

import com.schfr.ToDoList.repository.ToDoRepository;
import com.schfr.ToDoList.service.ToDoService;
import org.springframework.context.ConfigurableApplicationContext;

public class HandleDataBase
{
    private static HandleDataBase handleDataBase = new HandleDataBase();

    private String taskInput;

    private ConfigurableApplicationContext applicationContext;
    ToDoService toDoService = new ToDoService();
    ToDoRepository toDoRepository;

    public void safeTasks()
    {
        for (ToDo task:toDoService.getAll())
        {
            toDoRepository.save(task);
        }
    }

    public void setApplicationContext(ConfigurableApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
        toDoRepository = applicationContext.getBean(ToDoRepository.class);
    }

    public String getTaskInput()
    {
        return taskInput;
    }

    public void setTaskInput(String taskInput)
    {
        this.taskInput = taskInput;
    }

    public static HandleDataBase getInstance()
    {
        return handleDataBase;
    }
}
