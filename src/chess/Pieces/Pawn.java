package chess.Pieces;

import chess.Board;
import chess.Cell;
import chess.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell to, Cell from) {
        if (isSameColorPiece(to)) {
            return false;
        }

        int direction = color == Color.WHITE ? -1 : 1;
        int startRow = color == Color.WHITE ? 6 : 1;

        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());

        Piece destinationPiece = to.getPiece();
        if (colDiff == 0
                && rowDiff == direction
                && destinationPiece == null) return true;

        if(from.getRow() == startRow && rowDiff ==2 && colDiff==0 && destinationPiece == null)
            return true;

        if (colDiff == 1
                && rowDiff == direction
                && destinationPiece != null) {
            return true;
        }

        return false;
    }
}
