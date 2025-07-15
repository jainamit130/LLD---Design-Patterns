package Examples.TicTacToe.Entities.Cell;

public class Cell {
    private Piece piece;

    public Cell() {
    }

    public Cell(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        if (isEmpty()) return ".";

        return switch (piece.getType()) {
            case CROSS -> "X";
            case CIRCILE -> "O";
        };
    }
}
