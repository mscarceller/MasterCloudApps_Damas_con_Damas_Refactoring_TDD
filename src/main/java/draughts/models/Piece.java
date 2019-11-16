package draughts.models;

public abstract class Piece {

	final String[] letters = {"b","n"};
	Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	abstract Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider);

    public abstract boolean isEatingMovement(Coordinate origin, Coordinate target);

	public abstract Coordinate getEatedPieceCoordinate(Coordinate origin, Coordinate target);

	public abstract String getPieceSymbol();
	

}
