package draughts.controllers;

import draughts.models.Color;
import draughts.models.Coordinate;
import draughts.models.Piece;
import draughts.models.Session;
import draughts.models.Error;

public class PlayController extends Controller {

    public PlayController(Session session) {
		super(session);
	}

	public Error move(Coordinate origin, Coordinate target){
		Error error = this.session.game.move(origin, target);
		if (this.session.game.isBlocked()){
			this.session.state.next();
		}
		return error;
    }

	public Piece getPiece(Coordinate coordinate) {
		return session.game.getPiece(coordinate);
	}

	public Color getColor() {
		return session.game.getColor();
	}
	
	public boolean isBlocked() {
		return session.game.isBlocked();
	}	

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}