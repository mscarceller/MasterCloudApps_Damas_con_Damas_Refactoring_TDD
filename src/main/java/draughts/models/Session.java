package draughts.models;

public class Session {

	public State state;
	public Game game;

	public Session(){
		this.state = new State();
		this.game = new Game();
	}

}
