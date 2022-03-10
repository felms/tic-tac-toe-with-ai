package tictactoe;

public enum GameState {

    GAME_NOT_FINISHED("Game not finished"),
    DRAW ("Draw"),
    X_WINS ("X wins"),
    O_WINS ("O wins");

    private String string;

    GameState(String message) {
        string = message;
    }

    public String toString() {
        return string;
    }
}
