package draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.CancelController;
import draughts.models.Game;
import draughts.models.State;
import draughts.utils.YesNoDialog;

@RunWith(MockitoJUnitRunner.class)
public class CancelViewTest {

    @Mock
    State state;

    @Mock
    Game game;

    @Mock
    CancelController cancelController;

    @Mock
    YesNoDialog yesNoDialog;

    @InjectMocks
    CancelView cancelView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGivenCancelViewWhenUserWantsGiveUpThenNextState(){
        when(yesNoDialog.read("¿Quieres rendirte")).thenReturn(true);
        cancelView.confirmCancel(cancelController);
        verify(cancelController).cancel(true);
    }

}