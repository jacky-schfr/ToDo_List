package com.schfr.ToDoList.gui;

import com.schfr.ToDoList.model.OldListsVM;
import com.schfr.ToDoList.model.SwitchButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OldLists extends JPanel
{
    private OldListsVM oLVM = OldListsVM.getInstance();
    private SwitchButton switchButton = new SwitchButton("current");

    public OldLists()
    {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(Color.getHSBColor(26.2f, 0.24f, 0.92f));
        setLayout(null);
        add(switchButton);
    }
}
