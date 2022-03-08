public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Player player = new Player('X');
        AIPlayer aiPlayer = new AIPlayer();
        game.printGrid();

        boolean exit = false;
        while (!exit) {
            Move move;
            do {
                move = player.getMove();
            } while (!game.makeMove(player, move));
            game.printGrid();

            if (game.isTheGameFinished()) {
                break;
            }

            System.out.println("Making move level \"easy\"");
            do {
                move = aiPlayer.getMove();
            } while (!game.makeMove(aiPlayer, move));
            game.printGrid();

            if (game.isTheGameFinished()) {
                break;
            }
        }

        System.out.println(game.getGameState());
    }
}
