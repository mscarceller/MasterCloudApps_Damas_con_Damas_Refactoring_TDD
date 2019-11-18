package draughts.models;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class GameWithMultipleJumps {

    private Game game;

    public GameWithMultipleJumps() {
        game = new GameBuilder()
            .row(" n      ")
            .row("  b  n  ")
            .row("        ")
            .row("  n b   ")
            .row("        ")
            .row("  n   b ")
            .row(" b   n  ")
            .row("        ")
            .build();
    }

    @Test
     public void testGivenGameWhenMultipleWhiteJumpsThenEatOK(){
        game.move(new Coordinate(6,1), new Coordinate(4,3));
        game.move(new Coordinate(4,3), new Coordinate(2,1));
        game.nextTurn();
        assertTrue(game.getPiece(new Coordinate(2,1)) instanceof Pawn);
        assertNull(game.getPiece(new Coordinate(5,2)));
        assertNull(game.getPiece(new Coordinate(3,2)));
    }

    @Test
    public void testGivenGameWhenMultipleBlackJumpsThenEatOK(){
       game.move(new Coordinate(5,6), new Coordinate(4,7));
       assertTrue(game.getPiece(new Coordinate(4,7)) instanceof Pawn);
       assertNull(game.getPiece(new Coordinate(5,6)));
       game.nextTurn();
       game.move(new Coordinate(0,1), new Coordinate(2,3));
       game.move(new Coordinate(2,3), new Coordinate(4,5));
       game.nextTurn();
       assertTrue(game.getPiece(new Coordinate(4,5)) instanceof Pawn);
       assertNull(game.getPiece(new Coordinate(1,3)));
       assertNull(game.getPiece(new Coordinate(3,4)));
   }


}