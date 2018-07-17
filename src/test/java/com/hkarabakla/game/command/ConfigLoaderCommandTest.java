package com.hkarabakla.game.command;

import com.hkarabakla.game.model.Game;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ConfigLoaderCommandTest {

    private Command underTest;

    @Test
    public void execute() {
        // given
        File resourcesDirectory = new File("src/test/resources/tictactoe.config.properties");
        this.underTest = new ConfigLoaderCommand(new String[]{resourcesDirectory.getPath()});
        Game game = null;

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.execute(game);

        // then
        assertTrue(bo.toString().contains("Tic Tac Toe Starts"));
    }

    @Test
    public void executeInCaseOfNoFilePathProvided() {
        // given
        this.underTest = new ConfigLoaderCommand(new String[]{});
        Game game = null;

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.execute(game);

        // then
        assertTrue(bo.toString().contains("Error"));
    }

    @Test
    public void executeInCaseOfMissingLine() {
        // given
        File resourcesDirectory = new File("src/test/resources/tictactoe.config.missing.line.properties");
        this.underTest = new ConfigLoaderCommand(new String[]{resourcesDirectory.getPath()});
        Game game = null;

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.execute(game);

        // then
        assertTrue(bo.toString().contains("Error"));
    }

    @Test
    public void executeInCaseOfInvalidSizeFormat() {
        // given
        File resourcesDirectory = new File("src/test/resources/tictactoe.config.invalid.size.format.properties");
        this.underTest = new ConfigLoaderCommand(new String[]{resourcesDirectory.getPath()});
        Game game = null;

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.execute(game);

        // then
        assertTrue(bo.toString().contains("Error"));
    }

    @Test
    public void executeInCaseOfInvalidSizeValue() {
        // given
        File resourcesDirectory = new File("src/test/resources/tictactoe.config.invalid.size.value.properties");
        this.underTest = new ConfigLoaderCommand(new String[]{resourcesDirectory.getPath()});
        Game game = null;

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.execute(game);

        // then
        assertTrue(bo.toString().contains("Error"));
    }

    @Test
    public void executeInCaseOfInvalidPlayerFormat() {
        // given
        File resourcesDirectory = new File("src/test/resources/tictactoe.config.invalid.player.format.properties");
        this.underTest = new ConfigLoaderCommand(new String[]{resourcesDirectory.getPath()});
        Game game = null;

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.execute(game);

        // then
        assertTrue(bo.toString().contains("Error"));
    }

    @Test
    public void executeInCaseOfNonUniquePlayerValues() {
        // given
        File resourcesDirectory = new File("src/test/resources/tictactoe.config.invalid.player.nonunique.value.properties");
        this.underTest = new ConfigLoaderCommand(new String[]{resourcesDirectory.getPath()});
        Game game = null;

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        // when
        underTest.execute(game);

        // then
        assertTrue(bo.toString().contains("Error"));
    }

}
