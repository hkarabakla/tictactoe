package com.hkarabakla.game.command;

import com.hkarabakla.game.model.Game;

public class EndOfGameCheckerCommand extends Command {

    @Override
    void execute(Game game) {

        if (game.getBoard().getEmptySlots().isEmpty()) {
            System.out.println("End of the game, No winner :(");
            System.exit(-1);
        }

        action(game, false);
    }
}
