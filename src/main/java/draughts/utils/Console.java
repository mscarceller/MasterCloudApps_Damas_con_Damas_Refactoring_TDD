package draughts.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	private static final String ERROR_STRING = "de cadena de caracteres";
	private static final String ERROR_INTEGER = "entero";
	private static final String ERROR_CHAR ="caracter";
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		String input = null;
		boolean error = false;
		do {
			this.write(title);
			try {
				input = bufferedReader.readLine();
			} catch (IOException ex) {
				this.writeError(ERROR_STRING);
				error = true;
			}
		} while (error);
		return input;
	}

	public int readInt(String title) {
		int input = 0;
		boolean error = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
			} catch (NumberFormatException ex) {
				this.writeError(ERROR_INTEGER);
				error = true;
			}
		} while (error);
		return input;
	}

	public char readChar(String title) {
		boolean error = false;
		String input = null;
		do {
			input = this.readString(title);
			if (input.length() != 1) {
				this.writeError(ERROR_CHAR);
				error = true;
			}
		} while (error);
		return input.charAt(0);
	}

	public void writeln() {
		System.out.println();
	}
	
	public void write(String string) {
		System.out.print(string);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	private void writeError(String formato) {
		System.out.println("ERROR DE FORMATO! "
				+ "Introduzca un valor con formato " + formato + ".");
	}
}
