import java.util.Random;

public class ELPlayer implements Player{

    private char playingAs;

    public ELPlayer(char playingAs) {
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
    public Move getMove(String table) {
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;

        return new Move(x, y);
    }
}
