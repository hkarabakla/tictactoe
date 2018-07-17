package com.hkarabakla.game.command;

import com.hkarabakla.game.constants.SystemConstants;
import com.hkarabakla.game.input.ConsoleInputCollector;
import com.hkarabakla.game.input.RandomInputCollector;
import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Game;
import com.hkarabakla.game.model.Player;
import com.hkarabakla.game.model.Slot;
import com.hkarabakla.game.output.ConsoleOutputPrinter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConfigLoaderCommand extends Command {

    private String[] args;

    public ConfigLoaderCommand(String[] args) {
        this.args = args;
    }

    @Override
    void execute(Game game) {

        int size;

        try {

            if (args.length == 0) {
                throw new IllegalArgumentException("Please provide a file name to read configuration !");
            }

            List<String> lines = Files.lines(Paths.get(args[0])).collect(Collectors.toList());

            if (lines.size() != 4) {
                throw new IllegalArgumentException("Please provide a valid configuration file !");
            }

            if (!lines.get(0).matches("size=[0-9]+")) {
                throw new IllegalArgumentException("Please provide a valid configuration file !");
            }

            size = Integer.parseInt(lines.get(0).split("=")[1]);

            if (size < SystemConstants.MIN_BOARD_SIZE || size > SystemConstants.MAX_BOARD_SIZE) {
                throw new IllegalArgumentException("Please provide a valid board size !");
            }

            if (!lines.get(1).matches("[\\w]+=.")
                    || !lines.get(2).matches("[\\w]+=.")
                    || !lines.get(3).matches("[\\w]+=.")) {
                throw new IllegalArgumentException("Please provide a valid character configurations for players !");
            }

            char player1Char = lines.get(1).split("=")[1].toCharArray()[0];
            char player2Char = lines.get(2).split("=")[1].toCharArray()[0];
            char player3Char = lines.get(3).split("=")[1].toCharArray()[0];

            if (player1Char == player2Char || player1Char == player3Char || player2Char == player3Char) {
                throw new IllegalArgumentException("Please provide a unique characters for each player !");
            }

            Player p1 = Player.PlayerBuilder.builder()
                    .name(lines.get(1).split("=")[0])
                    .character(player1Char)
                    .input(new ConsoleInputCollector())
                    .build();

            Player p2 = Player.PlayerBuilder.builder()
                    .name(lines.get(2).split("=")[0])
                    .character(player2Char)
                    .input(new ConsoleInputCollector())
                    .build();

            Player p3 = Player.PlayerBuilder.builder()
                    .name(lines.get(3).split("=")[0])
                    .character(player3Char)
                    .input(new RandomInputCollector())
                    .build();

            Slot[][] slots = new Slot[size][size];
            List<Slot> emptySlots = new ArrayList<>(size);

            IntStream.range(0, size).forEachOrdered(horizontal -> {
                IntStream.range(0, size).forEachOrdered(vertical -> {
                    Slot slot = Slot.SlotBuilder.builder()
                            .horizontal(horizontal)
                            .vertical(vertical)
                            .build();
                    slots[horizontal][vertical] = slot;
                    emptySlots.add(slot);
                });
            });

            game = Game.GameBuilder.builder()
                    .board(Board.BoardBuilder.builder()
                            .printer(new ConsoleOutputPrinter())
                            .size(size)
                            .slots(slots)
                            .emptySlots(emptySlots)
                            .build())
                    .players(new Player[]{p1, p2, p3})
                    .build();

            game.getBoard().getPrinter().printBoard(game.getBoard());
            System.out.println("**** Tic Tac Toe Starts ****");

            action(game, false);
        } catch (Exception e) {
            System.out.println("Error occurred during loading config file !");
            System.out.println(e.getMessage());
        }
    }
}
