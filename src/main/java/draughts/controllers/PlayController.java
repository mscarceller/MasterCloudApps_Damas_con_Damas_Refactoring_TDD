package draughts.controllers;

import draughts.models.Board;
import draughts.models.Color;
import draughts.models.Coordinate;
import draughts.models.Piece;
import draughts.models.State;
import draughts.models.Error;
import draughts.models.Game;

public class PlayController extends Controller {

	private CancelController cancelController;
	private MoveController moveController;

    public PlayController(Game game, State state) {
		super(game, state);
		this.cancelController = new CancelController(state);
		this.moveController = new MoveController(game);
	}

	public void nextTurn(){
		this.game.nextTurn();
	}

	public void move(Coordinate origin, Coordinate target){
		this.moveController.move(origin, target);
	}

	public Error isCorrect(Coordinate origin, Coordinate target){
		return this.moveController.isCorrect(origin, target);
	}

	public void cancelGame(){
		this.cancelController.cancelGame();
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.game.getPiece(coordinate);
	}

	public Color getColor() {
		return this.game.getColor();
	}

	public void gameOver(){
		this.state.next();
	}
	
	public boolean isBlocked() {
		return this.game.isBlocked();
	}	

	public Board getBoard(){
		return this.game.getBoard();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		assert controllersVisitor != null;
		controllersVisitor.visit(this);
	}

}