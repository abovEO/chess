package chess.Pieces;

import chess.Board;
import chess.Cell;
import chess.Color;

public class Rook extends Piece {

    public Rook(Color color){
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell to, Cell from) {

        if(isSameColorPiece(to))return false;

        return from.getRow() == to.getRow() ||
                from.getCol() == to.getCol();
    }
}
