package draughts.models;

public class Square {

    private Piece piece;

    Square() {
    }

    void put(Piece piece) {
        this.piece = piece;
    }

    Piece remove() {
        Piece piece = this.piece;
        this.piece = null;
        return piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

	public boolean isEmpty() {
		return this.piece == null;
	}

	public Color getColor() {
        if (piece == null){
            return null;
        }
		return this.piece.getColor();
    }
    
    public String getPieceSymbol() {
        if (piece == null){
            return " ";
        }
		return this.piece.getPieceSymbol();
	}

}