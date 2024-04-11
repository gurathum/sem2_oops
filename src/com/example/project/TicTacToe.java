package com.example.project;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain;
        Game game = new Game();

        // do-while loop to allow players to play multiple games.
        do{
            // Choose player symbols, start the game, and then display player statistics after each round.
            game.choosePlayerSymbols();
            game.startGame(game.getPlayer1(), game.getPlayer2());

            System.out.println("Player 1 Statistics:");
            System.out.println("Wins: " + game.getPlayer1().getWins());
            System.out.println("Losses: " + game.getPlayer2().getWins()); // Player 2's wins are Player 1's losses
            System.out.println("Draws: " + game.getPlayer1().getDraws());
            System.out.println();
            System.out.println("Player 2 Statistics:");
            System.out.println("Wins: " + game.getPlayer2().getWins());
            System.out.println("Losses: " + game.getPlayer1().getWins()); // Player 1's wins are Player 2's losses
            System.out.println("Draws: " + game.getPlayer2().getDraws());

            System.out.println("Play another game? (y/n): ");
            playAgain = scanner.next().charAt(0);
            playAgain = Character.toLowerCase(playAgain); // Ensure case-insensitive input
        } while (playAgain == 'y');

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}