package draughts.models;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
        board = new Board();
    }

    @Test
    public void testGivenNewBoardThenIsEmpty() {
        assertTrue(board.getPieces(Color.WHITE).isEmpty());
        assertTrue(board.getPieces(Color.BLACK).isEmpty());
    }

    @Test
    public void testGivenNewBoardWhenPutPiecesThenIsNotEmpty() {
        Piece piece = new Pawn(Color.WHITE);
        Coordinate coordinate = new Coordinate(5,4);
        board.putPiece(coordinate, piece);
        assertFalse(board.getPieces(Color.WHITE).isEmpty());
    }

    @Test
    public void testGivenNewBoardWhenPutAndRemovePiecesThenIsOK() {
        Piece piece = new Pawn(Color.WHITE);
        Coordinate coordinate = new Coordinate(5,4);
        board.putPiece(coordinate, piece);
        assertFalse(board.getPieces(Color.WHITE).isEmpty());
        board.removePiece(coordinate);
        assertTrue(board.getPieces(Color.WHITE).isEmpty());
    }

}