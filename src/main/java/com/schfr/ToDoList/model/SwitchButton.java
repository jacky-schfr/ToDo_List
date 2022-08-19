package com.schfr.ToDoList.model;

import com.schfr.ToDoList.controller.NavController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchButton extends JButton
{
    private String selectedPage;


    public SwitchButton(String location)
    {
        setText("Switch");
        setFont(new Font("Consolas", Font.BOLD, 15));
        setBounds(420, 45, 90, 20);
        setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        setVisible(true);

        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                NavController navController = NavController.getInstance();
                navController.navigateTo(location);
            }
        });
    }


    public String getSelectedPage()
    {
        return selectedPage;
    }

    public void setSelectedPage(String selectedPage)
    {
        this.selectedPage = selectedPage;
    }
}
