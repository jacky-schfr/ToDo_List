package com.schfr.ToDoList.model;

import com.schfr.ToDoList.repository.ToDoRepository;
import com.schfr.ToDoList.service.ToDoService;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class HandleDataBase
{
    // creating object of HandleDataBase to use as a singleton
    private static HandleDataBase handleDataBase = new HandleDataBase();

    private String taskInput;
    private LocalDate dateInput = java.time.LocalDate.now();

    ToDoService toDoService = new ToDoService();
    ToDoRepository toDoRepository;

    // saving file (in sql)
    public void safeTasks()
    {
        for (ToDo task : toDoService.getAll())
        {
            toDoRepository.save(task);
        }
    }

    // load file by date
    public ArrayList<String> loadTasks(String dateSearch)
    {
        java.sql.Date date = Date.valueOf(dateSearch);

        ArrayList<String> taskList = new ArrayList<>();

        for (int i = 0; i < toDoRepository.findAll().size(); i++)
        {
            if (Objects.equals(date, Date.valueOf(toDoRepository.findAll().get(i).getDate())))
            {
                taskList.add(toDoRepository.findAll().get(i).getTask());
            }
            else
            {
                return null;
            }
        }
        return taskList;
    }

    public void setApplicationContext(ConfigurableApplicationContext applicationContext)
    {
        toDoRepository = applicationContext.getBean(ToDoRepository.class);
    }

    public LocalDate getDateInput()
    {
        return dateInput;
    }

    public void setDateInput(LocalDate dateInput)
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

    // method for creating an instance of HandleDataBase to use as a singleton
    public static HandleDataBase getInstance()
    {
        return handleDataBase;
    }
}
