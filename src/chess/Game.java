package chess;

public class Game {
    private int id;
    private Player WhitePlayer;
    private Player BlackPlayer;

    private Player CurrentPlayer;

    private Board board;
    private final MovesValidator validator;

    public Game() {
        board = new Board();

        WhitePlayer = new Player("white", Color.WHITE);
        BlackPlayer = new Player("black", Color.BLACK);

        CurrentPlayer = WhitePlayer;
        validator = new MovesValidator();
    }

    public void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        Cell from = board.getCell(fromRow, fromCol);
        Cell to = board.getCell(toRow, toCol);

        Move move = new Move(from, to);

        boolean isValidMove = validator.isValidMove(board, move, CurrentPlayer);

        if (isValidMove) {
            board.movePiece(from, to);
            System.out.println("Move Executed");
            switchTurns();
            if(isCheckmate(CurrentPlayer)) {
                System.out.println( CurrentPlayer.getName() + " is in checkmate. LOST");
            }
            if(isStalemate(CurrentPlayer)) {
                System.out.println( CurrentPlayer.getName() + " is in stalemate. LOST");
            }
        } else {
            System.out.println("Invalid move");
        }


    }

    public void switchTurns() {
        CurrentPlayer = CurrentPlayer == WhitePlayer ? BlackPlayer : WhitePlayer;
    }

    public boolean isCheckmate(Player player) {
        boolean kingInCheck =
                validator.isKingUnderAttack(
                        board,
                        player.getColor());

        boolean hasMoves =
                validator.hasLegalMoves(
                        board,
                        player);
        return kingInCheck && !hasMoves;
    }

    public boolean isStalemate(Player player) {

        boolean kingInCheck =
                validator.isKingUnderAttack(
                        board,
                        player.getColor());

        boolean hasMoves =
                validator.hasLegalMoves(
                        board,
                        player);

        return !kingInCheck && !hasMoves;
    }
}
