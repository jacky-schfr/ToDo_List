package com.schfr.ToDoList.model.Welcome;


import javax.swing.*;
import java.awt.*;

public class WelcomeVM
{
    private static WelcomeVM welcomeVM = new WelcomeVM();

    private JTextArea welcomeText;

    public void createUI()
    {
        welcomeText =  new JTextArea("""
                Welcome to ToDo-List,

                I want to help you to become more productive.
                To help you boosting  your productivity
                without becoming overwhelmed, you can\s
                have up to 5 tasks a day.

                Your can check of your tasks to mark them as done.

                The minumum to maintain your streak is at least\s
                one task a day.
                It doesn not matter how big the step is,\s
                as long as it is in the right direction.

                As just mentioned you are able to check your streak\s
                and also look back on your past ToDo-Lists sorted \s
                by their dates.

                Good luck reaching your full potential\s
                and do not forget to have fun along the way!""");
        welcomeText.setFont(new Font("Consolas", Font.PLAIN, 17));
        welcomeText.setBounds(30, 50, 460, 440);


    }

    public static WelcomeVM getInstance()
    {
        welcomeVM.createUI();
        return welcomeVM;
    }

    public JTextArea getWelcomeText()
    {
        return welcomeText;
    }
}
