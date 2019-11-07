package draughts.controllers;

import draughts.models.Color;
import draughts.models.Coordinate;
import draughts.models.Session;

public abstract class Controller {

    protected Session session;

    protected Controller(Session session) {
		this.session = session;
    }

    public Color getColor(Coordinate coordinate) {
		return this.session.game.getColor(coordinate);
	}

	public int getDimension() {
		return this.session.game.getDimension();
	}

	abstract public void accept(ControllersVisitor controllersVisitor);
    
}
