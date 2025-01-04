package Programming2.Mod3;

import javax.swing.*;
import java.awt.*;

public class DicussionPost3 {
  public static void main(String[] args) {
    JFrame testFrame = new JFrame();
    testFrame.setTitle("Layout Test Frame");
    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel northPanel = new JPanel();
    northPanel.setBackground(Color.RED);
    northPanel.setPreferredSize(new Dimension(200, 200));

    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.GREEN);
    centerPanel.setPreferredSize(new Dimension(200, 200));


    JPanel southPanel = new JPanel();
    southPanel.setBackground(Color.BLUE);
    southPanel.setPreferredSize(new Dimension(200, 200));

    mainPanel.add(southPanel, BorderLayout.SOUTH);
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(northPanel, BorderLayout.NORTH);


    testFrame.add(mainPanel);
    testFrame.setSize(300,600);

    testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    testFrame.setVisible(true);
  }
}

////    JPanel northGridPanel = new JPanel(new GridLayout(2, 2, 3, 3));
////    JPanel centerBoxPanel = new JPanel(new BoxLayout(3, BoxLayout.Y_AXIS));
