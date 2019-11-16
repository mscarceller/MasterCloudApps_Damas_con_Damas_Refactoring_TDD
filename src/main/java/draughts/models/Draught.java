package draughts.models;

class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }

    @Override
    Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
		return null;
    }
    
    @Override
    public boolean isEatingMovement(Coordinate origin, Coordinate target){
        return false;
    }

    @Override
	public Coordinate getEatedPieceCoordinate(Coordinate origin, Coordinate target){
		return null;
	}

    @Override
	public String getPieceSymbol(){
		return null;
	}

}