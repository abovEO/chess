package chess;

import chess.Pieces.Piece;

public class Cell {
    private final int row;
    private final int col;

    private Piece piece;

    public Cell(int row, int col) {

        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }
}
