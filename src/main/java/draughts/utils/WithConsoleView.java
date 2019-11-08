package draughts.utils;

import draughts.utils.Console;

public abstract class WithConsoleView {

	protected final Console console;

	protected WithConsoleView() {
		this.console = new Console();
	}
	
}