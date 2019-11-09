package draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;

public class CancelControllerTest {

    @Mock
    Game game;

    @Mock
    State state;

    @InjectMocks
    CancelController cancelController;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenCancelControllerWhenCancelGameThenStateIsFinalState() {
        when(state.getValueState()).thenReturn(StateValue.FINAL);
        cancelController.cancel(true);
        assertEquals(StateValue.FINAL,state.getValueState());
        verify(state).next();
    }
}