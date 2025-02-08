package Programming2.Mod2.CT2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CT2 {
  public static void main(String[] args) {
    //Setup
    BankAccount testAccount = new BankAccount();
    testAccount.setAccountID(1234);
    testAccount.setBalance(0);
    testAccount.setFirstName("Johnny");
    testAccount.setLastName("Bravo");
    JFrame bankFrame = new JFrame();
    bankFrame.setTitle("Bank Account");


    JPanel mainBankPanel = new JPanel(new BorderLayout());

    //Text panel setup
    JPanel textPanel = new JPanel(new BorderLayout());

    JTextArea introText = new JTextArea("Please review your account information below, and select whether to withdraw or deposit below.");
    introText.setBorder(new LineBorder(Color.BLACK));
    introText.setWrapStyleWord(true);
    introText.setLineWrap(true);

    JTextArea bankInfo = new JTextArea(testAccount.accountSummary());
    bankInfo.setBorder(new LineBorder(Color.BLACK));
    bankInfo.setWrapStyleWord(true);
    bankInfo.setLineWrap(true);

    textPanel.add(introText, BorderLayout.NORTH);
    textPanel.add(bankInfo);
    textPanel.setSize(200,200);



    //Deposit panel setup
    JPanel inputPanel = new JPanel(new GridLayout(1, 1, 3, 3));
    JTextField inputField = new JTextField();
    inputField.setSize(100,50);
    inputPanel.add(inputField);
//    inputPanel.setSize(200,200);

    //Button panel setup
    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 3, 3));
    JButton withButton = new JButton("Withdraw");
    withButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        testAccount.withdrawal(Double.parseDouble(inputField.getText()));
        bankInfo.setText(testAccount.accountSummary());
      }
    });

    JButton depoButton = new JButton("Deposit");
    depoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        testAccount.deposit(Double.parseDouble(inputField.getText()));
        bankInfo.setText(testAccount.accountSummary());
      }
    });

    buttonPanel.add(depoButton);
    buttonPanel.add(withButton);

    //Adding all the parts together
    mainBankPanel.add(textPanel, BorderLayout.NORTH);
    mainBankPanel.add(inputPanel, BorderLayout.CENTER);
    mainBankPanel.add(buttonPanel, BorderLayout.SOUTH);
    mainBankPanel.setSize(250,650);

    bankFrame.add(mainBankPanel);
    bankFrame.setSize(250,250);

    // Should come last
    bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    bankFrame.setVisible(true);


  }
}
