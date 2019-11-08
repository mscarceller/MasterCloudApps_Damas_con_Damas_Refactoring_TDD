package draughts.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import draughts.controllers.PlayController;
import draughts.models.Game;
import draughts.models.State;
import draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class BoardViewTest {

    @Mock
    Console console;

    @InjectMocks
    BoardView boardView;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Captor
    ArgumentCaptor<String> argument;
    
    @Test
    public void testInteract(){
		State state = new State();
        Game game = new Game(); 
        PlayController playController = new PlayController(game, state);
        this.boardView.writeBoard(playController.getBoard());
        verify(console, times(90)).write(argument.capture());
        List<String> rows = Arrays.asList(
        " 12345678",
        "1 n n n n",
        "2n n n n ",
        "3 n n n n",
        "4        ",
        "5        ",
        "6b b b b ",
        "7 b b b b",
        "8b b b b ",
        " 12345678");
        assertEquals(marshall(rows), marshall(argument.getAllValues()));
    }

    private static String marshall(List<String> strings){
        String string = "";
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            string += iterator.next();
        }
        return string;
    }

}