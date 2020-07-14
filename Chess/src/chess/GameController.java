package chess;

public class GameController implements IWatchBoard {

    private int moves = 0;
    private int currentPlayerIndex = 0;
    private Player activePlayer;

    public GameController() {
        Game.board.addWatcher(this);
    }

    @Override
    public void boardChanged() {
        moves++;
        currentPlayerIndex = moves % 2;
        activePlayer = Game.players.get(currentPlayerIndex);
    }

    public boolean runGame() {
        activePlayer = Game.players.get(currentPlayerIndex);
        System.out.println(activePlayer.name + ", it is your turn.");
        activePlayer.play();
        return true;
    }
}
