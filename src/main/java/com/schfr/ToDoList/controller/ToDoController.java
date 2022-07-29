package com.schfr.ToDoList.controller;

import com.schfr.ToDoList.model.ToDo;
import com.schfr.ToDoList.repository.ToDoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController
{
    private ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository)
    {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping
    public List<ToDo> index()
    {
        return toDoRepository.findAll();
    }
}
