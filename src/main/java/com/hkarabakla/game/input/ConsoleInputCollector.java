package com.hkarabakla.game.input;

import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Slot;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleInputCollector implements InputCollector {

    private String coordinateSeparator = ",";
    private String coordinatePattern = "[0-9]+[,][0-9]+";

    @Override
    public Slot getInput(Board board) {

        Scanner in = new Scanner(System.in);
        Optional<Slot> optionalSlot;
        String s;

        while (true) {

            System.out.println("Enter coordinate : ");
            s = in.nextLine();

            if (!s.matches(coordinatePattern)) {
                System.out.println(" !!! Bad Format !!! Try again please");
                continue;
            }

            int horizontal = Integer.parseInt(s.split(coordinateSeparator)[0]);
            int vertical = Integer.parseInt(s.split(coordinateSeparator)[1]);

            if (horizontal < 1 || horizontal > board.getSize() || vertical < 1 || vertical > board.getSize()) {
                System.out.println(" !!! Bad Number !!! Try again please");
                continue;
            }

            optionalSlot = board.getEmptySlots()
                    .stream()
                    .filter(value -> value.getVertical() == vertical - 1 && value.getHorizontal() == horizontal - 1)
                    .findFirst();

            break;
        }

        return optionalSlot.orElse(null);
    }
}
