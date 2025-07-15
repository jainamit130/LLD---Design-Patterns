package Examples.TicTacToe.Entities;

public class User {
    private String userId;
    private String name;
    private Long wins;
    private Long draws;
    private Long gamesPlayed;

    public User(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.wins = user.getWins();
        this.draws = user.getDraws();
        this.gamesPlayed = user.getGamesPlayed();
    }

    public User(String userId, String name, Long wins, Long draws, Long gamesPlayed) {
        this.userId = userId;
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.gamesPlayed = gamesPlayed;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed+=1;
    }

    public void incrementWins() {
        this.wins+=1;
    }

    public void incrementDraws() {
        this.draws+=1;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Long getWins() {
        return wins;
    }

    public Long getDraws() {
        return draws;
    }

    public Long getGamesPlayed() {
        return gamesPlayed;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
