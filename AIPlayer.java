import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer() {
        super('O');
    }

    @Override
    public Move getMove() {
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;

        return new Move(x, y);
    }
}
