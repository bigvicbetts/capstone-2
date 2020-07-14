package chess.pieces;

import chess.board.Board;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Piece {
    public Knight(String color, EPieceType type, String symbol, int[] position) {
        super(color, type, symbol, position);
    }

    @Override
    public ArrayList<int[]> legalMoves() {
        ArrayList<int[]> legalMoves = new ArrayList<>();

        ArrayList<int[]> possibleMoves = new ArrayList<>(Arrays.asList(
                new int[]{position[0] + 1, position[1] + 2},
                new int[]{position[0] + 1, position[1] - 2},
                new int[]{position[0] - 1, position[1] + 2},
                new int[]{position[0] - 1, position[1] - 2},
                new int[]{position[0] + 2, position[1] + 1},
                new int[]{position[0] + 2, position[1] - 1},
                new int[]{position[0] - 2, position[1] + 1},
                new int[]{position[0] - 2, position[1] - 1}
        ));

        for (int[] move : possibleMoves) {
            if ((move[0] >= 1 && move[0] <= 8) && (move[1] >= 1 && move[1] <= 8)) {
                if (Board.getSquarePiece(move) == null || !Board.getSquarePiece(move).getColor().equalsIgnoreCase(color)) {
                    legalMoves.add(move);
                }
            }
        }
        return legalMoves;
    }
}
