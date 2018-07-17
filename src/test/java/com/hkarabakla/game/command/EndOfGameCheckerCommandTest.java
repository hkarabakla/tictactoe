package com.hkarabakla.game.command;

import com.hkarabakla.game.input.ConsoleInputCollector;
import com.hkarabakla.game.input.RandomInputCollector;
import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Game;
import com.hkarabakla.game.model.Player;
import com.hkarabakla.game.model.Slot;
import com.hkarabakla.game.output.ConsoleOutputPrinter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class EndOfGameCheckerCommandTest {

    private Command underTest;

    @Before
    public void setUp() {
        this.underTest = new EndOfGameCheckerCommand();
    }

    @Test
    public void execute() {
//                    | 1 | 2 | 3 |
//                ----+---+---+---|
//                 1  | O | + | O |
//                ----+---+---+---|
//                 2  | O | + | + |
//                ----+---+---+---|
//                 3  | O | X |   |
//                ----+---+---+---+

        // given
        Slot[][] slots = new Slot[3][3];
        slots[0][0] = Slot.SlotBuilder.builder().horizontal(0).vertical(0).value('O').build();
        slots[0][1] = Slot.SlotBuilder.builder().horizontal(0).vertical(1).value('+').build();
        slots[0][2] = Slot.SlotBuilder.builder().horizontal(0).vertical(2).value('+').build();
        slots[1][0] = Slot.SlotBuilder.builder().horizontal(1).vertical(0).value('O').build();
        slots[1][1] = Slot.SlotBuilder.builder().horizontal(1).vertical(1).value('+').build();
        slots[1][2] = Slot.SlotBuilder.builder().horizontal(1).vertical(2).value('+').build();
        slots[2][0] = Slot.SlotBuilder.builder().horizontal(2).vertical(0).value('O').build();
        slots[2][1] = Slot.SlotBuilder.builder().horizontal(2).vertical(1).value('X').build();
        slots[2][2] = Slot.SlotBuilder.builder().horizontal(2).vertical(2).value('X').build();

        Board boardMock = Board.BoardBuilder.builder()
                .size(3)
                .slots(slots)
                .emptySlots(new ArrayList<>())
                .printer(new ConsoleOutputPrinter())
                .build();

        Player player1 = Player.PlayerBuilder.builder()
                .name("player1")
                .character('O')
                .input(new ConsoleInputCollector())
                .build();

        Player player2 = Player.PlayerBuilder.builder()
                .name("player2")
                .character('X')
                .input(new ConsoleInputCollector())
                .build();

        Player computer = Player.PlayerBuilder.builder()
                .name("computer")
                .character('+')
                .input(new RandomInputCollector())
                .build();

        Game game = Game.GameBuilder.builder()
                .board(boardMock)
                .players(new Player[]{player1, player2, computer})
                .build();

        boardMock.setLastPlayer(player1);
        boardMock.setLastPlayHorizontal(2);
        boardMock.setLastPlayVertical(0);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        //underTest.execute(game);

        // then

    }
}
