package com.schfr.ToDoList.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentList extends JFrame
{
    private JPanel contentPane;
    private JTextField userInput;
    private JTable toDoTable;

    public CurrentList() {

        setTitle("ToDo-List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 150, 329, 169);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        userInput = new JTextField();
        userInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userInput.setBounds(20, 44, 220, 22);
        contentPane.add(userInput);

        JLabel titel = new JLabel("New ToDo-Task: ");
        titel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        titel.setBounds(10, 18, 154, 14);
        contentPane.add(titel);

        toDoTable = new JTable();
        toDoTable.setAutoResizeMode(4);
        toDoTable.setBounds(50,10,150,170);;
        contentPane.add(toDoTable);

        JButton btAdd = new JButton("ADD");
        btAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addToList();

            }

            private void addToList()
            {
                toDoTable.addColumn(new TableColumn(1));
            }
        });
        btAdd.setBounds(20, 82, 89, 25);
        contentPane.add(btAdd);

        setVisible(true);
    }
}
