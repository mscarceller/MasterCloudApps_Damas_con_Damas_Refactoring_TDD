package draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.Piece;
import draughts.models.State;
import draughts.models.Color;

public class PlayControllerTest {

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
		State state = new State();
        Game game = new Game(); 
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

}