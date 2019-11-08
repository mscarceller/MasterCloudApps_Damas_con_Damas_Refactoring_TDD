package draughts.views;

import draughts.models.Board;
import draughts.models.Coordinate;

public class BoardView extends SubView {

    public BoardView(){
    }

    public void writeBoard(Board board){
        final int DIMENSION = board.getDimension();
        console.writeln();
        this.writeNumbersLine(DIMENSION);
        for(int coordY = 0 ; coordY < 8 ; coordY++){
           console.write(String.valueOf((coordY+1)));
            for(int coordX = 0 ; coordX < 8 ; coordX++){
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