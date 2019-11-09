package draughts.views;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;
import draughts.utils.WithConsoleView;

public class ResumeView extends WithConsoleView {

    private static final String RESUME = "¿Queréis jugar otra";
    private YesNoDialog yesNoDialog;

    public ResumeView(){
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        resumeController.isNewGame(this.yesNoDialog.read(RESUME));
    }
}
