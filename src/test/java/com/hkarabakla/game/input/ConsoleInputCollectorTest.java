package com.hkarabakla.game.input;

import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Slot;
import com.hkarabakla.game.output.ConsoleOutputPrinter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsoleInputCollectorTest {

    private InputCollector underTest;

    @Before
    public void setUp() {
        this.underTest = new ConsoleInputCollector();
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
        slots[2][2] = Slot.SlotBuilder.builder().horizontal(2).vertical(2).build();

        List<Slot> emptySlots = new ArrayList<>();
        emptySlots.add(slots[0][2]);
        emptySlots.add(slots[2][2]);

        Board boardMock = Board.BoardBuilder.builder()
                .size(3)
                .slots(slots)
                .emptySlots(emptySlots)
                .printer(new ConsoleOutputPrinter())
                .build();

        String input = "1,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        Slot slot = underTest.getInput(boardMock);

        // then
        assertEquals(0, slot.getHorizontal());
        assertEquals(2, slot.getVertical());
    }

    @Test
    public void getInputMoreTimesInCaseOfInvalidInputFormat() {
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
        slots[2][2] = Slot.SlotBuilder.builder().horizontal(2).vertical(2).build();

        List<Slot> emptySlots = new ArrayList<>();
        emptySlots.add(slots[0][2]);
        emptySlots.add(slots[2][2]);

        Board boardMock = Board.BoardBuilder.builder()
                .size(3)
                .slots(slots)
                .emptySlots(emptySlots)
                .printer(new ConsoleOutputPrinter())
                .build();

        String input = "3.3\n3,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        Slot slot = underTest.getInput(boardMock);

        // then
        assertEquals(2, slot.getHorizontal());
        assertEquals(2, slot.getVertical());
    }

    @Test
    public void getInputMoreTimesInCaseOfOutOfRangeCoordinate() {
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
        slots[2][2] = Slot.SlotBuilder.builder().horizontal(2).vertical(2).build();

        List<Slot> emptySlots = new ArrayList<>();
        emptySlots.add(slots[0][2]);
        emptySlots.add(slots[2][2]);

        Board boardMock = Board.BoardBuilder.builder()
                .size(3)
                .slots(slots)
                .emptySlots(emptySlots)
                .printer(new ConsoleOutputPrinter())
                .build();

        String input = "0,3\n1,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        Slot slot = underTest.getInput(boardMock);

        // then
        assertEquals(0, slot.getHorizontal());
        assertEquals(2, slot.getVertical());
    }
}
