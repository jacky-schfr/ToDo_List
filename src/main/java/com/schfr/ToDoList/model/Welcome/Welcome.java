package com.schfr.ToDoList.model.Welcome;

import com.schfr.ToDoList.model.SwitchButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Welcome extends JPanel
{
    private WelcomeVM welcomeVM = WelcomeVM.getInstance();
    private SwitchButton switchButton = new SwitchButton("current");

    public Welcome()
    {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(Color.getHSBColor(26.2f, 0.24f, 0.92f));
        setLayout(null);
        add(switchButton);

        add(welcomeVM.getWelcomeText());
    }
}
