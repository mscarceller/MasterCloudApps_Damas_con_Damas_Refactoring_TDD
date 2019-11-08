package draughts.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int DIMENSION = 8;

    private Square[][] squares;

    public Board() {
        this.squares = new Square[this.getDimension()][this.getDimension()];
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

    public Square getSquare(Coordinate coordinate){
        assert coordinate!=null && coordinate.isValid();
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    void putPiece(Coordinate coordinate, Piece piece){
        assert piece != null;
        this.getSquare(coordinate).put(piece);
    }

    Piece removePiece(Coordinate coordinate) {
        assert this.getPiece(coordinate) != null;
        return this.getSquare(coordinate).remove();
    }

    void movePiece(Coordinate origin, Coordinate target) {
        this.putPiece(target, this.removePiece(origin));
    }

    Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }
    
    Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    public int getDimension() {
		return Board.DIMENSION;
	}

    List<Piece> getPieces(Color color) {
        List<Piece> pieces = new ArrayList<Piece>();
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                Piece piece = checkPieceColor(color, this.squares[i][j]);
                if (piece!=null) 
                    pieces.add(piece);
            }
        }
		return pieces;
    }
    
    Piece checkPieceColor(Color color, Square square){
        Piece piece = square.getPiece();
        if (piece != null && piece.getColor()==color)
            return piece;
        return null;
    }
    
}