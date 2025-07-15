package Examples.TicTacToe.Entities.Cell;

public class Piece {
    private PieceType type;

    public PieceType getType() {
        return type;
    }

    public Piece(PieceType type) {
        this.type = type;
    }
}
