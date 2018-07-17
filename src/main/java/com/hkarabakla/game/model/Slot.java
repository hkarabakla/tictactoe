package com.hkarabakla.game.model;

public class Slot {

    private int horizontal;
    private int vertical;
    private Character value;

    private Slot() {
    }

    private Slot(SlotBuilder builder) {
        this.horizontal = builder.horizontal;
        this.vertical = builder.vertical;
        this.value = builder.value;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public static class SlotBuilder {
        private int horizontal;
        private int vertical;
        private Character value;

        private SlotBuilder() {
        }

        public static SlotBuilder builder() {
            return new SlotBuilder();
        }

        public SlotBuilder horizontal(int horizontal) {
            this.horizontal = horizontal;
            return this;
        }

        public SlotBuilder vertical(int vertical) {
            this.vertical = vertical;
            return this;
        }

        public SlotBuilder value(Character value) {
            this.value = value;
            return this;
        }

        public Slot build() {
            return new Slot(this);
        }
    }
}
