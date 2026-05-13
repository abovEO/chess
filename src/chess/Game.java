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
            switchTurns();
            System.out.println("Move Executed");
        } else {
            System.out.println("Invalid move");
            return;
        }
    }

    public void switchTurns() {
        CurrentPlayer = CurrentPlayer == WhitePlayer ? BlackPlayer : WhitePlayer;
    }
}
