package draughts.models;

public class Piece {

	final String[] letters = {"b","n"};
	private Color color;

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

	public boolean isDiagonalMovement(Coordinate origin,Coordinate target){
        return origin.isDiagonal(target);
    }

	public boolean isAdvancedMovement(Coordinate origin,Coordinate target){
        return this.isAdvanced(origin, target);
    }

	public boolean isBadDistanceMovement(Coordinate origin,Coordinate target){
        return (origin.diagonalDistance(target) >= 3);
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
