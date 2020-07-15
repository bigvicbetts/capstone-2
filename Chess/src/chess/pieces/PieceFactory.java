package chess.pieces;

public class PieceFactory {

    private static int[] position;

    public static Piece createPiece(String color, EPieceType type, int[] position) {
        switch(type) {
            case Bishop:
                return new Bishop(color, EPieceType.Bishop, color.equals("white") ? "\u2657" : "\u265D", position);

            case Rook:
                return new Rook(color, EPieceType.Rook, color.equals("white") ? "\u2656" : "\u265C", position);

            case Pawn:
                return new Pawn(color, EPieceType.Pawn, color.equals("white") ? "\u2659" : "\u265F", position);

            case Knight:
                return new Knight(color, EPieceType.Knight, color.equals("white") ? "\u2658" : "\u265E", position);

            case Queen:
                return new Queen(color, EPieceType.Queen, color.equals("white") ? "\u2655" : "\u265B", position);

            case King:
                return new King(color, EPieceType.King, color.equals("white") ? "\u2654" : "\u265A", position);
        }
        return null;
    }
}
