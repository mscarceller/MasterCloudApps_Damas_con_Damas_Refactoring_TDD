package draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;

public class ResumeControllerTest {

    @Test
    public void givenResumeControllerWhenResumeGameMoveToInitialStateRequiereCorrectThenNotError() {
		State state = new State();
        Game game = new Game(); 
        ResumeController resumeController = new ResumeController(game, state);
        assertEquals(StateValue.INITIAL, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, state.getValueState());
        resumeController.reset();
        assertEquals(StateValue.INITIAL, state.getValueState());
    }

    @Test(expected = AssertionError.class)
    public void givenResumeControllerWhenResumeGameMoveOutThenError() {
		State state = new State();
        Game game = new Game(); 
        ResumeController resumeController = new ResumeController(game, state);
        assertEquals(StateValue.INITIAL, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.IN_GAME, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.FINAL, state.getValueState());
        resumeController.next();
        assertEquals(StateValue.EXIT, state.getValueState());
        resumeController.next();
    }
}