import java.util.Scanner;

class TicTacToe {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[] board = { '1', '2', '3',
                '4', '5', '6',
                '7', '8', '9' };
        var numberofSquaresPlayed = 0;
        var turn = 'X';
        var message = "Dil dukha hai par toota nhi hai!";

        while (numberofSquaresPlayed < 9) {
            printtheboard(board);
            System.out.println("Choose a board:" + turn);
            var input = sc.nextInt();
            if (Character.isDigit(board[input - 1])) {
                board[input - 1] = turn;
            } else {
                System.out.println("Sorry the Square is already taken!");
            }
            if (board[0] + board[1] + board[2] == (turn * 3)
                    || board[3] + board[4] + board[5] == (turn * 3)
                    || board[6] + board[7] + board[8] == (turn * 3)
                    || board[0] + board[4] + board[8] == (turn * 3)
                    || board[0] + board[3] + board[6] == (turn * 3)
                    || board[1] + board[4] + board[7] == (turn * 3)
                    || board[2] + board[5] + board[8] == (turn * 3)
                    || board[2] + board[4] + board[6] == (turn * 3)) {
                printtheboard(board);
                message = "Badhayi ho app aapko!";
                break;
            } else {
                numberofSquaresPlayed++;
                turn = (turn == 'X') ? 'O' : 'X';
            }

        }
        System.out.println("\n");

        System.out.println(message);

    }

    private static void printtheboard(char[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("\n---------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("\n---------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);

    }

}