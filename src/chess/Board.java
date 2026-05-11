package chess;

import chess.Pieces.*;

public class Board {
    private Cell[][] board;

    public Board() {
        this.board = new Cell[8][8];
        initializeBoard();
    }

    private void setBoard() {

        board[0][7].setPiece(new Rook(Color.BLACK));
        board[0][0].setPiece(new Rook(Color.BLACK));
        board[0][5].setPiece(new Bishop(Color.BLACK));
        board[0][2].setPiece(new Bishop(Color.BLACK));
        board[0][6].setPiece(new Knight(Color.BLACK));
        board[0][1].setPiece(new Knight(Color.BLACK));
        board[0][4].setPiece(new King(Color.BLACK));
        board[0][3].setPiece(new Queen(Color.BLACK));


        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(new Pawn(Color.BLACK));
        }

        board[7][7].setPiece(new Rook(Color.WHITE));
        board[7][0].setPiece(new Rook(Color.WHITE));
        board[7][5].setPiece(new Bishop(Color.WHITE));
        board[7][2].setPiece(new Bishop(Color.WHITE));
        board[7][6].setPiece(new Knight(Color.WHITE));
        board[7][1].setPiece(new Knight(Color.WHITE));
        board[7][4].setPiece(new King(Color.WHITE));
        board[7][3].setPiece(new Queen(Color.WHITE));


        for (int i = 0; i < 8; i++) {
            board[6][i].setPiece(new Pawn(Color.WHITE));
        }
    }


    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
        setBoard();
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public Cell getCell(int row, int col) {
        if (!isValidPosition(row, col)) {
            throw new IllegalArgumentException(
                    "Invalid board position");
        }
        return board[row][col];
    }

    public Piece getPiece(int row, int col) {
        return getCell(row, col).getPiece();
    }

    public void movePiece(Cell from, Cell to) {

        Piece piece = from.getPiece();

        to.setPiece(piece);

        from.setPiece(null);
    }

}
