package draughts.models;


public class Game {

	private Board board;

	private Turn turn;

	public Game() {
		this.board = new Board();
		this.turn = new Turn();
		this.initGame();	
	}

	public void setBoard(Board board){
		this.board = board;
	}

	public void initGame(){
		this.board.setInitialSquares();
		this.board.setInitialPieces();
		this.turn.setInitialTurn();
	}

	public Error move(Coordinate origin, Coordinate target) {
		assert this.isCorrect(origin, target) == null;
		Piece piece = this.board.getPiece(origin);
		if (piece.isEatingMovement(origin,target)){
			this.board.removePiece(piece.getEatedPieceCoordinate(origin, target));
		}
		this.board.movePiece(origin, target);
		this.turn.change();
		return null;
	}

	public Error isCorrect(Coordinate origin, Coordinate target){
		assert origin != null;
		assert target != null;
		if (board.isEmpty(origin)) {
			return Error.EMPTY_ORIGIN;
		}
		if (this.turn.getColor() != this.board.getColor(origin)) {
			return Error.OPPOSITE_PIECE;
		}
		return this.board.getPiece(origin).isCorrect(origin, target, board);
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
		return (!(this.areMorePieces(this.getColor()) && this.areAvailableMovements(this.getColor())));
	}

	public boolean areMorePieces(Color color){
		return (!this.board.getPieces(color).isEmpty());
	}

	public boolean areAvailableMovements(Color color){
		return true;
	}

	public int getDimension() {
		return this.board.getDimension();
	}

}