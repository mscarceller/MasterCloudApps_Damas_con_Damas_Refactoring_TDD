package draughts.views;

import draughts.utils.YesNoDialog;
import draughts.controllers.CancelController;

public class CancelView {

    private YesNoDialog yesNoDialog;
    private static final String GIVEUP = "¿Quieres rendirte";

    public CancelView(){
        this.yesNoDialog = new YesNoDialog();
    }

    public void confirmCancel(CancelController cancelController) {
        cancelController.cancel(this.yesNoDialog.read(GIVEUP));
    }

}