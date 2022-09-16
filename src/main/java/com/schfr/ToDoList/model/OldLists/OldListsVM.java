package com.schfr.ToDoList.model.OldLists;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OldListsVM
{
    private static OldListsVM oldListsVM = new OldListsVM();

    private JLabel titel;
    private JTable tableList;
    private JPanel container;

    public void createUI()
    {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setVerticalAlignment(JLabel.CENTER);

        titel = new JLabel("Past ToDo-Tasks");
        titel.setFont(new Font("Consolas", Font.PLAIN, 15));
        titel.setBounds(250, 15, 154, 14);

        DefaultTableModel model = new DefaultTableModel(1, 1)
        {
            @Override
            public Class getColumnClass(int column)
            {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        // defining the table for the ToDoList
        tableList = new JTable(model);
        tableList.setFont(new Font("Consolas", Font.PLAIN, 18));
        tableList.setDefaultRenderer(Object.class, centerRenderer);
        tableList.getColumnModel().getColumn(0).setHeaderValue("Choose a Date: ");
        tableList.setBounds(120, 50, 360, 470);
        tableList.setRowHeight(tableList.getBounds().height / 10);
        tableList.setRowSelectionAllowed(false);
        tableList.setAutoscrolls(true);

        // create a container for the table
        container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(tableList.getTableHeader(), BorderLayout.PAGE_START);
        container.add(tableList, BorderLayout.CENTER);
        tableList.setFillsViewportHeight(true);
        container.setBounds(120, 50, 360, 490);
    }

    public static OldListsVM getInstance()
    {
        oldListsVM.createUI();
        return oldListsVM;
    }

    public JLabel getTitel()
    {
        return titel;
    }

    public void setTitel(JLabel titel)
    {
        this.titel = titel;
    }

    public JPanel getContainer()
    {
        return container;
    }

    public void setContainer(JPanel container)
    {
        this.container = container;
    }
}
