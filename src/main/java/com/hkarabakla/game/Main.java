package com.hkarabakla.game;

import com.hkarabakla.game.command.CommandRunner;
import com.hkarabakla.game.model.Game;

public class Main {

    public static void main(String[] args) {
        CommandRunner commandRunner = new CommandRunner();
        commandRunner.run(Game.GameBuilder.builder().build(), args);
    }
}
