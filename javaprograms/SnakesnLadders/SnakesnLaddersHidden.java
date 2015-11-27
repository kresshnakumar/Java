public class SnakesnLaddersHidden {
  public static void main(String[] args) {
    String testPassed= "";
    int score = 0;
    // Test Case 1.
    Board board = new Board();

    board.addLadder(11, 52);
    board.addLadder(21, 31);
    board.addLadder(31, 70);
    board.addLadder(41, 90);
    board.addLadder(51, 77);

    board.addSnake(95, 10);
    board.addSnake(85, 21);
    board.addSnake(75, 6);
    board.addSnake(65, 42);
    board.addSnake(55, 25);

    Player p1 = new Player("A");
    Player p2 = new Player("B");
    Player p3 = new Player("C");
    
    board.addPlayer(p1);
    board.addPlayer(p2);
    board.addPlayer(p3);
 
    board.startGame();
    Player winner = board.getWinner();
    System.out.println("TC1:" + winner);

    if (winner == p3) {
      testPassed = "TC1: Passed; ";
      score++;
    } else {
      testPassed = "TC1: Failed; ";   
    }


    board = new Board();

    board.addLadder(11, 52);
    board.addLadder(21, 31);
    board.addLadder(31, 70);
    board.addLadder(41, 90);
    board.addLadder(51, 77);

    board.addSnake(95, 10);
    board.addSnake(85, 21);
    board.addSnake(75, 6);
    board.addSnake(65, 42);
    board.addSnake(55, 25);

    p1 = new Player("A");
    p2 = new Player("B");
    p3 = new Player("C");
    Player p4 = new Player("D");
    Player p5 = new Player("E");
    Player p6 = new Player("F");

    board.addPlayer(p1);
    board.addPlayer(p2);
    board.addPlayer(p3);
    board.addPlayer(p4);
    board.addPlayer(p5);

    board.startGame();
    winner = board.getWinner();
    System.out.println("TC3: " + winner);
    
    if (winner == p1) {
      testPassed += "TC2: Passed; ";
      score++;
    } else {
      testPassed += "TC2: Failed; ";  
    }

    testPassed += "Score: " + score;
    System.out.println(testPassed);
  }
}