package draughts.controllers;

import draughts.models.State;

import draughts.views.CancelView;

public class CancelController {

	private State state;
	
    public CancelController(State state) {
		this.state = state;
    }

    public void cancelGame() {
        new CancelView().confirmCancel(this);		
    }

    public void cancel(boolean cancel){
         if (cancel){
             this.state.next();
        }
    }
}
