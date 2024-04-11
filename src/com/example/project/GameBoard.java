package com.example.project;

public class GameBoard {
    // This class represents the Tic Tac Toe game board.
    // It stores the board state as a 2D character array.
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        // Prints the current state of the game board to the console
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
            if (i < 2) {
                System.out.println("-------");
            }
        }
    }

    public boolean makeMove(char symbol, int move) {
        // Place the symbol of the current player on the specified move location on the board
        // Returns true if the move was successful, false otherwise
        if (isValidMove(move)) {
            int row = move / 3;
            int col = move % 3;
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int move) {
        if (move < 0 || move > 8) { // Check if move is out of bounds (1-9)
            return false;
        }

        int row = (move) / 3;
        int col = (move) % 3;

        // Checking if the place is empty i.e. '-'
        return board[row][col] == '-';
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getBoard() {
        return board;
    }
}

