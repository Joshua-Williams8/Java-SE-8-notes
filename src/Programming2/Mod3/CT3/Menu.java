package Programming2.Mod3.CT3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Menu {

  public static void writeToFile(String inputText) {

    try {
      //Note: the path is for my MAC, you will need to edit this depending on your own path.
      File newTextFile = new File(File.separator + "tmp" + File.separator + "log.txt");

      FileWriter fw = new FileWriter(newTextFile);
      fw.write(inputText);
      fw.close();

    } catch (IOException ex) {
      System.out.println("There was an issue printing the file! \n" + ex.toString());
    }
  }

  public static Random randomizer = new Random();

  public static void main(String[] args) {
    JFrame menuFrame = new JFrame();
    menuFrame.setTitle("Menu");

    JPanel mainPanel = new JPanel(new GridLayout(5, 1, 3, 3));

    JButton dtButton = new JButton("Display Current Date and Time");
    JTextPane dtText = new JTextPane();
    dtText.setEditable(false);
    dtButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //This sets the date and time to the current date and time
        Date dtCurrent = new Date();
        dtText.setText(dtCurrent.toString());
      }
    });

    mainPanel.add(dtText);
    mainPanel.add(dtButton);


    JButton logButton = new JButton("Save to: C:\\tmp\\log.txt");
    logButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        writeToFile(dtText.getText());
      }
    });
    mainPanel.add(logButton);

    JButton colorButton = new JButton("Set Background to a Random Green Hue");

    colorButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Color bgColor = new Color(0, randomizer.nextInt(255), 0);
        //We actually cannot see the frame itself so we also need to
        // change the main panel color and the current panel
        menuFrame.setBackground(bgColor);
        mainPanel.setBackground(bgColor);
      }
    });

    mainPanel.add(colorButton);

    JButton exitButton = new JButton("Click to Exit");
    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        menuFrame.dispose();
      }
    });
    mainPanel.add(exitButton);

    //Adding main panel to the frame, also with the other settings
    menuFrame.add(mainPanel);
//    menuFrame.pack();
    menuFrame.setSize(300,400);
    menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuFrame.setVisible(true);
  }

}
