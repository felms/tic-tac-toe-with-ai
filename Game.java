public class Game {

    private String table;
    private GameState gameState;
    private char player;

    public Game() {
        this.table = "_________";
        this.player = 'X';
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

    // Faz uma jogada
    // retorna falso se a jogada
    // não pude ser feita (célula ocupada)
    public boolean makeMove(int x, int y) {

        int inputX = (x - 1) * 3;
        int intputY = y - 1;
        int pos = inputX + intputY;

        if (this.table.charAt(pos) != '_') {
            return false;
        }

        StringBuilder sb = new StringBuilder(this.table);
        sb.setCharAt(pos, this.player);

        this.table = sb.toString();

        this.player = this.player == 'X' ? 'O' : 'X';

        this.gameState = analizeGame();

        return true;
    }

    // Retorna o estado atual do jogo.
    private GameState analizeGame() {

        int countX = 0;
        int countO = 0;
        for (int i = 0; i < this.table.length(); i++) {
            if (this.table.charAt(i) == 'X') {
                countX++;
            } else if (this.table.charAt(i) == 'O') {
                countO++;
            }
        }

        if (countX > countO) {
            this.player = 'O';
        } else {
            this.player = 'X';
        }

        if (!this.hasEmptyCells() && !this.hasThreeXs() && !this.hasThreeOs()) {
            return GameState.DRAW;
        } else if (this.hasThreeXs()) {
            return GameState.X_WINS;
        } else if (this.hasThreeOs()) {
            return GameState.O_WINS;
        }

        return GameState.GAME_NOT_FINISHED;
    }

    // Checa se existem três 'X' em sequencia
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
