package com.hkarabakla.game.command;

import com.hkarabakla.game.model.Game;

public class CommandRunner {

    public void run(Game game, String[] args) {
        Command configLoaderCommand = new ConfigLoaderCommand(args);
        Command playCommand = new PlayerActionCommand();
        Command verticalCommand = new VerticalScoreCheckerCommand();
        Command horizontalCommand = new HorizontalScoreCheckerCommand();
        Command diagonalCommand = new DiagonalScoreCheckerCommand();
        Command endOfGameCommand = new EndOfGameCheckerCommand();

        configLoaderCommand.setNext(playCommand);
        playCommand.setNext(verticalCommand);
        verticalCommand.setNext(horizontalCommand);
        horizontalCommand.setNext(diagonalCommand);
        diagonalCommand.setNext(endOfGameCommand);
        endOfGameCommand.setNext(playCommand);

        configLoaderCommand.execute(game);
    }
}
