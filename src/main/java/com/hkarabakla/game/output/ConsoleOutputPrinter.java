package com.hkarabakla.game.output;

import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Slot;

import java.util.stream.IntStream;

public class ConsoleOutputPrinter implements OutputPrinter {

    @Override
    public void printBoard(Board board) {

        // To decrease io operations and to increase performance
        // I decided to collect each line in a stringBuilder and
        // print each line with all contents at one shot
        StringBuilder builder = new StringBuilder();

        System.out.println();

        IntStream.range(0, (board.getSize() + 1) * 2).forEachOrdered(row -> {

            IntStream.range(0, board.getSize() + 1).forEachOrdered(col -> {

                if(row == 0) {
                    // Print col numbers
                    if (col == 0) {
                        builder.append("    ");
                    } else {
                        builder.append("| ").append(col).append(" ");
                    }

                    if (col == board.getSize()) {
                        builder.append("|\n");
                    }
                } else if(row % 2 > 0) {
                    // Print separator lines
                    if (col == 0) {
                        builder.append("----");
                    } else {
                        builder.append("+---");
                    }

                    if (col == board.getSize()) {
                        builder.append("+\n");
                    }
                } else {
                    // Print values
                    if (col == 0) {
                        builder.append(" ").append(row / 2).append(row / 2 < 10 ? "  " : " ");
                    } else {
                        Slot slot = board.getSlots()[(row - 2) / 2][col - 1];
                        builder.append("| ").append(slot != null && slot.getValue() != null ? slot.getValue() : " ").append(" ");
                    }

                    if (col == board.getSize()) {
                        builder.append("|\n");
                    }
                }
            });
        });

        System.out.println(builder.toString());
    }
}
