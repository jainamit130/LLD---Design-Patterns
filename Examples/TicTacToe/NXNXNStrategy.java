package Examples.TicTacToe;

import Examples.TicTacToe.Entities.*;
import Examples.TicTacToe.ExceptionHandling.InvalidGameStrategyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NXNXNStrategy extends GameStrategy {
    private final int n;
    private final List<Map<Player,Integer>> row;
    private final List<Map<Player,Integer>> col;
    private Map<Player,Integer> diagonal;
    private Map<Player,Integer> antiDiagonal;

    protected NXNXNStrategy(Game game) throws InvalidGameStrategyException {
        super(game);
        int rows = game.getBoard().getRow();
        int cols = game.getBoard().getCol();

        row = new ArrayList<>();
        col = new ArrayList<>();

        for (int i = 0; i < rows; i++)
            row.add(new HashMap<>());

        for (int i = 0; i < cols; i++)
            col.add(new HashMap<>());
        n = row.size();
        diagonal = new HashMap<>();
        antiDiagonal = new HashMap<>();
    }

    private Integer getTotalRowCount(Player player, Move move) {
        return this.row.get(move.getRow()).getOrDefault(player,0);
    }

    private Integer getTotalColCount(Player player,Move move) {
        return this.col.get(move.getCol()).getOrDefault(player,0);
    }

    private void incrementRowCount(Player player, int row) {
        Map<Player,Integer> rowMap = this.row.get(row);
        rowMap.put(player,rowMap.getOrDefault(player,0)+1);
    }

    private void incrementColCount(Player player, int col) {
        Map<Player,Integer> colMap = this.col.get(col);
        colMap.put(player,colMap.getOrDefault(player,0)+1);
    }

    private void incrementDiagonal(Player player) {
        diagonal.put(player,diagonal.getOrDefault(player,0)+1);
    }

    private void incrementAntiDiagonal(Player player) {
        antiDiagonal.put(player,antiDiagonal.getOrDefault(player,0)+1);
    }

    @Override
    public boolean isValidStrategy(Game game) {
        Board board = game.getBoard();
        return board.getRow()== board.getCol() && board.getCol()==game.getWinCount();
    }

    @Override
    public boolean isWinning(Player player,Move move) {
        return getTotalRowCount(player,move)==n || getTotalColCount(player,move)==n || diagonal.getOrDefault(player,0)==n || antiDiagonal.getOrDefault(player,0)==n;
    }

    @Override
    public MoveResult processMove(Player player, Move move) {
        int row = move.getRow();
        int col = move.getCol();
        incrementRowCount(player,row);
        incrementColCount(player,col);
        if(row==col) incrementDiagonal(player);
        if(row+col==n-1) incrementAntiDiagonal(player);
        if(isWinning(player,move)) {
            game.setStatus(GameStatus.COMPLETED);
            return MoveResult.GAME_WON;
        }
        if(isDraw(move)) {
            game.setStatus(GameStatus.DRAW);
            return MoveResult.DRAW;
        }
        return MoveResult.SUCCESS;
    }

    @Override
    public boolean isDraw(Move move) {
        return game.getBoard().isFull();
    }
}
