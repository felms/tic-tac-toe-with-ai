import java.util.Scanner;

public class HumanPlayer implements Player{

    private char playingAs;
    private Scanner scanner;

    public HumanPlayer(char playingAs) {
        this.playingAs = playingAs;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move getMove(String table) {
        int x = -1;
        int y = -1;
        boolean moveCreated = false;
        do {
            System.out.print("Enter the coordinates: ");
            String[] s = scanner.nextLine().split("\\s+");
            try {
                x = Integer.parseInt(s[0]);
                y = Integer.parseInt(s[1]);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    moveCreated = true;
                }

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.out.println("You should enter numbers!");
            }
        } while(!moveCreated);

        return new Move(x, y);
    }

    @Override
    public String getMessage() {
        return "";
    }

    @Override
    public char getPlayingAs() {
        return playingAs;
    }
}
