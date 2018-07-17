package com.hkarabakla.game.input;

import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Slot;
import com.hkarabakla.game.output.ConsoleOutputPrinter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RandomInputCollectorTest {

    private InputCollector underTest;

    @Before
    public void setUp() {
        this.underTest = new RandomInputCollector();
    }

    @Test
    public void getInput() {
        // given
        Slot[][] slots = new Slot[3][3];
        slots[0][0] = Slot.SlotBuilder.builder().horizontal(0).vertical(0).value('O').build();
        slots[0][1] = Slot.SlotBuilder.builder().horizontal(0).vertical(1).value('O').build();
        slots[0][2] = Slot.SlotBuilder.builder().horizontal(0).vertical(2).build();
        slots[1][0] = Slot.SlotBuilder.builder().horizontal(1).vertical(0).value('X').build();
        slots[1][1] = Slot.SlotBuilder.builder().horizontal(1).vertical(1).value('+').build();
        slots[1][2] = Slot.SlotBuilder.builder().horizontal(1).vertical(2).value('+').build();
        slots[2][0] = Slot.SlotBuilder.builder().horizontal(2).vertical(0).value('X').build();
        slots[2][1] = Slot.SlotBuilder.builder().horizontal(2).vertical(1).value('X').build();
        slots[2][2] = Slot.SlotBuilder.builder().horizontal(2).vertical(2).value('+').build();

        List<Slot> emptySlots = new ArrayList<>();
        emptySlots.add(slots[0][2]);

        Board boardMock = Board.BoardBuilder.builder()
                .size(3)
                .slots(slots)
                .emptySlots(emptySlots)
                .printer(new ConsoleOutputPrinter())
                .build();

        // when
        Slot slot = underTest.getInput(boardMock);

        // then
        assertEquals(0, slot.getHorizontal());
        assertEquals(2, slot.getVertical());
    }

    @Test
    public void getInputInCaseOfNoEmptySlot() {
        // given
        Slot[][] slots = new Slot[3][3];
        slots[0][0] = Slot.SlotBuilder.builder().horizontal(0).vertical(0).value('O').build();
        slots[0][1] = Slot.SlotBuilder.builder().horizontal(0).vertical(1).value('O').build();
        slots[0][2] = Slot.SlotBuilder.builder().horizontal(0).vertical(2).value('X').build();
        slots[1][0] = Slot.SlotBuilder.builder().horizontal(1).vertical(0).value('X').build();
        slots[1][1] = Slot.SlotBuilder.builder().horizontal(1).vertical(1).value('+').build();
        slots[1][2] = Slot.SlotBuilder.builder().horizontal(1).vertical(2).value('+').build();
        slots[2][0] = Slot.SlotBuilder.builder().horizontal(2).vertical(0).value('X').build();
        slots[2][1] = Slot.SlotBuilder.builder().horizontal(2).vertical(1).value('X').build();
        slots[2][2] = Slot.SlotBuilder.builder().horizontal(2).vertical(2).value('+').build();

        List<Slot> emptySlots = new ArrayList<>();

        Board boardMock = Board.BoardBuilder.builder()
                .size(3)
                .slots(slots)
                .emptySlots(emptySlots)
                .printer(new ConsoleOutputPrinter())
                .build();

        // when
        Slot slot = underTest.getInput(boardMock);

        // then
        assertNull(slot);
    }
}
