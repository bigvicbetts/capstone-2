package chess.board;

import chess.IWatchBoard;
import chess.pieces.EPieceType;
import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Board {

    static ArrayList<Square> squares = new ArrayList<Square>();
    public static ArrayList<Piece> pieces = new ArrayList<Piece>();
    static HashSet<IWatchBoard> watchers = new HashSet<>();

    public Board() {
        for (int row = 1; row <= 8; row++) {
            for (int col = 1; col <= 8; col++) {
                int[] position = {row, col};
                squares.add(new Square(position));
            }
        }
    }

    public static String getSquareSymbol(int[] position) {
        for (Square square : squares) {
            if (Arrays.equals(square.getPosition(), position)) {
                return square.getSymbol();
            }
        }
        return null;
    }

    public static Piece getSquarePiece(int[] position) {
        for (Square square : squares) {
            if (Arrays.equals(square.getPosition(), position)) {
                return square.getOccupyingPiece();
            }
        }
        return null;
    }

    public static void setPieceOnSquare(int[] position, Piece piece) {
        for (Square square : squares) {
            if (Arrays.equals(square.getPosition(), position)) {
                square.addPiece(piece);
            }
        }
    }

    public static void processMove(int[] startSpace, int[] endSpace, Piece piece) {
        if (piece.getType().equals(EPieceType.Pawn)) {
            piece.changeHasMoved();
        }
        for (Square square : squares) {
            if (Arrays.equals(square.getPosition(), startSpace)) {
                square.removePiece();
            }
            if (Arrays.equals(square.getPosition(), endSpace)) {
                square.addPiece(piece);
            }
        }
        for (IWatchBoard watcher : watchers) {
            watcher.boardChanged();
        }
    }

    public void removeWatcher(IWatchBoard watcher) {
        watchers.remove(watcher);
    }

    public void addWatcher(IWatchBoard watcher) {
        watchers.add(watcher);
    }
}
