package draughts.views;

import draughts.models.Board;
import draughts.models.Coordinate;
import draughts.utils.WithConsoleView;

public class BoardView extends WithConsoleView {

    public BoardView(){
    }

    void writeBoard(Board board){
        final int DIMENSION = board.getDimension();
        console.writeln();
        this.writeNumbersLine(DIMENSION);
        for(int coordY = 0 ; coordY < DIMENSION ; coordY++){
            console.write(String.valueOf((coordY+1)));
            for(int coordX = 0 ; coordX < DIMENSION ; coordX++){
                console.write(board.getSquare(new Coordinate(coordY,coordX)).getPieceSymbol());
            }
            console.writeln(String.valueOf((coordY+1)));
        }
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
        }
        this.console.writeln(" ");
    }
}