package draughts.models;

class Pawn extends Piece {

    private static final int MAX_DISTANCE = 2;

    Pawn(Color color) {
        super(color);
    }

    public boolean isAdvanced(Coordinate origin, Coordinate target) {
		int difference = origin.getRow() - target.getRow();
		if (this.color == Color.WHITE){
			return difference>0;
		}
		return difference<0;
    }

    @Override
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
		if (distance > Pawn.MAX_DISTANCE) {
			return Error.BAD_DISTANCE;
		}
		if (distance == Pawn.MAX_DISTANCE) {
			if (pieceProvider.getPiece(origin.eatedDiagonal(target)) == null) {
				return Error.EATING_EMPTY;
			}
		}
		return null;
    }
    
    @Override
    public boolean isEatingMovement(Coordinate origin, Coordinate target){
        return origin.diagonalDistance(target) == 2;
    }

    @Override
	public Coordinate getEatedPieceCoordinate(Coordinate origin, Coordinate target){
		return origin.eatedDiagonal(target);
	}

    @Override
	public String getPieceSymbol(){
		return letters[this.getColor().ordinal()];
	}
    



}