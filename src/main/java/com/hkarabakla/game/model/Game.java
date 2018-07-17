package com.hkarabakla.game.model;

import java.util.Random;

public class Game {

    private Player[] players;
    private Board board;
    private int nextPlayerIndex;

    private Game() {
    }

    private Game(GameBuilder builder) {
        this.players = builder.players;
        this.board = builder.board;
        this.nextPlayerIndex = new Random().nextInt(this.players.length);
    }

    public Player getNextPlayer() {
        Player player = this.players[nextPlayerIndex];
        nextPlayerIndex = (nextPlayerIndex + 1) % 3;
        return player;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public static class GameBuilder {
        private Player[] players;
        private Board board;

        private GameBuilder() {
        }

        public static GameBuilder builder() {
            return new GameBuilder();
        }

        public GameBuilder players(Player[] players) {
            this.players = players;
            return this;
        }

        public GameBuilder board(Board board) {
            this.board = board;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
