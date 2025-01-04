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
    menuFrame.setTitle("Bank Account");


    //Going with Grid Layout since we know we need 4 menu options, may adjust this to a 2 x 2
    JPanel mainPanel = new JPanel(new GridLayout(4, 1, 3, 3));


    //  When the user selects the first menu option, then the date and time should be printed in a text box.
    JPanel dateTimePanel = new JPanel(new BorderLayout());
    //  JTextArea dtIntro = new JTextArea();
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
    dateTimePanel.add(dtText, BorderLayout.CENTER);
    dateTimePanel.add(dtButton, BorderLayout.SOUTH);
//    dateTimePanel.setPreferredSize(new Dimension(200, 50));


    //When the user selects the second menu option,
    // then the text box contents should be written to a text file named "log.txt."
    JPanel logPanel = new JPanel(new BorderLayout());
    JButton logButton = new JButton("Save to: C:\\tmp\\log.txt");
    JTextPane logText = new JTextPane();
    logButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        writeToFile(logText.getText());
      }
    });
    logPanel.add(logText, BorderLayout.CENTER);
    logPanel.add(logButton, BorderLayout.SOUTH);
//    logPanel.setPreferredSize(new Dimension(200, 50));


    //When the user selects the third menu item then the frame background color changes to
    // random color hue of the color green. The menu option should display
    // the initial random hue each time selected for a single execution of the program.
    // See https://www.w3schools.com/colors/colors_picker.asp to an external site.
    JPanel colorPanel = new JPanel(new BorderLayout());
    JButton colorButton = new JButton("Set Background to a Random Green");
//    JTextPane logText = new JTextPane();
    colorButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
//      Made the max 240 to avoid picking too dark of a green to see
        Color bgColor = new Color(0, randomizer.nextInt(240), 0);
        //We actually cannot see the frame itself so we also need to
        // change the main panel color and the current panel
        menuFrame.setBackground(bgColor);
        mainPanel.setBackground(bgColor);
        colorPanel.setBackground(bgColor);
      }
    });
    colorPanel.add(colorButton, BorderLayout.SOUTH);

    //When the user selects the fourth menu option then the program exits.
    JPanel exitPanel = new JPanel(new BorderLayout());
    JButton exitButton = new JButton("Click to Exit");
//    JTextPane logText = new JTextPane();
    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        menuFrame.dispose();
      }
    });
    exitPanel.add(exitButton, BorderLayout.SOUTH);

    //Adding sub panels to main panel
    mainPanel.add(dateTimePanel);
    mainPanel.add(logPanel);
    mainPanel.add(colorPanel);
    mainPanel.add(exitPanel);

    //Adding main panel to the frame, also with the other settings
    menuFrame.add(mainPanel);
//    menuFrame.pack();
    menuFrame.setSize(300,700);
    menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuFrame.setVisible(true);
  }

}
