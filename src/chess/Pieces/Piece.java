package chess.Pieces;

import chess.Cell;
import chess.Color;
import chess.Board;


public abstract class Piece {
    protected Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isSameColorPiece(Cell to) {
        return !to.isEmpty() && to.getPiece().getColor() == this.color;
    }

    public abstract boolean canMove(Board board, Cell to, Cell from);
}
