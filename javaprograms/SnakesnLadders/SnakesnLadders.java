/*

Write a Java program to simulate a game of Snakes and Ladders.
If you have not played the game before then you should read 
https://en.wikipedia.org/wiki/Snakes_and_Ladders

Game Rules:

1. Need a board with numbers from 1 to 100 with 5 to 7 snakes and 5 to 7 ladders.
2. Two or more players.
3. A fair Dice that randomly gives a number between 1 to 6 (inclusive).
4. A player begins at position 0 and moves to the next position based on the outcome of the dice.
5. If the new position is a ladder the player progresses to the next higher position indicated by the ladder.
6. If the new position is a snake the player goes down to the lower position indicated by the snake.
7. The next player takes turn and goes through the steps 3 to 6.
8. The game is played until one of the players reach the position 100.

*/
public class SnakesnLadders {
  public static void main(String[] args) {
    /* 
      Create a new game board. The game board has the details of snakes and ladders and the players.
    */
    Board board = new Board();

    /*
      Method for adding a ladder to the game board.
      First argument is the start position of the ladder.
      Second argument is the end position of the ladder.
      start position should be less than end position.
      There should not be more than 7 ladders.
      The start and end position of ladder should not conflict with the start and end position of a snake.

      Return true if the ladder is added to the board.
      On error return false.
    */
    board.addLadder(5, 26);
    board.addLadder(14, 39);
    board.addLadder(32, 64);
    board.addLadder(52, 90);
    board.addLadder(68, 77);

    /*
      Method for adding a snake to the game board.
      First argument is the start position of the snake.
      Second argument is the end position of the snake.
      start position should be greater than end position.
      There should not be more than 7 ladders.
      The start and end position of ladder should not conflict with the start and end position of a ladder.

      Return true if the snake is added to the board.
      On error return false.
    */
    board.addSnake(25, 1);
    board.addSnake(45, 19);
    board.addSnake(54, 24);
    board.addSnake(75, 42);
    board.addSnake(86, 35);

    /*
      A player object represents one player in the game.
      Feel free to add any properties that you find useful to the player object.
      For example, you may want to set the player's position on the board during the game.
    */
    Player p1 = new Player("A");
    Player p2 = new Player("B");
    Player p3 = new Player("C");

    /*
      The addPlayer method should add the players to the board
      The players will take turns to play in the order in which they are added to the board.
    */
    board.addPlayer(p1);
    board.addPlayer(p2);
    board.addPlayer(p3);

    /*
      The startGame method starts the game based on the rules given at the begining.
      When the first player reaches 100 the game ends.
      A Dice class with a static method named roll is provided.
      You can call the roll method using the class name: Dice.roll()
      The Dice class returns an int which is between 1 to 6.
      
      At the end of the game, set the winning player to a class variable.
      This would help the next method getWinner()

      Make sure the game begins only when
        1. There are more than 2 players
        2. There are between 5 to 7 snakes and ladders

      Return false if the game cannot be started.
      Return true after the game completes.
    */
    board.startGame();

    /*
      The getWinner returns the object of the player who wins the game.
      If the game is not done, it returns a null.
    */
    Player winner = board.getWinner();
    System.out.println("The winner is: " + winner);
  }
}