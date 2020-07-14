package chess;

public class Instructions {

    String instructions = "Welcome to Betts Best SECRET Chess\n\n" +
            "1.  This game assumes that the players already know the basics of how to play chess.  If you need to see\n" +
            "    the rules for chess, they are available at https://www.chess.com/learn-how-to-play-chess, but even\n" +
            "    without knowing these rules, you can still participate.  Once a piece is selected, the available moves\n" +
            "    for that piece will appear.  Simply choose one of the spaces shown and your piece will move there.\n" +
            "\n" +
            "2.  Enter the Player names at the prompt.  The first player will play the \"white\" pieces and move first and\n" +
            "    the second player will play the \"black\" pieces and play second.\n" +
            "\n" +
            "3.  Using the keyboard, select one of your pieces to move by it's coordinates.  The coordinates are\n" +
            "    represented by the numbers on the left-hand side of the board and the letters underneath.  Enter\n" +
            "    the coordinates letter-first (i.e. \"a1\" will select the piece at the bottom left-hand corner of the \n" +
            "    board from the \"white\" player's perspective).\n" +
            "    \n" +
            "4.  A list of possible destination spaces for that piece will appear.  These possible moves follow the \n" +
            "    movement rules for the selected piece.  Enter the space you would like to move the piece to.\n" +
            "\n" +
            "5.  After one player's turn is complete, the game will automatically switch control to the other player who\n" +
            "    will then take their turn.\n" +
            "\n" +
            "6.  The game will not check to see if either player is in check or checkmate.  Take the king when your opponent\n" +
            "    is LEAST expecting it.\n\n";

    public Instructions() {
    }

    public void printInstructions() {
        System.out.println(instructions);
    }
}
