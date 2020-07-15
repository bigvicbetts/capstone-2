package chess;

public class Screen implements IWatchBoard {

    public Screen() {
        Game.board.addWatcher(this);
    }

    public static void draw() {
        for (int row = 8; row > 0; row--) {
            System.out.print(row + " ");
            for (int col = 1; col <= 8; col++) {
                int[] position = {col, row};
                System.out.print(Game.board.getSquareSymbol(position));
            }
            System.out.println();
        }
        System.out.println("  ABCDEFGH");
        //System.out.println("\033[107mabcdefg \u001B[40m abcdefg ");
    }

    @Override
    public void boardChanged() {
        draw();
    }
}
