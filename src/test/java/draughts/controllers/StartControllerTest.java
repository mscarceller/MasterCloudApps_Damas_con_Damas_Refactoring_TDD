package draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;

public class StartControllerTest {

     @Test
    public void givenStartControllerWhenStartGameThenChangeState() {
		State state = new State();
        Game game = new Game(); 
        StartController startController = new StartController(game, state);
        assertEquals(StateValue.INITIAL, state.getValueState());
        startController.start();
        assertEquals(StateValue.IN_GAME, state.getValueState());
    }

}