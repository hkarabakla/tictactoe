package com.hkarabakla.game.input;

import com.hkarabakla.game.model.Board;
import com.hkarabakla.game.model.Slot;

public interface InputCollector {

    Slot getInput(Board board);
}
