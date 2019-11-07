package draughts.views;

import draughts.controllers.StartController;

public class StartView extends SubView {

    public StartView(){
        super();
    }

    public void interact(StartController startController) {
        MessageView.TITTLE.writeln();
        startController.start();
    }
}
