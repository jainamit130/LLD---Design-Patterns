package Examples.TicTacToe.Entities;

import Examples.TicTacToe.Entities.Cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int row;
    private final int col;
    private int freeCells;
    private final List<List<Cell>> grid;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        freeCells = row * col;
        grid = new ArrayList<>(row);
        for(int i=0;i<row;i++) {
            List<Cell> cells = new ArrayList<>(col);
            for(int j=0;j<col;j++) {
                cells.add(new Cell());
            }
            grid.add(cells);
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Cell getCell(int row, int col) {
        return grid.get(row).get(col);
    }

    public boolean isFull() {
        return freeCells==0;
    }

    private boolean isWithinBounds(Move move) {
        return move.getRow()>=0 && move.getRow()<getRow() && move.getCol()>=0 && move.getCol()<getCol();
    }

    public MoveResult playMove(Player player,Move move) {
        if(!isWithinBounds(move)) return MoveResult.INVALID_MOVE;
        Cell cell = getCell(move.getRow(),move.getCol());
        if(cell.isEmpty()) {
            cell.setPiece(player.getPiece());
            freeCells--;
            return MoveResult.SUCCESS;
        }
        return MoveResult.INVALID_MOVE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Cell> row : grid) {
            for (Cell cell : row) {
                sb.append(cell.toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
