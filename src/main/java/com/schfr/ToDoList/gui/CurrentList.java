package com.schfr.ToDoList.gui;

import com.schfr.ToDoList.model.CurrentListViewModel;
import com.schfr.ToDoList.model.HandleDataBase;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class CurrentList extends JPanel
{
    private int rowCounter;
    private CurrentListViewModel cLVM = CurrentListViewModel.getInstance();
    private HandleDataBase handleDataBase = HandleDataBase.getInstance();

    public CurrentList()
    {

        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(Color.getHSBColor(26.2f, 0.24f, 0.92f));
        setLayout(null);
        // Action to add user input to ToDoList by clicking on the ADD button or pressing enter.
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addToList();
                cLVM.getUserInput().setText("");
            }

            private void addToList()
            {
                if (!Objects.equals(cLVM.getUserInput().getText(), "") && rowCounter < cLVM.getToDoTable().getRowCount())
                {
                    handleDataBase.setTaskInput(cLVM.getUserInput().getText());
                    handleDataBase.setDateInput(handleDataBase.getDateInput());
                    handleDataBase.safeTasks();
                    cLVM.getToDoTable().setValueAt(cLVM.getUserInput().getText(), rowCounter, 0);
                    rowCounter += 1;
                }
            }
        };

        add(cLVM.getUserInput());
        add(cLVM.getBtAdd());
        add(cLVM.getContainer());
        add(cLVM.getTitel());
        add(cLVM.getCurrentDate());

        cLVM.getBtAdd().addActionListener(action);
        cLVM.getUserInput().addActionListener(action);

    }
}
