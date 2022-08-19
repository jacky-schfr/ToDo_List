package com.schfr.ToDoList.model;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class CurrentListVM
{
    private static CurrentListVM cLVM = new CurrentListVM();
    private JPanel container;
    private JTextField userInput;
    private JTable toDoTable;
    private JButton btAdd;
    private JLabel currentDate, titel;
    private HandleDataBase handleDataBase = HandleDataBase.getInstance();

    public void createUI()
    {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setVerticalAlignment(JLabel.CENTER);

        userInput = new JTextField();
        userInput.setFont(new Font("Consolas", Font.PLAIN, 14));
        userInput.setBounds(100, 44, 220, 30);

        titel = new JLabel("New ToDo-Task: ");
        titel.setFont(new Font("Consolas", Font.PLAIN, 15));
        titel.setBounds(100, 15, 154, 14);

        currentDate = new JLabel(handleDataBase.getDateInput(), SwingConstants.CENTER);
        currentDate.setFont(new Font("Consolas", Font.PLAIN, 24));
        currentDate.setBounds(390, 12, 150, 30);

        // changing the DefaultTableModel,so it can display boolean values to check-off the tasks
        DefaultTableModel model = new DefaultTableModel(5, 2)
        {
            @Override
            public Class getColumnClass(int column)
            {
                if (column == 0)
                {
                    return String.class;
                } else
                {
                    return Boolean.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int column)
            {
                if (column == 0)
                {
                    return false;
                } else
                {
                    return true;
                }
            }

        };

        // defining the table for the ToDoList
        toDoTable = new JTable(model);
        toDoTable.setFont(new Font("Consolas", Font.PLAIN, 18));
        toDoTable.setDefaultRenderer(Object.class, centerRenderer);
        toDoTable.getColumnModel().getColumn(0).setHeaderValue("TASKS");
        toDoTable.getColumnModel().getColumn(1).setHeaderValue("DONE?");
        toDoTable.setBounds(120, 150, 360, 370);
        toDoTable.setRowHeight(toDoTable.getBounds().height / 5);
        toDoTable.setRowSelectionAllowed(false);


        //create a container for a table
        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(toDoTable.getTableHeader(), BorderLayout.PAGE_START);
        container.add(toDoTable, BorderLayout.CENTER);
        toDoTable.setFillsViewportHeight(true);
        container.setBounds(120, 150, 360, 390);

        // generating the ADD button
        btAdd = new JButton("ADD");
        btAdd.setFont(new Font("Consolas", Font.BOLD, 18));
        btAdd.setBounds(100, 82, 89, 25);
        btAdd.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

    }

    public static CurrentListVM getInstance()
    {
        cLVM.createUI();
        return cLVM;
    }

    public JTextField getUserInput()
    {
        return userInput;
    }

    public void setUserInput(JTextField userInput)
    {
        this.userInput = userInput;
    }

    public JTable getToDoTable()
    {
        return toDoTable;
    }

    public void setToDoTable(JTable toDoTable)
    {
        this.toDoTable = toDoTable;
    }

    public JButton getBtAdd()
    {
        return btAdd;
    }

    public void setBtAdd(JButton btAdd)
    {
        this.btAdd = btAdd;
    }

    public JPanel getContainer()
    {
        return container;
    }

    public void setContainer(JPanel container)
    {
        this.container = container;
    }

    public JLabel getCurrentDate()
    {
        return currentDate;
    }

    public void setCurrentDate(JLabel currentDate)
    {
        this.currentDate = currentDate;
    }

    public JLabel getTitel()
    {
        return titel;
    }

    public void setTitel(JLabel titel)
    {
        this.titel = titel;
    }
}
