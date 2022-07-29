package com.schfr.ToDoList.model;

import javax.persistence.*;

@Entity
public class ToDo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String task;

    public ToDo()
    {
    }

    public ToDo(String task)
    {
        this.task = task;
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
}
