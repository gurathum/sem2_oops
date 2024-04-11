package com.example.project;
import java.util.Scanner;
public class Game {

    // This class manages the overall game flow, including player turns, win/loss conditions, and statistics.
    private GameBoard board;
    private Player player1;
    private Player player2;
    private char currentPlayer;

    public Game() {
        currentPlayer = 'X'; // Player 1 always starts
        player1 = new Player(); // Create empty Player objects here
        player2 = new Player();
    }

    public void choosePlayerSymbols() {
        Scanner scanner = new Scanner(System.in);
        char player1Symbol;

        do {
            System.out.println("Player 1, choose X or O: ");
            player1Symbol = scanner.next().charAt(0);
            player1Symbol = Character.toUpperCase(player1Symbol); // Ensure case-insensitive input
        } while (player1Symbol != 'X' && player1Symbol != 'O');

        player1.setSymbol(player1Symbol);
        player2.setSymbol((player1Symbol == 'X') ? 'O' : 'X');

        System.out.println("Player 1: " + player1.getSymbol() + ", Player 2: " + player2.getSymbol());
    }

    public void startGame(Player player1, Player player2) {
        // Main game loop creating a fresh board each game, handling player turns, board updates, and win/draw conditions
        Scanner scanner = new Scanner(System.in);
        board = new GameBoard();

        while (!isGameOver()) {
            board.printBoard();

            System.out.println("Player " + currentPlayer + ", enter a slot number (1-9): ");
            int move = scanner.nextInt() - 1;

            if (board.makeMove(currentPlayer, move)) {
                if (isWinner(currentPlayer)) {
                    getPlayer(currentPlayer).addWin();
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        board.printBoard();

        if (isWinner(currentPlayer)) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            player1.addDraw();
            player2.addDraw();
            System.out.println("It's a draw!");
        }
    }

    private boolean isGameOver() {
        // Checks if the game is over due to a winner or a full board
        return isWinner(currentPlayer) || board.isBoardFull();
    }

    private boolean isWinner(char symbol) {
        char[][] currentBoard = board.getBoard();

        // (check rows, columns, diagonals)

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (currentBoard[i][0] == symbol && currentBoard[i][1] == symbol && currentBoard[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (currentBoard[0][i] == symbol && currentBoard[1][i] == symbol && currentBoard[2][i] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (currentBoard[0][0] == symbol && currentBoard[1][1] == symbol && currentBoard[2][2] == symbol) {
            return true;
        }
        if (currentBoard[0][2] == symbol && currentBoard[1][1] == symbol && currentBoard[2][0] == symbol) {
            return true;
        }

        return false;
    }

    private Player getPlayer(char symbol) {
        if (symbol == player1.getSymbol()) {
            return player1;
        } else {
            return player2;
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
