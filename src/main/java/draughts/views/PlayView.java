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
        String command = "";
        do { 
            gameView.write(playController);
            command = readValidCoordinatesStringForColor(playController,gameView);
            error = playController.move(
                new Coordinate(command.substring(0, 2)), 
                new Coordinate(command.substring(3, 5)));
            if (error != null){
                console.writeln("Error!!!" + error.name());
            }
        } while (error != null); 
        if (playController.isBlocked()){
            MessageView.LOOSER.writeln();
        }
    }

    public String readValidCoordinatesStringForColor(PlayController playController,GameView gameView){
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        String command = this.console.readString("Mueven las " + color + ": ");
        while(!command.matches("[0-9][0-9]+([.][0-9][0-9])?$")){                           
            MessageView.ERRORINPUT.writeln();
            gameView.write(playController);
            command = this.console.readString("Mueven las " + color + ": ");       
        }
        return command;
    }

}