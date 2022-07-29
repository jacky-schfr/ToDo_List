package com.schfr.ToDoList;

import com.schfr.ToDoList.gui.CurrentList;
import com.schfr.ToDoList.model.ToDo;
import com.schfr.ToDoList.repository.ToDoRepository;
import com.schfr.ToDoList.service.ToDoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class ToDoListApplication extends JFrame
{
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ToDoListApplication.class, args);

		ToDoService toDoService = new ToDoService();

		CurrentList currentList = new CurrentList();

		ToDoRepository toDoRepository = applicationContext.getBean(ToDoRepository.class);

		for (ToDo task:toDoService.getAll())
		{
			toDoRepository.save(task);
		}
	}

}
