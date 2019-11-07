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
		Error error = this.session.move(origin, target);
		if (this.session.isBlocked()){
			this.session.next();
		}
		return error;
    }

	public Piece getPiece(Coordinate coordinate) {
		return session.getPiece(coordinate);
	}

	public Color getColor() {
		return session.getColor();
	}
	
	public boolean isBlocked() {
		return session.isBlocked();
	}	

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}