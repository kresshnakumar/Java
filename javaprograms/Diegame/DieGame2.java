import java.util.*;
import java.math.*;
import java.lang.*;
public class DieGame2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			System.out.print("Enter name of player:");
			String playername = input.nextLine();
			System.out.println();
			Game games=new Game(playername);
			int totalScore = games.play();
			if(totalScore >=100)
				System.out.println("Congratulations! Player:" +playername+"won the game:");
			else
				System.out.println("You Lose...");
	}
}
class Game {
	int scoreTotal = 0;
	String names;
	Random randomNo = new Random();
	Scanner input = new Scanner(System.in);
	public Game(String names) {
		this.names = names;
	}
	public int play() {
		int score = randomNo.nextInt(7);
		do {
			//System.out.println("Hello :" + score);
			if(score == 1) {
				System.out.println("Score is: " +scoreTotal);
				System.out.println("Out of Game...!!!");
				break;
			}	
			else if(score > 1 && score < 6 || score == 0) {
				System.out.println("Score is: " +scoreTotal);
				scoreTotal = scoreTotal + score;
				play();
			}
			else if(score == 6) {
				scoreTotal = scoreTotal +score;
				System.out.println("Score is: " +scoreTotal);
				System.out.print("Do you want to continue? (Y/N)");
				char option = input.next().charAt(0);
				if(option == 'Y' || option == 'y') {
					play();
				}
				if(option == 'N' || option == 'n') {
					break;
				}
			}
		}while(scoreTotal < 100);
		return scoreTotal;
	}	
}