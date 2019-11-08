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

import draughts.controllers.PlayController;
import draughts.models.Board;
import draughts.models.Color;
import draughts.models.Coordinate;
import draughts.utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class PlayViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @Mock
    BoardView boardView;

    @InjectMocks
    PlayView playView;

    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        Board board = new Board();
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(playController.getBoard()).thenReturn(board);
    }

    
    @Test
    public void testInteract(){
        when(console.readString("Mueven las negras: ")).thenReturn("32.41");
        playView.interact(playController);
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

    @Test()
    public void testGivenPlayViewWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        when(console.readString("Mueven las negras: ")).thenReturn("01.09").thenReturn("32.41");
        playView.interact(playController);
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

    @Test()
    public void testGivenPlayViewWhenMoveWithbadStringCoordinateError() {
        when(console.readString("Mueven las negras: ")).thenReturn("ertg").thenReturn("32.41");
        playView.interact(playController);
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }

}