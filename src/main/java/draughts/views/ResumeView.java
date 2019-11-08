package draughts.views;

import draughts.controllers.ResumeController;
import draughts.utils.YesNoDialog;
import draughts.utils.WithConsoleView;

public class ResumeView extends WithConsoleView {

    private YesNoDialog yesNoDialog;

    public ResumeView(){
        super();
        this.yesNoDialog = new YesNoDialog();
    }

    public void interact(ResumeController resumeController) {
        if (this.yesNoDialog.read(MessageView.LOOSER.toString())){
            resumeController.reset();
        } else {
            resumeController.next();
        }

    }
}
