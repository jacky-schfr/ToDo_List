package com.schfr.ToDoList.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ToDo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String task;

    private LocalDate date;

    public ToDo()
    {
    }

    public ToDo(String task)
    {
        this.task = task;
    }

    public ToDo(String task, LocalDate date)
    {
        this.task = task;
        this.date = date;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}
