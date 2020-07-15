package chess.pieces;

import chess.board.Board;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(String color, EPieceType type, String symbol, int[] position) {
        super(color, type, symbol, position);
    }

    @Override
    public ArrayList<int[]> legalMoves() {
        ArrayList<int[]> legalMoves = new ArrayList<>();

        int col = position[0];
        int row = position[1] + 1;
        while (row <= 8) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
                row++;
            }
            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;

            }
            else break;
        }

        col = position[0];
        row = position[1] - 1;
        while (row >= 1) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
                row--;
            }
            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;
            }
            else break;
        }

        col = position[0] - 1;
        row = position[1];
        while (col >= 1) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
                col--;
            }
            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;
            }
            else break;
        }

        col = position[0] + 1;
        row = position[1];
        while (col <= 8) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
                col++;
            }
            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;
            }
            else break;
        }

        col = position[0] + 1;
        row = position[1] + 1;
        while (col <= 8 && row <= 8) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
            }
            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;
            }
            else break;
            col++;
            row++;
        }

        col = position[0] + 1;
        row = position[1] - 1;
        while (col <= 8 && row >= 1) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
            }
            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;
            }
            else break;
            col++;
            row--;
        }

        col = position[0] - 1;
        row = position[1] - 1;
        while (col >= 1 && row >= 1) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
            }
            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;
            }
            else break;
            col--;
            row--;
        }

        col = position[0] - 1;
        row = position[1] + 1;
        while (col >= 1 && row <= 8) {
            int[] position = {col, row};
            if (Board.getSquarePiece(position) == null) {
                legalMoves.add(position);
            }

            else if (!Board.getSquarePiece(position).getColor().equalsIgnoreCase(color)) {
                legalMoves.add(position);
                break;
            }
            else break;
            col--;
            row++;
        }

        return legalMoves;
    }
}
