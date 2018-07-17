package com.hkarabakla.game.output;

import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Slot;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotNull;

public class ConsoleOutputPrinterTest {

    private OutputPrinter underTest;

    @Before
    public void setUp() {
        this.underTest = new ConsoleOutputPrinter();
    }

    @Test
    public void printBoard() {

//                    | 1 | 2 | 3 |
//                ----+---+---+---|
//                 1  | O | O | O |
//                ----+---+---+---|
//                 2  | X | + | + |
//                ----+---+---+---|
//                 3  |   | X |   |
//                ----+---+---+---+

        // given
        Slot[][] slots = new Slot[3][3];
        slots[0][0] = Slot.SlotBuilder.builder().horizontal(1).vertical(1).value('O').build();
        slots[0][1] = Slot.SlotBuilder.builder().horizontal(1).vertical(2).value('O').build();
        slots[0][2] = Slot.SlotBuilder.builder().horizontal(1).vertical(3).value('O').build();
        slots[1][0] = Slot.SlotBuilder.builder().horizontal(2).vertical(1).value('X').build();
        slots[1][1] = Slot.SlotBuilder.builder().horizontal(2).vertical(2).value('+').build();
        slots[1][2] = Slot.SlotBuilder.builder().horizontal(2).vertical(3).value('+').build();
        slots[2][1] = Slot.SlotBuilder.builder().horizontal(3).vertical(2).value('X').build();

        Board boardMock = Board.BoardBuilder.builder()
                .size(3)
                .slots(slots)
                .build();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.printBoard(boardMock);

        // then
        assertNotNull(bo.toString());
    }
}
