import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NumGuessGUI {
    private int randomNumber;
    private int attemptsLeft = 5;
    private JTextField inputField;
    private JLabel messageLabel;
    private JLabel attemptsLabel;

    public NumGuessGUI() {
        // Generate a random number between 1 and 100
        randomNumber = 1 + (int) (100 * Math.random());

        // Create the frame
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        // Title label
        JLabel titleLabel = new JLabel("Guess a number between 1 and 100!", SwingConstants.CENTER);
        frame.add(titleLabel);

        // Input field
        inputField = new JTextField();
        frame.add(inputField);

        // Message label
        messageLabel = new JLabel("Enter your guess and press Submit", SwingConstants.CENTER);
        frame.add(messageLabel);

        // Attempts left label
        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft, SwingConstants.CENTER);
        frame.add(attemptsLabel);

        // Submit button
        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);

        // Action Listener for the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(inputField.getText());

            if (userGuess == randomNumber) {
                messageLabel.setText("🎉 Congratulations! You guessed it right!");
                disableInput();
            } else if (userGuess < randomNumber) {
                messageLabel.setText("⬆️ Your guess is too low.");
            } else {
                messageLabel.setText("⬇️ Your guess is too high.");
            }

            attemptsLeft--;
            attemptsLabel.setText("Attempts left: " + attemptsLeft);

            if (attemptsLeft == 0 && userGuess != randomNumber) {
                messageLabel.setText("❌ No more attempts! The number was: " + randomNumber);
                disableInput();
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("⚠️ Please enter a valid number.");
        }
    }

    private void disableInput() {
        inputField.setEnabled(false);
    }

    public static void main(String[] args) {
        new NumGuessGUI();
    }
}
