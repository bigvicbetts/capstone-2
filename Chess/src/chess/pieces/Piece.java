package chess.pieces;

import java.util.ArrayList;

public abstract class Piece {

    String color, symbol;
    EPieceType type;
    int[] position;

    public Piece(String color, EPieceType type, String symbol, int[] position) {
        this.color = color;
        this.type = type;
        this.symbol = symbol;
        this.position = position;
    }

    abstract public ArrayList<int[]> legalMoves();

    public boolean move(int[] userSelection) {
        return false;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getColor() {
        return this.color;
    }

    public EPieceType getType() {
        return this.type;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void changeHasMoved() {

    }
}

