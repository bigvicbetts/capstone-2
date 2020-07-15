package chess.board;

import chess.pieces.Piece;

public class Square {

    private String symbol;
    private int[] position;
    private Piece occupyingPiece = null;

    Square(int[] position) {
        this.symbol = (position[0] % 2 == position[1] % 2) ? "\u25A0" : "\u25A1";
        this.position = position;
    }

    public String getSymbol() {
        return symbol;
    }

    public int[] getPosition() {
        return position;
    }

    public Piece getOccupyingPiece() {
        return occupyingPiece;
    }

    public void addPiece(Piece occupyingPiece) {
        this.occupyingPiece = occupyingPiece;
        this.symbol = occupyingPiece.getSymbol();
    }

    public void removePiece() {
        this.occupyingPiece = null;
        this.symbol = (position[0] % 2 == position[1] % 2) ? "\u25A0" : "\u25A1";
    }
}

