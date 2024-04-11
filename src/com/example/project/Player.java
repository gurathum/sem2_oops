package com.example.project;

public class Player {

    // Player class represents the instance of the player
    // Stores player's symbol and their wins, losses, and draws.
    private char symbol;
    private int wins;
    private int losses;
    private int draws;

    public Player() {
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void addWin() {
        wins++;
    }

    public void addLoss() {
        losses++;
    }

    public void addDraw() {
        draws++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }
}
