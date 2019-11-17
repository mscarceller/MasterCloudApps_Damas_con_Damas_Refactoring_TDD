package draughts.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBuilder{

    Board board;

    private List<String> boardStrings;

    GameBuilder(){
        this.boardStrings = new ArrayList<>();
    }

    GameBuilder row(String boardString){
        this.boardStrings.add(boardString);
        return this;
    }

    Game build(){
        this.board = new Board();
        Game game = new Game();
        for (int row = 0 ; row < this.boardStrings.size() ; row++) {
            String boardString = this.boardStrings.get(row);
            for (int col = 0; col < boardString.length(); col++){
                if (boardString.charAt(col)!=' '){
                    this.putPiece(boardString.charAt(col),row,col);
               }
            }
        }
        game.setBoard(this.board);
        return game;
    }
    
    private void putPiece(char charPiece, int row, int col){
        Map<Character, Piece> pieces = new HashMap<Character, Piece>(); 
        pieces.put('b', new Pawn(Color.WHITE));
        pieces.put('n', new Pawn(Color.BLACK));
        pieces.put('B', new Draught(Color.WHITE));
        pieces.put('N', new Draught(Color.BLACK));
        this.board.putPiece(new Coordinate(row,col), pieces.get(charPiece));
    }

}
