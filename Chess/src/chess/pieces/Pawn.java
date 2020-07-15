package chess.pieces;

import chess.board.Board;

import java.util.ArrayList;

public class Pawn extends Piece{

    private boolean hasMoved = false;

    public Pawn(String color, EPieceType type, String symbol, int[] position) {
        super(color, type, symbol, position);
    }

    @Override
    public ArrayList<int[]> legalMoves() {
        //legalMoves.clear();
        ArrayList<int[]> legalMoves = new ArrayList<>();
        if (color.equalsIgnoreCase("white")) {
            if (!hasMoved) {
                int[] move = {position[0], position[1] + 2};
                int[] inBetween = {position[0], position[1] + 1};
                if ((Board.getSquarePiece(move)) == null && (Board.getSquarePiece(inBetween) == null)) {
                    legalMoves.add(move);
                    legalMoves.add(inBetween);
                } else if (Board.getSquarePiece(inBetween) == null) {
                    legalMoves.add(inBetween);
                }
            }
            else {
                int[] move = {position[0], position[1] + 1};
                if (Board.getSquarePiece(move) == null) {
                    legalMoves.add(move);
                }
            }
            int[] move = {position[0] + 1, position[1] + 1};
            if (Board.getSquarePiece(move) != null && !Board.getSquarePiece(move).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(move);
            }
            move = new int[]{position[0] - 1, position[1] + 1};
            if (Board.getSquarePiece(move) != null && !Board.getSquarePiece(move).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(move);
            }
        }

        else {
            if (!hasMoved) {
                int[] move = {position[0], position[1] - 2};
                int[] inBetween = {position[0], position[1] - 1};
                if ((Board.getSquarePiece(move)) == null && (Board.getSquarePiece(inBetween) == null)) {
                    legalMoves.add(move);
                    legalMoves.add(inBetween);
                } else if (Board.getSquarePiece(inBetween) == null) {
                    legalMoves.add(inBetween);
                }
            }
            else {
                int[] move = {position[0], position[1] - 1};
                if (Board.getSquarePiece(move) == null) {
                    legalMoves.add(move);
                }
            }
            int[] move = {position[0] + 1, position[1] - 1};
            if (Board.getSquarePiece(move) != null && !Board.getSquarePiece(move).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(move);
            }
            move = new int[]{position[0] - 1, position[1] - 1};
            if (Board.getSquarePiece(move) != null && !Board.getSquarePiece(move).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(move);
            }

        }
        return legalMoves;
    }

    @Override
    public void changeHasMoved() {
        hasMoved = true;
    }
}
