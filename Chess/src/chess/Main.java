package chess;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Instructions instructions = new Instructions();
        instructions.printInstructions();

        System.out.print("Enter first player name. Will play white pieces and move first: ");
        String whitePlayer = scanner.nextLine();

        System.out.print("Enter second player name. Will play black pieces and move second: ");
        String blackPlayer = scanner.nextLine();
        Game myGame = new Game(whitePlayer, blackPlayer);

        myGame.startGame();

    }
}
