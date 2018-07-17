package com.hkarabakla.game.model;

import com.hkarabakla.game.input.InputCollector;

public class Player {

    private String name;
    private char character;
    private InputCollector inputCollector;

    public Player(PlayerBuilder builder) {
        this.name = builder.name;
        this.character = builder.character;
        this.inputCollector = builder.inputCollector;
    }

    public String getName() {
        return name;
    }

    public char getCharacter() {
        return character;
    }

    public InputCollector getInputCollector() {
        return inputCollector;
    }

    public static class PlayerBuilder {

        private String name;
        private char character;
        private InputCollector inputCollector;

        private PlayerBuilder() {
        }

        public static PlayerBuilder builder() {
            return new PlayerBuilder();
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder character(char character) {
            this.character = character;
            return this;
        }

        public PlayerBuilder input(InputCollector inputCollector) {
            this.inputCollector = inputCollector;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
