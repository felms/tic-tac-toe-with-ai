package tictactoe.player;

import tictactoe.Move;

public abstract class Player {

    private char playingAs;

    public Player(char playingAs) {
        this.playingAs = playingAs;
    }

    public abstract Move getMove(String table);

    public abstract String getMessage();

    public char getPlayingAs() {
        return this.playingAs;
    }
}
