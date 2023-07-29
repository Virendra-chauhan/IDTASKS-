import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Atm extends JFrame {

    private JFrame frame ;
    private JLabel depositLabel,balanceLabel,withdrawLabel,fixdLabel;
    private TextField depositField, withdrawField;
    private JButton depositButton,withdrawButton;
    private Account account;
    
    Atm() {
      frame = new JFrame();
      frame.setSize(450, 450);
      frame.setLayout((LayoutManager)null);
      frame.setTitle("ATM Console");
      frame.setLocationRelativeTo((Component)null);
      frame.getContentPane().setBackground(java.awt.Color.white);

      account = new Account();

      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
         System.err.println(e.getMessage());
      }

      balanceLabel = new JLabel("Balance : ");
      balanceLabel.setBounds(10, 1, 200, 100);
      frame.add(balanceLabel);

      depositLabel = new JLabel("Deposit : ");
      depositLabel.setBounds(10, 101, 200, 100);
      frame.add(depositLabel);

      withdrawLabel = new JLabel("Withdraw : ");
      withdrawLabel.setBounds(10, 201, 200, 100);
      frame.add(withdrawLabel);

      fixdLabel = new JLabel(" ");
      fixdLabel.setBounds(220, 1, 200, 100);
      frame.add(fixdLabel);

      depositField = new TextField();
      depositField.setBounds(220, 140, 200, 30);
      frame.add(depositField);

      withdrawField = new TextField();
      withdrawField.setBounds(220, 240, 200, 30);
      frame.add(withdrawField);

      depositButton = new JButton("Deposit");
      depositButton.setBounds(10, 330, 200, 50);
      frame.add(depositButton);

      withdrawButton = new JButton("Withdraw");
      withdrawButton.setBounds(230, 330, 200, 50);
      frame.add(withdrawButton);

      updateBalance();

      depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositMoney();
            }
        });

      withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawMoney();
            }
        });

      frame.setVisible(true);
    }

    private void updateBalance() {
        fixdLabel.setText("$" + account.getBalance());
    }

    private void depositMoney() {
        try {
            double amount = Double.parseDouble(depositField.getText());
            account.deposit(amount);
            updateBalance();
            depositField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.");
        }
    }

    private void withdrawMoney() {
        try {
            double amount = Double.parseDouble(withdrawField.getText());
            if (account.withdraw(amount)) {
                updateBalance();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds.");
            }
            withdrawField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid amount.");
        }
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
    }
}


class Account {
    private double balance;

    public Account() {
        balance = 10000.0; // Initial balance
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
