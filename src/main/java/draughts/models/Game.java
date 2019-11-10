package draughts.models;

public class Game {

	private Board board;

	private Turn turn;

	public Game() {
		this.board = new Board();
		this.turn = new Turn();
		this.initGame();	
	}

	public void initGame(){
		this.board.setInitialSquares();
		 this.board.setInitialPieces();
		 this.turn.setInitialTurn();
	}

	public Error move(Coordinate origin, Coordinate target) {
		if (board.isEmpty(origin)) {
			return Error.EMPTY_ORIGIN;
		}
		Piece piece = this.board.getPiece(origin);
		if (this.turn.getColor() != piece.getColor()) {
			return Error.OPPOSITE_PIECE;
		}
		if (!piece.isDiagonalMovement(origin,target)){
			return Error.NOT_DIAGONAL;
		}
		if (!piece.isAdvancedMovement(origin,target)){
			return Error.NOT_ADVANCED;
		}
		if (piece.isBadDistanceMovement(origin,target)){
			return Error.BAD_DISTANCE;
		}
		if (!this.board.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (piece.isEatingMovement(origin,target)){
			Coordinate between = piece.getEatedPieceCoordinate(origin, target);
			if (this.board.getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
			this.board.removePiece(between);
		}
		this.board.movePiece(origin, target);
		this.turn.change();
		return null;
	}

	public Board getBoard(){
		return this.board;
	}

	public Color getColor(Coordinate coordinate) {
		return this.board.getColor(coordinate);
	}

	public Color getColor() {
		return this.turn.getColor();
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.board.getPiece(coordinate);
	}

	public boolean isBlocked() {
		return this.board.getPieces(this.turn.getColor()).isEmpty();
	}

	public int getDimension() {
		return this.board.getDimension();
	}

}