package draughts.models;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {

    private Game game;

    public GameTest() {
        game = new GameBuilder()
            .row(" n      ")
            .row("        ")
            .row("        ")
            .row(" b   n  ")
            .row("   n    ")
            .row("  b   b ")
            .row(" b      ")
            .row("        ")
            .build();
    }

    @Test
    public void testGivenGameBuilderWhenGetPieceThenIsOK(){
        assertEquals(Color.BLACK, game.getColor(new Coordinate(0,1)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(3,5)));
        assertEquals(Color.WHITE, game.getColor(new Coordinate(5,6)));
        assertEquals(Color.WHITE, game.getColor(new Coordinate(6,1)));
        assertEquals(null, game.getColor(new Coordinate(0,0)));
        Coordinate origin = new Coordinate(3,1);
        Coordinate target = new Coordinate(2,0);
        this.game.move(origin, target);
        assertEquals(null, game.getColor(origin));
        assertEquals(Color.WHITE, game.getColor(target));
    }

    @Test
    public void testGivenNewBoardThenGoodLocations() {
        this.game.initGame();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < game.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = game.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.BLACK, color);
                } else {
                    assertNull(color);
                }
            }
        }
        for (int i = 5; i < game.getDimension(); i++) {
            for (int j = 0; j < game.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = game.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.WHITE, color);
                } else {
                    assertNull(color);
                }
            }
        }
    }

    @Test
    public void testGivenGameWhenMoveEmptySquareThenEmptySquareError() {
        assertEquals(Error.EMPTY_ORIGIN, game.isCorrect(new Coordinate(7,2), new Coordinate(6,3)));
    }

    @Test
    public void testGivenGameWhenMoveOppositePieceThenError() {
        assertEquals(Error.OPPOSITE_PIECE, game.isCorrect(new Coordinate(3,5), new Coordinate(2,4)));
    }

    @Test
    public void testGivenGameWhenNotDiagonalMovementThenError() {
        assertEquals(Error.NOT_DIAGONAL, game.isCorrect(new Coordinate(6,1), new Coordinate(6,2)));
    }

    @Test
    public void testGivenGameWhenMoveWithNotAdvancedThenError() {
        assertEquals(Error.NOT_ADVANCED, game.isCorrect(new Coordinate(5,6), new Coordinate(6,5)));
    }

    @Test
    public void testGivenGameWhenNotEmptyTargeThenError() {
        assertEquals(Error.NOT_EMPTY_TARGET,game.isCorrect(new Coordinate(6,1), new Coordinate(5,2)));
    }

    @Test
    public void testGivenGameWhenCorrectMovementThenOk() {
        Coordinate originWhite = new Coordinate(5, 2);
        Coordinate targetWhite = new Coordinate(4, 1);
        this.game.move(originWhite, targetWhite);
        game.nextTurn();
        assertNull(this.game.getColor(originWhite));
        assertEquals(Color.WHITE, this.game.getColor(targetWhite));
        Coordinate originBlack = new Coordinate(0, 1);
        Coordinate targetBlack = new Coordinate(1, 2);
        this.game.move(originBlack, targetBlack);
        assertNull(this.game.getColor(originBlack));
        assertEquals(Color.BLACK, this.game.getColor(targetBlack));
    }

    @Test
    public void testGivenGameWhenMovementThenEatPiece() {
        assertEquals(Color.BLACK, game.getColor(new Coordinate(4, 3)));
        assertNull(game.move(new Coordinate(5,2), new Coordinate(3,4)));
        assertNull(game.getColor(new Coordinate(5, 2)));
        assertNull(game.getColor(new Coordinate(4, 3)));
        assertEquals(Color.WHITE, game.getColor(new Coordinate(3, 4)));
    }

    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        assertEquals(Error.EATING_EMPTY, game.isCorrect(new Coordinate(3,1), new Coordinate(1,3)));
    }

    @Test
    public void testGivenGameWhenMoveBadDistanceThenError() {
        assertEquals(Error.BAD_DISTANCE, game.isCorrect(new Coordinate(3,1), new Coordinate(0,4)));
    }


    @Test
    public void testGivenGameWhenBlockedBecauseNoMorePiecesThenGameOver() {
        Game game = new GameBuilder()
            .row("        ")
            .row("        ")
            .row("        ")
            .row(" b      ")
            .row("        ")
            .row("  b   b ")
            .row(" b      ")
            .row("        ")
            .build();
        Coordinate originWhite = new Coordinate(5, 2);
        Coordinate targetWhite = new Coordinate(4, 1);
        game.move(originWhite, targetWhite);
        game.nextTurn();
        assertTrue(game.isBlocked());
    }

    @Test
    public void testGivenGameWhenBlockedBecauseNoMoreMovablePiecesThenGameOver() {
        Game game = new GameBuilder()
            .row("       n")
            .row("      b ")
            .row("        ")
            .row("    b   ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .build();
        Coordinate originWhite = new Coordinate(3, 4);
        Coordinate targetWhite = new Coordinate(2, 5);
        game.move(originWhite, targetWhite);
        game.nextTurn();
        assertTrue(game.isBlocked());
    }

}