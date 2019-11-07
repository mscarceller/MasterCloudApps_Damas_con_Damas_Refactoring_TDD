package draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import draughts.models.Session;
import draughts.models.StateValue;

public class StartControllerTest {

     @Test
    public void givenStartControllerWhenStartGameThenChangeState() {
        Session session = new Session();
        StartController startController = new StartController(session);
        assertEquals(StateValue.INITIAL, session.state.getValueState());
        startController.start();
        assertEquals(StateValue.IN_GAME, session.state.getValueState());
    }

}