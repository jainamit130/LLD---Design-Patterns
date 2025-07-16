package Examples.TicTacToe.Entities;

import Examples.TicTacToe.GameStrategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Game {
    private final Deque<Player> players;
    private final int winCount;
    private final Board board;
    private GameStatus status;
    private GameStrategy gameStrategy;

    public Game(List<Player> players, int winCount, Board board) {
        players.stream().forEach(player -> player.setGame(this));
        this.players = new ArrayDeque<>(players);
        this.winCount = winCount;
        this.board = board;
        this.status = GameStatus.RUNNING;
    }

    public void setGameStrategy(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public boolean isRunning() {
        return status.equals(GameStatus.RUNNING);
    }

    public Board getBoard() {
        return board;
    }

    public void nextTurn() {
        players.offer(players.poll());
    }

    public int getWinCount() {
        return winCount;
    }

    public Player getActiveTurnPlayer() {
        return players.getFirst();
    }

    protected boolean isValidStrategy(GameStrategy strategy) {
        return strategy.isValidStrategy(this);
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean isValidTurn(Player player) {
        return player.equals(players.getFirst());
    }

    public MoveResult playMove(Player player,Move move) {
        MoveResult moveResult = board.playMove(player,move);
        if(!moveResult.isValid()) return moveResult;
        MoveResult moveOutcome = gameStrategy.processMove(player, move);
        moveOutcome.nextTurn(this);
        return moveOutcome;
    }
}
