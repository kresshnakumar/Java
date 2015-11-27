import java.util.Random;

public class Dice {

  /*
    This method simulates the behavior of a dice.
    On roll it gives a random number between 1 and 6 (inclusive).
  */
  private static int i = 0;
  public static int roll() {
    if (i == 6) {
    	i = 0;
    }
    int[] randomNum = {1, 2, 3, 4, 5, 6};
    return randomNum[i++];
  }

}