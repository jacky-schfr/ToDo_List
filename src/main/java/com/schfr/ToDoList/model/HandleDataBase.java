package com.schfr.ToDoList.model;

import com.schfr.ToDoList.repository.ToDoRepository;
import com.schfr.ToDoList.service.ToDoService;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HandleDataBase
{
    private static HandleDataBase handleDataBase = new HandleDataBase();

    private String taskInput;

    private String dateInput = String.valueOf(java.time.LocalDate.now());

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

    public String getDateInput()
    {
        return dateInput;
    }

    public void setDateInput(String dateInput)
    {
        this.dateInput = dateInput;
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
