package chess;

import chess.Pieces.King;
import chess.Pieces.Piece;

public class MovesValidator {
    public boolean isValidMove(Board board, Move move, Player CurrentPlayer) {
        Cell from = move.getFrom();
        Cell to = move.getTo();

        if (!board.isValidPosition(from.getRow(), from.getCol()) ||
                !board.isValidPosition(to.getRow(), to.getCol())) {
            return false;
        }

        Piece piece = from.getPiece();

        if (piece == null) return false;

        if (piece.getColor() != CurrentPlayer.getColor()) return false;
        if (!piece.canMove(board, to, from)) return false;

        if (moveExposesKing(board, to, from)) return false;

        return true;
    }

    public boolean moveExposesKing(Board board, Cell to, Cell from) {
        Piece fromCellPiece = from.getPiece();
        Piece toCellPiece = to.getPiece();

        to.setPiece(fromCellPiece);
        from.setPiece(null);

        boolean isKingInCheck = isKingUnderAttack(board, fromCellPiece.getColor());

        to.setPiece(toCellPiece);
        from.setPiece(fromCellPiece);

        return isKingInCheck;
    }

    public boolean isKingUnderAttack(Board board, Color KingColor) {
        Cell kingCell = findKing(board, KingColor);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = board.getCell(i, j);
                Piece piece = cell.getPiece();

                if (piece == null) {
                    continue;
                }

                if (piece.getColor() == KingColor) {
                    continue;
                }

                if (piece.canMove(board, cell, kingCell)) return true;
            }
        }

        return false;
    }

    public Cell findKing(Board board, Color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = board.getCell(i, j);
                Piece piece = cell.getPiece();

                if (piece instanceof King && piece.getColor() == color)
                    return cell;
            }
        }
        return null;
    }
}
