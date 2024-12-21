package Programming2.Mod2.CT;

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



    //Deposit panel setup
    JPanel inputPanel = new JPanel(new GridLayout(1, 1, 3, 3));
    JTextField inputField = new JTextField();
    inputPanel.add(inputField);

    //Button panel setup
    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 3, 3));
    JButton withButton = new JButton("Withdraw");
    withButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
        testAccount.withdrawal(Double.parseDouble(inputField.getText()));
        bankInfo.setText(testAccount.accountSummary());
      }
    });

    JButton depoButton = new JButton("Deposit");
    depoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
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

    bankFrame.add(mainBankPanel);

    // Should come last
    bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    bankFrame.pack();
    bankFrame.setVisible(true);


  }
}
