package com.schfr.ToDoList;

//import com.schfr.ToDoList.controller.NavController;


import com.schfr.ToDoList.controller.NavController;

import javax.swing.*;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        NavController navController = NavController.getInstance();

        setTitle("ToDo-List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 150, 600, 600);
        setLocationByPlatform(true);

        navController.setJFrame(this);
        navController.navigateTo("current");

        setVisible(true);
    }
}
