package com.schfr.ToDoList.model.OldLists;


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
