package com.schfr.ToDoList.gui;

import com.schfr.ToDoList.model.HandleDataBase;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CurrentList extends JFrame
{
    private JPanel contentPane;
    private JTextField userInput;
    private JTable toDoTable;
    private int rowCounter;
    private HandleDataBase handleDataBase = HandleDataBase.getInstance();

    // ToDo Create a CloumnTable (or similar) where the text will be centered for the table

    public CurrentList() {

        setTitle("ToDo-List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 150, 600, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.getHSBColor(26.2f, 0.24f, 0.92f));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        userInput = new JTextField();
        userInput.setFont(new Font("Consolas", Font.PLAIN, 14));
        userInput.setBounds(20, 44, 220, 30);
        contentPane.add(userInput);

        JLabel titel = new JLabel("New ToDo-Task: ");
        titel.setFont(new Font("Consolas", Font.PLAIN, 15));
        titel.setBounds(20, 15, 154, 14);
        contentPane.add(titel);

        JLabel currentDate = new JLabel(handleDataBase.getDateInput(), SwingConstants.CENTER);
        currentDate.setFont(new Font("Consolas", Font.PLAIN, 20));
        currentDate.setBounds(400, 15, 120, 30);
        currentDate.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        contentPane.add(currentDate);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        centerRenderer.setVerticalAlignment(JLabel.CENTER);

        toDoTable = new JTable(new DefaultTableModel(5, 2));
        toDoTable.setAutoResizeMode(4);
        toDoTable.setFont(new Font("Consolas", Font.PLAIN, 20));
        toDoTable.setDefaultRenderer(Object.class, centerRenderer);
        toDoTable.setBounds(120,150,360,370);
        toDoTable.setRowHeight(toDoTable.getBounds().height/5);
        contentPane.add(toDoTable);

        JButton btAdd = new JButton("ADD");
        btAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addToList();
                userInput.setText("");
            }

            private void addToList()
            {
                if (!Objects.equals(userInput.getText(), "") && rowCounter < toDoTable.getRowCount())
                {
                    handleDataBase.setTaskInput(userInput.getText());
                    handleDataBase.setDateInput(handleDataBase.getDateInput());
                    handleDataBase.safeTasks();
                    toDoTable.setValueAt(userInput.getText(), rowCounter, 0);
                    rowCounter += 1;
                }
            }
        });
        btAdd.setBounds(20, 82, 89, 25);
        contentPane.add(btAdd);

        setVisible(true);
    }
}
