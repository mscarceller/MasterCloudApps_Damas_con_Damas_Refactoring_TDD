package draughts.views;

import draughts.controllers.PlayController;
import draughts.models.Error;
import draughts.models.Coordinate;
import draughts.utils.WithConsoleView;

public class PlayView extends WithConsoleView {

    private static final String[] COLORS = {"blancas", "negras"};
    private static final String GIVEUP_COMMAND = "-1";
    private static final String REGEXP_COMMAND = "([0-9]{2,2})+(?:[.][0-9]{2,2})$";

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        Error error = null;
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        new BoardView().writeBoard(playController.getBoard());
        this.checkIfGameOver(playController);
        do {
            String command = readValidCommand(color);
            if (command.equals(GIVEUP_COMMAND)){
                error = null;
                playController.cancelGame();
            }
            else{
                error = this.tryToMove(playController, command);
            }
            if (error != null){
                new ErrorView(error).writeln();
            }
        } while (error != null);   
    }

    private void checkIfGameOver(PlayController playController){
        if (playController.isBlocked()){
            MessageView.LOOSER.writeln();
            playController.gameOver();
        }
    }

    private String readValidCommand(String color){
        String command;
        Error error;
        do{
            error = null;
            command = this.console.readString("Mueven las " + color + ": ");
            if (!command.matches(REGEXP_COMMAND + "|" + GIVEUP_COMMAND)){
                error  = Error.ERROR_INPUT;
                new ErrorView(error).writeln();
            }
        }while(error!=null);
        return command;
    }

    private Error tryToMove(PlayController playController, String command){
        Coordinate origin = new Coordinate(command.substring(0, 2));
        Coordinate target = new Coordinate(command.substring(3, 5));
        Error error;
        if (!origin.isValid() || !target.isValid()) {
            return Error.OUT_COORDINATE;
        }
        else{
            error = playController.isCorrect(origin,target);
        }
        if (error == null){
            playController.move(origin, target); 
        }
        return error;  
    }
}
