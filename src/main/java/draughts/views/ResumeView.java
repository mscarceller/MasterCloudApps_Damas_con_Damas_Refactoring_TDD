package draughts.views;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;

public class ResumeView {

    private static final String RESUME = "¿Queréis jugar otra";
    private YesNoDialog yesNoDialog;

    public ResumeView(){
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        resumeController.isNewGame(this.yesNoDialog.read(RESUME));
    }
}
