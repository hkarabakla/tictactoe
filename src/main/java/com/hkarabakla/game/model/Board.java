package com.hkarabakla.game.model;

import com.hkarabakla.game.output.OutputPrinter;

import java.util.List;

public class Board {

    private int size;
    private Slot[][] slots;
    private Player lastPlayer;
    private int lastPlayVertical;
    private int lastPlayHorizontal;
    private OutputPrinter printer;
    private List<Slot> emptySlots;

    private Board() {
    }

    private Board(BoardBuilder builder) {
        this.size = builder.size;
        this.slots = builder.slots;
        this.printer = builder.printer;
        this.emptySlots = builder.emptySlots;
    }

    public int getSize() {
        return size;
    }

    public Slot[][] getSlots() {
        return slots;
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(Player lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public void setLastPlayVertical(int lastPlayVertical) {
        this.lastPlayVertical = lastPlayVertical;
    }

    public void setLastPlayHorizontal(int lastPlayHorizontal) {
        this.lastPlayHorizontal = lastPlayHorizontal;
    }

    public int getLastPlayVertical() {
        return lastPlayVertical;
    }

    public int getLastPlayHorizontal() {
        return lastPlayHorizontal;
    }

    public OutputPrinter getPrinter() {
        return printer;
    }

    public List<Slot> getEmptySlots() {
        return emptySlots;
    }

    public static class BoardBuilder {
        private int size;
        private Slot[][] slots;
        private List<Slot> emptySlots;
        private OutputPrinter printer;

        private BoardBuilder() {
        }

        public static BoardBuilder builder() {
            return new BoardBuilder();
        }

        public BoardBuilder size(int size) {
            this.size = size;
            return this;
        }

        public BoardBuilder slots(Slot[][] slots) {
            this.slots = slots;
            return this;
        }

        public BoardBuilder printer(OutputPrinter printer) {
            this.printer = printer;
            return this;
        }

        public BoardBuilder emptySlots(List<Slot> emptySlots) {
            this.emptySlots = emptySlots;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}
