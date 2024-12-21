package Programming2.Mod2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class DiscussionPost {


  public static void main(String[] args) {

    JButton mybutton = new JButton("Change");
//    ActionListener myListener = new Ac;
//    mybutton.addActionListener(mylistener);
    JPanel leftPanel = new JPanel();
    leftPanel.setSize(200,200);
    JTextArea leftText = new JTextArea("This is the left text.");
    leftPanel.add(leftText);
    leftPanel.setVisible(true);

    JPanel rightPanel = new JPanel();
    rightPanel.setSize(200,200);
    JTextArea rightText = new JTextArea("This is the right text");
    rightPanel.add(rightText);
    rightPanel.setVisible(true);

    JFrame testFrame = new JFrame();
    testFrame.setTitle("Test Frame");
    testFrame.setSize(600, 200);
    testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    testFrame.add(leftPanel);
    testFrame.add(rightPanel);
    // Should come last
    testFrame.setVisible(true);


//    mypanel.add(mybutton);
    //   GridBagConstraints testGrid = null;

//    testGrid = new GridBagConstraints();
//    testGrid.gridx = 0;
//    testGrid.gridy = 0;
//    testGrid.insets = new Insets(10, 10, 10, 10);
//    testFrame.add(leftPanel, testGrid);

//    testGrid = new GridBagConstraints();
//    testGrid.gridx = 20;
//    testGrid.gridy = 20;
//    testGrid.insets = new Insets(10, 10, 10, 10);
//    testFrame.add(rightPanel, testGrid);



  }

}
