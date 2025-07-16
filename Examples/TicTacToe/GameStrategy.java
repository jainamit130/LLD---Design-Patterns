package Examples.TicTacToe;

import Examples.TicTacToe.Entities.Game;
import Examples.TicTacToe.Entities.Move;
import Examples.TicTacToe.Entities.MoveResult;
import Examples.TicTacToe.Entities.Player;
import Examples.TicTacToe.ExceptionHandling.InvalidGameStrategyException;

public abstract class GameStrategy {
    protected final Game game;

    protected GameStrategy(Game game) throws InvalidGameStrategyException {
        if(!isValidStrategy(game)) throw new InvalidGameStrategyException();
        game.setGameStrategy(this);
        this.game = game;
    }

    public abstract boolean isValidStrategy(Game game);
    public abstract boolean isWinning(Player player, Move move);
    public abstract boolean isDraw(Move move);
    public abstract MoveResult processMove(Player player, Move move);
}
