package draughts.views;

import draughts.controllers.StartController;
import draughts.utils.WithConsoleView;

public class StartView extends WithConsoleView {

    public StartView(){
        super();
    }

    public void interact(StartController startController) {
        MessageView.TITTLE.writeln();
        startController.start();
    }
}
