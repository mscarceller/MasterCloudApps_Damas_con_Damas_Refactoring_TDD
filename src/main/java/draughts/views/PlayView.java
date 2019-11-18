package draughts.views;

import java.util.HashMap;
import java.util.Map;

import draughts.controllers.PlayController;
import draughts.models.Error;
import draughts.models.Coordinate;
import draughts.utils.WithConsoleView;

public class PlayView extends WithConsoleView {

    private static final String[] COLORS = {"blancas", "negras"};
    private static final String GIVEUP_COMMAND = "-1";
    private static final String REGEXP_COMMAND = "([0-9]{2,2})+(?:[.][0-9]{2,2})+(,([0-9]{2,2})+(?:[.][0-9]{2,2}))?";

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        boolean moved = false;
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        new BoardView().writeBoard(playController.getBoard());
        do {
            String command = readValidCommand(color);
            if (command.equals(GIVEUP_COMMAND)){
                playController.cancelGame();
                break;
            }
            else{
                moved = this.tryToMove(playController, command);
            }
        } while (!moved);  
        playController.nextTurn();
        this.checkIfGameOver(playController); 
    }

    private void checkIfGameOver(PlayController playController){
        if (playController.isBlocked()){
            new BoardView().writeBoard(playController.getBoard());
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

    private boolean tryToMove(PlayController playController, String command){
        String[] commands = command.split(",");
        if(commands.length>3){
            new ErrorView(Error.TOO_MUCH_MOVEMENTS).writeln();
            return false;
        }
        if(commands.length>1){
            return multipleMovements(playController, commands);
        }
        return singleMovement(playController, command);
    }

    private boolean multipleMovements(PlayController playController, String[] commands ){
        boolean moved = false;
        for (String command : commands){
            Coordinate origin = new Coordinate(command.substring(0, 2));
            Coordinate target = new Coordinate(command.substring(3, 5));
            if (!origin.isValid() || !target.isValid()) {
                new ErrorView(Error.OUT_COORDINATE).writeln();
                return false;
            }
            if (origin.diagonalDistance(target)<2){
                new ErrorView(Error.BAD_DISTANCE).writeln();
                return false;
            }
            if (singleMovement(playController, command)==true)
                moved = true;
        }
        return moved; 
    }


    private boolean singleMovement(PlayController playController, String command){
        Coordinate origin = new Coordinate(command.substring(0, 2));
        Coordinate target = new Coordinate(command.substring(3, 5));
        Error error;
        if (!origin.isValid() || !target.isValid()) {
            new ErrorView(Error.OUT_COORDINATE).writeln();
            return false;
        }
        else{
            error = playController.isCorrect(origin,target);
        }
        if (error != null){
            new ErrorView(error).writeln();
            return false;
        }
        playController.move(origin, target); 
        return true; 
    }
}
