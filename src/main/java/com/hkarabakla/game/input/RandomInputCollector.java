package com.hkarabakla.game.input;

import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Slot;

import java.util.Random;

public class RandomInputCollector implements InputCollector {

    @Override
    public Slot getInput(Board board) {

        Slot slot = null;

        if (!board.getEmptySlots().isEmpty()) {
            int randomSlotIndex = new Random().nextInt(board.getEmptySlots().size());
            slot = board.getEmptySlots().get(randomSlotIndex);
            System.out.println((slot.getHorizontal() + 1) + "," + (slot.getVertical() + 1));
        }

        return slot;
    }
}
