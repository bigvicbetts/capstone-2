package chess;

import chess.board.Board;
import chess.pieces.EPieceType;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Player {

    String name;
    String color;
    ArrayList<Piece> pieces;
    boolean wins = false;
    public static Piece destinationSpace;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void setBoard() {
        for (int col = 1; col <= 8; col++) {
            if (color.equalsIgnoreCase("white")) {
                for (int row = 1; row <= 2; row++) {
                    int[] position = {col, row};
                    if (row == 2) {
                        Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Pawn, position));
                    } else {
                        if (col == 1 || col == 8) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Rook, position));
                        } else if (col == 2 || col == 7) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Knight, position));
                        } else if (col == 3 || col == 6) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Bishop, position));
                        } else if (col == 4) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Queen, position));
                        } else {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.King, position));
                        }
                    }
                }
                int[] position = {col, 2};
            } else if (color.equalsIgnoreCase("black")) {
                for (int row = 7; row <= 8; row++) {
                    int[] position = {col, row};
                    if (row == 7) {
                        Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Pawn, position));
                    } else {
                        if (col == 1 || col == 8) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Rook, position));
                        } else if (col == 2 || col == 7) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Knight, position));
                        } else if (col == 3 || col == 6) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Bishop, position));
                        } else if (col == 4) {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.Queen, position));
                        } else {
                            Board.setPieceOnSquare(position, chess.pieces.PieceFactory.createPiece(color, EPieceType.King, position));
                        }
                    }
                }
            }
        }
    }

    public boolean play() {

        Function<String, Boolean> invalidSelection = (String message) -> {
            Screen.draw();
            System.out.println(message);
            play();
            return false;
        };

        int[] startSquare = getInput(name + ", Select the piece you would like to move: ");
        Piece selectedPiece = Board.getSquarePiece(startSquare);
        while (selectedPiece != null && selectedPiece.getColor().equalsIgnoreCase(color)) {
            while (selectedPiece.legalMoves().size() > 0) {
            for (int[] position : selectedPiece.legalMoves()) {
                Character firstPosition = (char)(position[0] + 96);
                int secondPosition = position[1];
                System.out.println(firstPosition.toString() + secondPosition);
            }
            int[] endSquare = getInput("Select square to move " + selectedPiece.getSymbol() + " to: ");
            destinationSpace = Board.getSquarePiece(endSquare);
                while (!selectedPiece.legalMoves().stream().anyMatch(move -> Arrays.equals(move, endSquare))) {
                    Screen.draw();
                    System.out.println("That is not a valid move for your piece");
                    play();
                    return false;
                }
                if (destinationSpace != null) {
                    if (destinationSpace.getType().equals(EPieceType.King)) {
                        wins = true;
                    }
                    Board.pieces.remove(destinationSpace);
                    Board.processMove(startSquare, endSquare, selectedPiece);
                    selectedPiece.setPosition(endSquare);
                    selectedPiece.legalMoves().clear();
                    return true;
                }
                else {
                    Board.processMove(startSquare, endSquare, selectedPiece);
                    selectedPiece.setPosition(endSquare);
                    selectedPiece.legalMoves().clear();
                    return true;
                }
            }
            return invalidSelection.apply("That piece has no legal moves.");
        }
        return invalidSelection.apply("You must select your own piece.");
    }

    private static int[] getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int[] userSelection = null;
        String choice = scanner.nextLine();
        String[] splitChoice = choice.split("");
        char col = choice.toLowerCase().charAt(0);
        char row = choice.charAt(1);
        int colSelection = col - 96;
        int rowSelection = row - 48;
        while (!validSelection(choice, colSelection, rowSelection)) {
            System.out.println("Invalid selection.  Please try again.");
            Screen.draw();
            getInput(message);
            break;
        }
        userSelection = new int[]{colSelection, rowSelection};
        return userSelection;
    }

    private static boolean validSelection(String choice, int colSelection, int rowSelection) {
        if (choice.length() < 3 && choice.length() > 0) {
            if (colSelection < 9 && rowSelection < 9) {
                return true;
            }
        }
        return false;
    }

    public boolean wins() {
        return this.wins;
    }
}