import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeGUI {
    private JFrame frame;
    private JButton[] buttons = new JButton[9];
    private char currentPlayer = 'X';
    private char[] board = { '_', '_', '_', '_', '_', '_', '_', '_', '_' };
    private boolean isAIEnabled = true;
    private Random random = new Random();

    public TicTacToeGUI() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton(" ");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 50));
            buttons[i].setFocusPainted(false);
            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (buttons[index].getText().equals(" ") && currentPlayer == 'X') {
                        makeMove(index);
                        if (!checkWin() && !isBoardFull() && isAIEnabled) {
                            aiMove();
                        }
                    }
                }
            });
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    private void makeMove(int index) {
        buttons[index].setText(String.valueOf(currentPlayer));
        board[index] = currentPlayer;
        if (checkWin()) {
            JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " wins!");
            resetBoard();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(frame, "It's a draw!");
            resetBoard();
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private void aiMove() {
        int index;
        do {
            index = random.nextInt(9);
        } while (board[index] != '_');
        makeMove(index);
    }

    private boolean checkWin() {
        int[][] winConditions = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
                { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
                { 0, 4, 8 }, { 2, 4, 6 }
        };
        for (int[] condition : winConditions) {
            if (board[condition[0]] == currentPlayer && board[condition[1]] == currentPlayer
                    && board[condition[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (char c : board) {
            if (c == '_')
                return false;
        }
        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText(" ");
            board[i] = '_';
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
