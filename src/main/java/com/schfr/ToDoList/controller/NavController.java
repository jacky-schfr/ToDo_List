package com.schfr.ToDoList.controller;

import com.schfr.ToDoList.gui.CurrentList;
import com.schfr.ToDoList.gui.OldLists;
import com.schfr.ToDoList.model.SwitchButton;

import javax.swing.*;
import java.awt.*;

public class NavController
{
    private static NavController navController = new NavController();

    private JFrame jFrame;
    private String tag;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CurrentList cL;
    private OldLists oL;

    public NavController()
    {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        cL = new CurrentList();
        oL = new OldLists();

        mainPanel.add(cL, "current");
        mainPanel.add(oL, "past");


        mainPanel.setVisible(true);
    }

    public void navigateTo (String location)
    {
        cardLayout.show(mainPanel, location);
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public CardLayout getCardLayout()
    {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout)
    {
        this.cardLayout = cardLayout;
    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    public static NavController getInstance()
    {
        return navController;
    }

    public void setJFrame(JFrame jFrame)
    {
        this.jFrame = jFrame;
        this.jFrame.add(mainPanel);
    }
}
