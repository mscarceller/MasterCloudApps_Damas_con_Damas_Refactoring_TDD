package draughts.views;

import draughts.controllers.PlayController;
import draughts.models.Error;
import draughts.models.Coordinate;

public class PlayView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        Error error = null;
        BoardView boardView = new BoardView();
        do { 
            boardView.writeBoard(playController.getBoard());
            Coordinate[] coordinates = readValidCoordinates(playController);
            error = playController.move(coordinates[0],coordinates[1]);
            if (error != null){
                new ErrorView(error).writeln();
            }
        } while (error != null); 
        if (playController.isBlocked()){
            MessageView.LOOSER.writeln();
            playController.gameOver();
        }
    }

    public Coordinate[] readValidCoordinates(PlayController playController){
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        Coordinate[] coordinates = new Coordinate[2];
        Error error;
        do{
            error = null;
            String command = this.console.readString("Mueven las " + color + ": ");
            if (command.matches("([0-9]{2,2})+(?:[.][0-9]{2,2})$")){
                coordinates[0] = new Coordinate(command.substring(0, 2));
                coordinates[1] = new Coordinate(command.substring(3, 5));
                if (!coordinates[0].isValid() || !coordinates[1].isValid()) {
                    error  = Error.OUT_COORDINATE;
                }
            }
            else{
                error  = Error.ERROR_INPUT;
            }
            if (error != null){
                new ErrorView(error).writeln();
            }
        }while(error!=null);
        return coordinates;
    }
}