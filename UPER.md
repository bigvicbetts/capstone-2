<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* The problem is to create a 2-player chess game.  The game will have a very simple
* UI allowing the player to select the board position of the piece that they wish
* to move and then select the position of the space to which they want to move the
* selected piece.  The move will then be checked to see if it is valid and, if so, 
* the move will be processed.  If the move is invalid, the player will be notified
* and asked to enter a different move.  The game will not evaluate whether a player
* is in check or checkmate.  It will evaluate whether a the requested piece belongs to the
* player whose turn it is, whether the destination space (1) falls within the movement
* rules for that piece and (2) is either unoccupied or occupied by a piece belonging 
* to the opponent.  If either of the above conditions are not met, the move will be 
* ruled invalid and the player will be asked to submit another move.  It will be left
* up to the players to inform each other of check or checkmate.
<h2>
    2. Planning the Solution
</h2>
* I plan to have a Player class that holds the player name and the piece color for that
* player.  I will create an IMoveable interface that will contain a single void method
* called move.  It will be implemented by an abstract Piece class which will, in turn, be
* extended by classes representing each type of chess piece on the board (i.e. bishop, rook, 
* Queen, King, etc).  Each instance of these pieces will have color, position, and rules attributes
* that will be used to determine if their moves are valid.  They will also interact with the
* Board class which will contain instances of Square classes.  These squares will have position
* and occupied attributes that will be used when determining whether moves are valid.  The Game
* class will be the primary class for UI.  It will contain two instances of Player as well as
* one instance of Board and all of the pieces that populate that board.
<h2>
    3. Executing the Plan
</h2>
* 1.  Get board to render without pieces (only showing the squares of alternating color)
* 2.  Create the Piece abstract class and the individual piece subclasses.  At this point, 
*     the only subclass attributes I'm worried about are the position and the symbol.  Get
*     the board to render either the empty squares OR the Piece symbols (depending on whether)
*     whether or not the space is occupied.
* 3.  Allow the user to select a piece and move it to any point on the board.  The purpose here
*     is to get the piece's position to update correctly and for the board to re-render based on
*     the piece's new position.  This will also begin implementing error-checking (to make sure 
*     that (1) the input is formatted correcctly and (2) that the space selected first is, in fact,
*     occupied by a piece).
* 4.  Implement the movement rules to limit where selected pieces can move.  This will limit the individual
*     to their own appropriate movement rules.
* 5.  Create Player class and allow player to enter name.  Assign the first player to "white" pieces
*     and the second player to the "black" pieces.
* 6.  Refactor the movement method to ensure that (1) the Player can move only pieces of his assigned
*     color and (2) that, if the destination square is already occupied by a piece, that piece is NOT
*     of the Player's assigned color.  If the player attempts to either move a piece belonging to the
*     Player or to move his piece to a space occupied by another one of his own pieces, the game will
*     inform him and disallow the move.
* 7.  Get the game to change players after each successful turn.
* 8.  Have the game remove captured pieces from the game board (and from the list of pieces on the board).
* 9.  Create Screen and Square classes.  The Screen class will be in charge ONLY of displaying the board.
*     The Square class keeps track of what piece is currently occupying it.  This makes it so that each
*     piece can now have, and show, a list of possible moves.  It makes it much easier for beginners and,
*     later on, can help create a Computer opponent for a 1-player game.
*
<h2>
    4. Reflection / Refactor
</h2>
* 1.  (Based on Executing the Plan #2) I had to move the loop iterating through the squares to the 
*     BOTTOM of the board-creation while loop to all the pieces to appear.  I'm fuzzy about why this
*     was, but it worked so I'm gonna go with it.
* 2.  (Based on Executing the Plan # 5) I decided that having an abstract class inherit from an interface
*     was cheating, just to have some way to meet both of the requirements.  After thinking if over, I 
*     decided that the better option was to have my Piece class be an abstract parent to all of it's 
*     subclasses (as planned), but I would use my interface to for my Player class.  So now, I have Player
*     implementing my IPlayer interface.
* 3.  I decided that a Square class was not necessary at this point.  I could see how it might be helpful
*     if I had more time to implement it, but for this game, I'll leave it out.
* 4.  After help from Craig and Abram, I decided to go ahead and completely refactor my game.  I did create
*     a Square class that can show which piece, if any, is occupying it.  It has given me the ability to 
*     display a list of valid moves for each piece when selected.
*
*
*
*
*
*