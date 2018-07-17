package com.hkarabakla.game.command;

import com.hkarabakla.game.model.Game;
import com.hkarabakla.game.model.Player;
import com.hkarabakla.game.model.Slot;

public class PlayerActionCommand extends Command {

    @Override
    void execute(Game game) {

        Player nextPlayer = game.getNextPlayer();
        Slot slot;

        while (true) {
            System.out.println(nextPlayer.getName() + " 's turn (" + nextPlayer.getCharacter() + ")");
            slot = nextPlayer.getInputCollector().getInput(game.getBoard());

            if (slot == null) {
                System.out.println("Invalid input ! This slot is not empty, please an empty one !");
            } else {
                slot.setValue(nextPlayer.getCharacter());
                break;
            }
        }

        game.getBoard().setLastPlayer(nextPlayer);
        game.getBoard().setLastPlayHorizontal(slot.getHorizontal());
        game.getBoard().setLastPlayVertical(slot.getVertical());
        game.getBoard().getEmptySlots().remove(slot);

        game.getBoard().getPrinter().printBoard(game.getBoard());

        action(game, false);
    }
}
