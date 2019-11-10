package draughts.views;

import draughts.utils.Console;

public enum MessageView {

    TITTLE("Draughts"),
    LOOSER("Derrota!!! No puedes mover tus fichas!!!");

    private String message;
    private static Console console = new Console();

    MessageView(String message){
        this.message = message;
    }

    public void write() {
       MessageView.console.write(this.message);
    }

    public void writeln() {
        MessageView.console.writeln(this.message);
     }
}
