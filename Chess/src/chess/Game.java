package chess;

import chess.board.Board;

import java.util.ArrayList;

public class Game implements IWatchBoard {

    static Board board = new Board();
    static ArrayList<Player> players = new ArrayList<>();
    Screen screen = new Screen();
    GameController gameController = new GameController();
    private int moves = 0;
    private int currentPlayerIndex;
    private Player activePlayer;

    public Game(String whitePlayer, String blackPlayer) {
        board.addWatcher(this);
        players.add(new Player(whitePlayer, "white"));
        players.add(new Player(blackPlayer, "black"));
        for (Player player : players) {
            player.setBoard();
        }
        screen.boardChanged();
    }

    public boolean startGame() {
        currentPlayerIndex = 0;
        activePlayer = players.get(currentPlayerIndex);

        while (true) {
            System.out.println(activePlayer.name + ", it is your turn.");
            activePlayer.play();
            for (Player player : players) {
                if (player.wins()) {
                    currentPlayerIndex++;
                    activePlayer = players.get(currentPlayerIndex % 2);
                    System.out.println(activePlayer.name + " wins the game!!");
                    return false;
                }
            }
        }
    }

    @Override
    public void boardChanged() {
        moves++;
        currentPlayerIndex = moves % 2;
        activePlayer = Game.players.get(currentPlayerIndex);
    }
}
