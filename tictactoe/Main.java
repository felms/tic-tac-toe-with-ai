package tictactoe;

import tictactoe.player.*;

import java.util.Scanner;

public class Main {

    static Scanner scanner;

    static Game game;
    static Player player1;
    static Player player2;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        readCommands();

        scanner.close();
    }

    public static void readCommands() {
        String[] parameters;
        boolean exit = false;
        do {
            System.out.print("Input command: ");
            parameters = scanner.nextLine().split("\\s+");
            if (!checkParameters(parameters)) {
                System.out.println("Bad parameters!");
            } else if ("exit".equals(parameters[0])) {
                    exit = true;
            } else {
                initPlayers(parameters);
                play();
            }

        } while(!exit);

    }

    // Joga o Jogo-Da-Velha
    public static void play() {

        game = new Game();
        game.printGrid();
        while(true) {
            Move move;
            do {
                move = player1.getMove(game.getTable());
            } while (!game.makeMove(player1, move));
            System.out.println(player1.getMessage());
            game.printGrid();
            if (game.isTheGameFinished()) {
                break;
            }

            do {
                move = player2.getMove(game.getTable());
            } while (!game.makeMove(player2, move));
            System.out.println(player2.getMessage());
            game.printGrid();
            if (game.isTheGameFinished()) {
                break;
            }
        }
        System.out.println(game.getGameState() + "\n");
    }

    // Inicializa os jogadores 1 e 2
    // de acordo com os parâmetros
    public static void initPlayers(String[] parameters) {

        switch(parameters[1]) {
            case "user":
                player1 = new HumanPlayer('X');
                break;
            case "easy":
                player1 = new ELPlayer('X');
                break;
            case "medium":
                player1 = new MLPlayer('X');
                break;
            case "hard":
                player1 = new HLPlayer('X');
                break;
        }

        switch(parameters[2]) {
            case "user":
                player2 = new HumanPlayer('O');
                break;
            case "easy":
                player2 = new ELPlayer('O');
                break;
            case "medium":
                player2 = new MLPlayer('O');
                break;
            case "hard":
                player2 = new HLPlayer('O');
                break;
        }
    }

    // Checa a validade dos parâmetros
    public static boolean checkParameters(String[] parameters) {

        if (parameters.length == 1 && "exit".equals(parameters[0])) {
            return true;
        }

        if (parameters.length != 3) {
            return false;
        }

        if (!(parameters[0].equals("start") || parameters[0].equals("exit"))) {
            return false;
        }

        if (!(parameters[1].equals("easy")
                || parameters[1].equals("user")
                || parameters[1].equals("medium")
                || parameters[1].equals("hard"))){
            return false;
        }

        if (!(parameters[2].equals("easy")
                || parameters[2].equals("user")
                || parameters[2].equals("medium")
                || parameters[2].equals("hard"))){
            return false;
        }

        return true;
    }

}
