package draughts.models;

import java.util.ArrayList;
import java.util.List;

public class Board implements PieceProvider {

    private static final int DIMENSION = 8;

    private Square[][] squares;

    public Board() {
        this.setInitialSquares();
    }

    void setInitialSquares(){
        this.squares = new Square[this.getDimension()][this.getDimension()];
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

	void setInitialPieces(){
		for (int i = 0; i < this.getDimension(); i++) {
			for (int j = 0; j < this.getDimension(); j++) {
				Coordinate coordinate = new Coordinate(i, j);
				Pawn piece = this.getInitialPiece(coordinate);
				if (piece != null) {
					this.putPiece(coordinate, piece);
				}
			}
		}
	}

	private Pawn getInitialPiece(Coordinate coordinate) {
		if (coordinate.isBlack()) {
			final int row = coordinate.getRow();
			Color color = null;
			if (row <= 2) {
				color = Color.BLACK;
			} else if (row >= 5) {
				color = Color.WHITE;
			}
			if (color != null) {
				return new Pawn(color);
			}
		}
		return null;
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

    @Override
    public Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    @Override
    public boolean isEmpty(Coordinate coordinate) {
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

    private Piece checkPieceColor(Color color, Square square){
        Piece piece = square.getPiece();
        if (piece != null && piece.getColor()==color)
            return piece;
        return null;
    }

}
