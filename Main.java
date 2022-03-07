package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the cells: ");
        String input = scanner.nextLine();

        Game game = new Game(input);
        game.printGrid();

        boolean inputOk = false;
        int x = -1;
        int y = -1;
        do {
            System.out.print("Enter the coordinates: ");
            String[] s = scanner.nextLine().split("\\s+");
            try {
                x = Integer.parseInt(s[0]);
                y = Integer.parseInt(s[1]);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (!game.makeMove(x, y)) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        inputOk = true;
                    }
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.out.println("You should enter numbers!");
            }
        } while (!inputOk);

        game.printGrid();
        System.out.println(game.getGameState());
    }
}
