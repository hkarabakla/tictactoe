package com.hkarabakla.game.command;

import com.hkarabakla.game.model.Game;

class HorizontalScoreCheckerCommand extends Command {
    @Override
    void execute(Game game) {

        boolean score = true;

        for (int i = 0; i < game.getBoard().getSize(); i++) {
            Character c = game.getBoard().getSlots()[game.getBoard().getLastPlayHorizontal()][i].getValue();

            if (c == null || !c.equals(game.getBoard().getLastPlayer().getCharacter())) {
                score = false;
                break;
            }
        }

        action(game, score);
    }
}
