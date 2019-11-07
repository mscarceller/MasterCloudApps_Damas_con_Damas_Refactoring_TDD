package draughts.models;

public class Piece {

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
		if (origin.isDiagonal(target)) 
			return true;
		return false;
	}

	public boolean isAdvancedMovement(Coordinate origin,Coordinate target){
		if (this.isAdvanced(origin, target))
			return true;
		return false;
	}

	public boolean isBadDistanceMovement(Coordinate origin,Coordinate target){
		if (origin.diagonalDistance(target) >= 3)
			return true;
		return false;
	}

	public boolean isEatingMovement(Coordinate origin, Coordinate target){
		if (origin.diagonalDistance(target) == 2)
			return true;
		return false;
	}

	public Coordinate getEatedPieceCoordinate(Coordinate origin, Coordinate target){
		return origin.betweenDiagonal(target);
	}

}