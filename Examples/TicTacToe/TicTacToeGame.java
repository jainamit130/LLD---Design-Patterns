package Examples.TicTacToe;

import Examples.TicTacToe.Entities.Cell.Piece;
import Examples.TicTacToe.Entities.Cell.PieceType;
import Examples.TicTacToe.Entities.*;

import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    public void playGame(Game game) {
        while(game.isRunning()) {
            System.out.println(game.getBoard());
            Player activeTurnPlayer = game.getActiveTurnPlayer();
            System.out.println("Player " + activeTurnPlayer.getName() + " turn!");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println(activeTurnPlayer.playMove(new Move(row,col)));
        }
    }

    public static void main(String[] args) {
        // Create users
        User user1 = new User("u101", "Alice", 5L, 2L, 10L);
        User user2 = new User("u102", "Bob", 3L, 1L, 6L);

        Piece piece1 = new Piece(PieceType.CROSS);
        Piece piece2 = new Piece(PieceType.CIRCILE);

        Player player1 = new Player(user1, piece1);
        Player player2 = new Player(user2, piece2);

        Board board = new Board(3, 3);

        int winCount = 3;

        Game game;
        try {
            game = new Game(List.of(player1, player2), winCount, board);
            new NXNXNStrategy(game);

            TicTacToeGame runner = new TicTacToeGame();
            System.out.println("Starting TicTacToe Game:");
            runner.playGame(game);

            System.out.println("Final Board:");
            System.out.println(board);

        } catch (Exception e) {
            System.out.println("Failed to start game: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
