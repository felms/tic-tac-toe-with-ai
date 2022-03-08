public class Game {

    private String table;
    private GameState gameState;

    public Game() {
        this.table = "_________";
        this.gameState = GameState.GAME_NOT_FINISHED;
    }

    public Game(String table) {
        this.table = table;
        this.gameState = analizeGame();
    }

    // Imprime o estado da tabela
    // do jogo
    public void printGrid() {

        System.out.println("---------");
        int pos = 0;
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                char c = this.table.charAt(pos);
                c = c == '_' ? ' ' : c;
                System.out.print(c + " ");
                pos++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Faz uma jogada.
    // Retorna falso se a jogada
    // não puder ser feita (célula ocupada)
    public boolean makeMove(Player player, Move move) {

        int inputX = (move.getX() - 1) * 3;
        int inputY = move.getY() - 1;
        int pos = inputX + inputY;

        if (this.table.charAt(pos) != '_') {
            return false;
        }

        StringBuilder sb = new StringBuilder(this.table);
        sb.setCharAt(pos, player.getPlayingAs());

        this.table = sb.toString();

        this.gameState = analizeGame();

        return true;
    }

    // Testa se o jogo terminou.
    // Qualquer uma dessas três condições
    // indica fim de jogo
    public boolean isTheGameFinished() {
        return this.getGameState() == GameState.DRAW
                || this.getGameState() == GameState.X_WINS
                || this.getGameState() == GameState.O_WINS;
    }

    // Retorna o estado atual do jogo.
    private GameState analizeGame() {

        if (!this.hasEmptyCells() && !this.hasThreeXs() && !this.hasThreeOs()) {
            return GameState.DRAW;
        } else if (this.hasThreeXs()) {
            return GameState.X_WINS;
        } else if (this.hasThreeOs()) {
            return GameState.O_WINS;
        }

        return GameState.GAME_NOT_FINISHED;
    }

    // Checa se existem três 'X' em sequência
    // na vertical, horizontal e diagonal
    private boolean hasThreeXs() {
        char[] t = this.table.toCharArray();
        // Checa as horizontais
        if (t[0] == 'X' && t[1] == 'X' && t[2] == 'X'
            || t[3] == 'X' && t[4] == 'X' && t[5] == 'X'
            || t[6] == 'X' && t[7] == 'X' && t[8] == 'X') {
            return true;
        }

        // Checa as verticais
        if (t[0] == 'X' && t[3] == 'X' && t[6] == 'X'
                || t[1] == 'X' && t[4] == 'X' && t[7] == 'X'
                || t[2] == 'X' && t[5] == 'X' && t[8] == 'X') {
            return true;
        }

        // Checa as diagonais
        if (t[0] == 'X' && t[4] == 'X' && t[8] == 'X'
                || t[2] == 'X' && t[4] == 'X' && t[6] == 'X') {
            return true;
        }

        return false;
    }

    // Checa se existem três 'O' em sequencia
    // na vertical, horizontal e diagonal
    private boolean hasThreeOs() {
        char[] t = this.table.toCharArray();
        // Checa as horizontais
        if (t[0] == 'O' && t[1] == 'O' && t[2] == 'O'
                || t[3] == 'O' && t[4] == 'O' && t[5] == 'O'
                || t[6] == 'O' && t[7] == 'O' && t[8] == 'O') {
            return true;
        }

        // Checa as verticais
        if (t[0] == 'O' && t[3] == 'O' && t[6] == 'O'
                || t[1] == 'O' && t[4] == 'O' && t[7] == 'O'
                || t[2] == 'O' && t[5] == 'O' && t[8] == 'O') {
            return true;
        }

        // Checa as diagonais
        if (t[0] == 'O' && t[4] == 'O' && t[8] == 'O'
                || t[2] == 'O' && t[4] == 'O' && t[6] == 'O') {
            return true;
        }

        return false;
    }

    //Checa se a tabela ainda possui células vazias
    private boolean hasEmptyCells() {

        return this.table.contains("_");
    }

    public GameState getGameState() {

        return gameState;
    }
}
