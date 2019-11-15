package draughts.models;

public class Piece {

	final String[] letters = {"b","n"};
	private Color color;

	private static final int MAX_DISTANCE = 2;


	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isAdvanced(Coordinate origin, Coordinate target) {
		int difference = origin.getRow() - target.getRow();
		if (color == Color.WHITE){
			return difference>0;
		}
		return difference<0;
	}

	Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (!pieceProvider.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (!this.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		int distance = origin.diagonalDistance(target);
		if (distance > Piece.MAX_DISTANCE) {
			return Error.BAD_DISTANCE;
		}
		if (distance == Piece.MAX_DISTANCE) {
			if (pieceProvider.getPiece(origin.betweenDiagonal(target)) == null) {
				return Error.EATING_EMPTY;
			}
		}
		return null;
	}

	public boolean isEatingMovement(Coordinate origin, Coordinate target){
        return origin.diagonalDistance(target) == 2;
    }

	public Coordinate getEatedPieceCoordinate(Coordinate origin, Coordinate target){
		return origin.betweenDiagonal(target);
	}

	public String getPieceSymbol(){
		return letters[this.getColor().ordinal()];
	}

}
