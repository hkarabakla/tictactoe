package com.hkarabakla.game.command;

import com.hkarabakla.game.model.Game;

abstract class Command {

    private Command next;

    void setNext(Command next) {
        this.next = next;
    }

    Command getNext() {
        return next;
    }

    abstract void execute(Game game);

    void action(Game game, boolean score) {
        if (score) {
            game.getBoard().getPrinter().printBoard(game.getBoard());
            System.out.println("***** WINNER *****");
            System.out.println("Congratulations " + game.getBoard().getLastPlayer().getName());
        } else if (getNext() != null) {
            getNext().execute(game);
        }
    }
}
