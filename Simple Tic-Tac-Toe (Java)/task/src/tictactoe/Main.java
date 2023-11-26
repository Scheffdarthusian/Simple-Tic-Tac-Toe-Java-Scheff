package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];

        //Initialize the board with empty spaces.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        //Print the game board and then place a move.
        printBoard(board);

        while (true) {
            xPlayerTurn(board, scanner);
            if (checkState(board)) {
                break;
            }
            printBoard(board);

            oPlayerTurn(board, scanner);
            if (checkState(board)) {
                break;
            }
            printBoard(board);
        }
        scanner.close();
    }

    private static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void xPlayerTurn(char[][] board, Scanner scanner) {
        String input;
        while (true) {
            System.out.println("X player, Place your move: ");
            input = scanner.nextLine();
            if (isValidMove(board, input)) {
                break;
            } else {
                System.out.println("Invalid move! Choose another one!");
            }
        }
        placeMove(board, input, 'X');
        printBoard(board);
    }

    private static void oPlayerTurn(char[][] board, Scanner scanner) {
        String input;
        while (true) {
            System.out.println("O player, Place your move: ");
            input = scanner.nextLine();
            if (isValidMove(board, input)) {
                break;
            } else {
                System.out.println("Invalid move! Choose another one!");
            }
        }
        placeMove(board, input, 'O');
        printBoard(board);
    }

    private static boolean isValidMove (char[][] board, String position) {
        switch(position) {
            case "1 1":
                return (board[0][0] == '_');
            case "1 2":
                return (board[0][1] == '_');
            case "1 3":
                return (board[0][2] == '_');
            case "2 1":
                return (board[1][0] == '_');
            case "2 2":
                return (board[1][1] == '_');
            case "2 3":
                return (board[1][2] == '_');
            case "3 1":
                return (board[2][0] == '_');
            case "3 2":
                return (board[2][1] == '_');
            case "3 3":
                return (board[2][2] == '_');
            default:
                return false;
        }
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1 1":
                board[0][0] = symbol;
                break;
            case "1 2":
                board[0][1] = symbol;
                break;
            case "1 3":
                board[0][2] = symbol;
                break;
            case "2 1":
                board[1][0] = symbol;
                break;
            case "2 2":
                board[1][1] = symbol;
                break;
            case "2 3":
                board[1][2] = symbol;
                break;
            case "3 1":
                board[2][0] = symbol;
                break;
            case "3 2":
                board[2][1] = symbol;
                break;
            case "3 3":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid");

        }
    }

    // Analyze the game state.
    private static boolean checkState(char[][] board) {
        if (isSymbolWon(board, 'X')) {
            printBoard(board);
            System.out.println("X wins");
            return true;
        }

        if (isSymbolWon(board, 'O')) {
            printBoard(board);
            System.out.println("O wins");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Ended in a tie");
        return true;
    }

    // This method is used to check if a given symbol has win condition.
    private static boolean isSymbolWon(char[][] board, char symbol) {
        return  board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol ||
                board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol ||
                board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol ||
                board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ||
                board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ||
                board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ||
                board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
                board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }
}