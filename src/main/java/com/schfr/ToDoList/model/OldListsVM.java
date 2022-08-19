package com.schfr.ToDoList.model;

import javax.swing.*;
import java.awt.*;


public class OldListsVM
{
    private static OldListsVM oldListsVM = new OldListsVM();

    public void createUI()
    {

    }

    public static OldListsVM getInstance()
    {
        oldListsVM.createUI();
        return oldListsVM;
    }

}
