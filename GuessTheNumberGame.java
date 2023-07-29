import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumberGame extends JFrame {
    private int randomNumber;
    private int attemptsLeft;
    private JTextField guessTextField;
    private JButton submitButton;
    private JLabel messageLabel;

    public GuessTheNumberGame() {
        randomNumber = generateRandomNumber();
        attemptsLeft = 3;

        setTitle("Guess the Number Game");
        setSize(500, 150);
        setLayout(new FlowLayout());

        messageLabel = new JLabel("Guess a number between 1 and 100. Attempts left: " + attemptsLeft);
        add(messageLabel);

        guessTextField = new JTextField(10);
        add(guessTextField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        add(submitButton);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generates a random number between 1 and 100
    }

    private void checkGuess() {
        int guess;
        try {
            guess = Integer.parseInt(guessTextField.getText());
        } catch (NumberFormatException ex) {
            showMessage("Invalid input. Please enter a valid number.");
            return;
        }

        if (guess == randomNumber) {
            showMessage("Congratulations! You guessed the correct number.");
            resetGame();
        } else {
            attemptsLeft--;
            if (attemptsLeft > 0) {
                showMessage("Wrong! Try again. Attempts left: " + attemptsLeft);
            } else {
                showMessage("Game over! The number was " + randomNumber + ".");
                resetGame();
            }
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void resetGame() {
        randomNumber = generateRandomNumber();
        attemptsLeft = 3;
        messageLabel.setText("Guess a number between 1 and 100. Attempts left: " + attemptsLeft);
        guessTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuessTheNumberGame game = new GuessTheNumberGame();
            game.setVisible(true);
        });
    }
}

