package draughts.models;

class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }

    @Override
    Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
        }
        if (!pieceProvider.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
        }
        return null;
    }
    
    @Override
    public boolean isEatingMovement(Coordinate origin, Coordinate target){
        return origin.diagonalDistance(target) > 1;
    }

    @Override
	public Coordinate getEatedPieceCoordinate(Coordinate origin, Coordinate target){
		return origin.lastBetweenDiagonal(target);
	}

    @Override
	public String getPieceSymbol(){
		return letters[this.getColor().ordinal()].toUpperCase();
	}

}