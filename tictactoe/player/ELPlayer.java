package tictactoe.player;

import tictactoe.Move;
import java.util.Random;

public class ELPlayer extends Player{


    public ELPlayer(char playingAs) {
        super(playingAs);
    }

    @Override
    public String getMessage() {
        return "Making move level \"easy\"";
    }

    @Override
    public Move getMove(String table) {
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;

        return new Move(x, y);
    }
}
