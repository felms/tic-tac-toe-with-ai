import java.util.Random;

public class MLPlayer implements Player{

    private char playingAs;
    private Move currentMove;

    public MLPlayer(char playingAs) {
        this.playingAs = playingAs;
    }

    @Override
    public Move getMove(String table) {

        if (hasWinningMove(table)) {
            return this.currentMove;
        }

        if (closeToLose(table)) {
            return this.currentMove;
        }

        randomMove();
        return this.currentMove;
    }

    // Checa as nove posições para ver se
    // existe algum movimento vencedor no tabuleiro
    // e cria o mesmo caso seja possível
    private boolean hasWinningMove(String table) {
        char[] t = table.toCharArray();

        if (((this.playingAs == t[1] && this.playingAs == t[2])
                || (this.playingAs == t[3] && this.playingAs == t[6])
                || (this.playingAs == t[4] && this.playingAs == t[8]))
                && t[0] == '_'){
            this.currentMove = new Move(1, 1);
            return true;
        }

        if (((this.playingAs == t[0] && this.playingAs == t[2])
                || (this.playingAs == t[4] && this.playingAs == t[7]))
                && t[1] == '_') {
            this.currentMove = new Move(1, 2);
            return true;
        }

        if (((this.playingAs == t[0] && this.playingAs == t[1])
                || (this.playingAs == t[4] && this.playingAs == t[6])
                || (this.playingAs == t[5] && this.playingAs == t[8]))
                && t[2] == '_') {
            this.currentMove = new Move(1, 3);
            return true;
        }

        if (((this.playingAs == t[0] && this.playingAs == t[6])
                || (this.playingAs == t[4] && this.playingAs == t[5]))
                && t[3] == '_') {
            this.currentMove = new Move(2, 1);
            return true;
        }

        if (((this.playingAs == t[0] && this.playingAs == t[8])
                || (this.playingAs == t[2] && this.playingAs == t[6])
                || (this.playingAs == t[1] && this.playingAs == t[7])
                || (this.playingAs == t[3] && this.playingAs == t[5]))
                && t[4] == '_') {
            this.currentMove = new Move(2, 2);
            return true;
        }

        if (((this.playingAs == t[2] && this.playingAs == t[8])
                || (this.playingAs == t[3] && this.playingAs == t[4]))
                && t[5] == '_') {
            this.currentMove = new Move(2, 3);
            return true;
        }

        if (((this.playingAs == t[0] && this.playingAs == t[3])
                || (this.playingAs == t[2] && this.playingAs == t[4])
                || (this.playingAs == t[7] && this.playingAs == t[8]))
                && t[6] == '_') {
            this.currentMove = new Move(3, 1);
            return true;
        }

        if (((this.playingAs == t[1] && this.playingAs == t[4])
                || (this.playingAs == t[6] && this.playingAs == t[8]))
                && t[7] == '_') {
            this.currentMove = new Move(3, 2);
            return true;
        }

        if (((this.playingAs == t[0] && this.playingAs == t[4])
                || (this.playingAs == t[2] && this.playingAs == t[5])
                || (this.playingAs == t[6] && this.playingAs == t[7]))
                && t[8] == '_') {
            this.currentMove = new Move(3, 3);
            return true;
        }

        return false;
    }

    // Checa as nove posições para ver se
    // existe algum movimento vencedor para o adversário no tabuleiro
    // e cria o movimento para bloqueá-lo caso seja possível
    private boolean closeToLose(String table) {
        char[] t = table.toCharArray();
        char opponent = this.playingAs == 'O' ? 'X' : 'O';

        if (((opponent == t[1] && opponent == t[2])
                || (opponent == t[3] && opponent == t[6])
                || (opponent == t[4] && opponent == t[8]))
                && t[0] == '_') {
            this.currentMove = new Move(1, 1);
            return true;
        }

        if (((opponent == t[0] && opponent == t[2])
                || (opponent == t[4] && opponent == t[7]))
                && t[1] == '_') {
            this.currentMove = new Move(1, 2);
            return true;
        }

        if (((opponent == t[0] && opponent == t[1])
                || (opponent == t[4] && opponent == t[6])
                || (opponent == t[5] && opponent == t[8]))
                && t[2] == '_') {
            this.currentMove = new Move(1, 3);
            return true;
        }

        if (((opponent == t[0] && opponent == t[6])
                || (opponent == t[4] && opponent == t[5]))
                && t[3] == '_') {
            this.currentMove = new Move(2, 1);
            return true;
        }

        if (((opponent == t[0] && opponent == t[8])
                || (opponent == t[2] && opponent == t[6])
                || (opponent == t[1] && opponent == t[7])
                || (opponent == t[3] && opponent == t[5]))
                && t[4] == '_') {
            this.currentMove = new Move(2, 2);
            return true;
        }

        if (((opponent == t[2] && opponent == t[8])
                || (opponent == t[3] && opponent == t[4]))
                && t[5] == '_') {
            this.currentMove = new Move(2, 3);
            return true;
        }

        if (((opponent == t[0] && opponent == t[3])
                || (opponent == t[2] && opponent == t[4])
                || (opponent == t[7] && opponent == t[8]))
                && t[6] == '_') {
            this.currentMove = new Move(3, 1);
            return true;
        }

        if (((opponent == t[1] && opponent == t[4])
                || (opponent == t[6] && opponent == t[8]))
                && t[7] == '_') {
            this.currentMove = new Move(3, 2);
            return true;
        }

        if (((opponent == t[0] && opponent == t[4])
                || (opponent == t[2] && opponent == t[5])
                || (opponent == t[6] && opponent == t[7]))
                && t[8] == '_') {
            this.currentMove = new Move(3, 3);
            return true;
        }

        return false;
    }

    // Gera um movimento aleatório
    private void randomMove() {
        Random random = new Random();
        int x = random.nextInt(3) + 1;
        int y = random.nextInt(3) + 1;

        this.currentMove = new Move(x, y);
    }

    @Override
    public String getMessage() {
        return "Making move level \"medium\"";
    }

    @Override
    public char getPlayingAs() {
        return this.playingAs;
    }
}
