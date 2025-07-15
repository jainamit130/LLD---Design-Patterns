package Examples.TicTacToe.Entities;

import Examples.TicTacToe.Entities.Cell.Piece;

public class Player extends User {
    private Game game;
    private final Piece piece;

    public Player(User user, Piece piece) {
        super(user);
        this.piece = piece;
        user.incrementGamesPlayed();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Piece getPiece() {
        return piece;
    }

    public MoveResult playMove(Move move) {
        if(game.isValidTurn(this)) {
            return game.playMove(this,move).updateStats(this);
        }
        System.out.println("Invalid turn! Please wait for your turn.");
        return MoveResult.INVALID_TURN;
    }


}
