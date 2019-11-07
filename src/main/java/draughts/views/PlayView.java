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
        GameView gameView = new GameView();
        do { 
            gameView.write(playController);
            Coordinate[] coordinates = readValidCoordinates(playController,gameView);
            error = playController.move(coordinates[0],coordinates[1]);
            if (error != null){
                console.writeln("Error!!!" + error.name());
            }
        } while (error != null); 
        if (playController.isBlocked()){
            MessageView.LOOSER.writeln();
        }
    }

    public Coordinate[] readValidCoordinates(PlayController playController,GameView gameView){
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        Coordinate[] coordinates = new Coordinate[2];
        Error error;
        do{
            error = null;
            String command = this.console.readString("Mueven las " + color + ": ");
            if (command.matches("[0-9][0-9]+([.][0-9][0-9])?$")){
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