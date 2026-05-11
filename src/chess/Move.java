package chess;

public class Move {
    public final Cell to;
    public final Cell from;

    public Move(Cell from, Cell to){
        this.from = from;
        this.to = to;
    }

    public Cell getFrom() {
        return from;
    }

    public Cell getTo() {
        return to;
    }
}
