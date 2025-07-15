package Examples.TicTacToe.Entities;

public enum MoveResult {
    SUCCESS {
        @Override
        public String toString() {
            return "Move Successfully made!";
        }
    },
    INVALID_MOVE {
        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public String toString() {
            return "Invalid Move! Please try again";
        }
    },
    INVALID_TURN {
        @Override
        public boolean isValid() {
            return false;
        }

        @Override
        public String toString() {
            return "Invalid Turn! Please wait for your turn";
        }
    },
    GAME_WON {
        @Override
        public MoveResult updateStats(Player player) {
            player.incrementWins();
            return this;
        }

        @Override
        public String toString() {
            return "You won!";
        }
    },
    DRAW {
        @Override
        public MoveResult updateStats(Player player) {
            player.incrementDraws();
            return this;
        }

        @Override
        public String toString() {
            return "Game is draw!";
        }

        @Override
        public boolean isValid() {
           return false;
        }
    };

    public boolean isValid() {
        return true;
    }

    public MoveResult updateStats(Player player) {
        return this;
    }

    public void nextTurn(Game game) {
        game.nextTurn();
    }


    public abstract String toString();
}

