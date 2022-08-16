package com.schfr.ToDoList;

import com.schfr.ToDoList.model.HandleDataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;


@SpringBootApplication
public class ToDoListApplication extends JFrame
{
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(ToDoListApplication.class, args);
		HandleDataBase.getInstance().setApplicationContext(applicationContext);
		new MainFrame();
	}
}
