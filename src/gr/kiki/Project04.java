package gr.kiki;

import java.util.Scanner;

public class Project04 {

    private static final char[][] board = {{'1', '2', '3'},
                                           {'4', '5', '6'},
                                           {'7', '8', '9'}};
    private static char player = 'X';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String playerChoice;
        char choice;
        int timesPlayed = 0;
        boolean isVoid;

        while (timesPlayed < 9) {
            printBoard(board);
            System.out.printf("Player %s Please make a choice between 1 and 9", player);
            System.out.println();
            playerChoice = scanner.nextLine();
            choice = playerChoice.charAt(0);
            isVoid = placeMark(choice, board);
//            printBoard(board);

            if (!win() && !isVoid) {
                player = (player == 'X') ? 'O' : 'X';
                timesPlayed++;

            } else if (isVoid) {
                System.out.println("Invalid option try again.");

            } else {
                printBoard(board);
                System.out.printf("You won player %s 🥳🎉🥳", player);
                System.out.println();
                break;
            }
            if (!win() && timesPlayed == 9) {
                printBoard(board);
                System.out.println("It's a draw 🙌😁🙌");
                break;
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("- + - + -");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("- + - + -");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println();
    }

    public static boolean placeMark(char userChoice, char[][] board) {
        boolean isVoid = true;

        for (int e = 0; e < board.length; e++) {
            for (int i = 0; i < board[e].length; i++) {
                if (userChoice == board[e][i]) {
                    board[e][i] = player;
                    isVoid = false;
                }

            }
        } return isVoid;
    }

    public static boolean win() {
        boolean win = false;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][0] == player && board[row][1] == player && board[row][2] == player ||
                        board[0][col] == player && board[1][col] == player && board[2][col] == player ||
                        board[0][0] == player && board[1][1] == player && board[2][2] == player ||
                        board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                    win = true;
                    break;
                }
            }
        }
        return win;
    }
}



