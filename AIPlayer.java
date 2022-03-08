import java.util.Random;

public class AIPlayer implements Player{

    private char playingAs;

    public AIPlayer(char playingAs) {
        this.playingAs = playingAs;
    }

    @Override
    public String getMessage() {
        return "Making move level \"easy\"";
    }

    @Override
    public char getPlayingAs() {
        return this.playingAs;
    }

    @Override
    public Move getMove() {
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;

        return new Move(x, y);
    }
}
