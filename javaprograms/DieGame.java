import java.util.*;
import java.math.*;
public class DieGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter no of players:");
		int noOfPlayers = input.nextInt();
		System.out.println();
		game games;
		for ( int i = 1 ; i <= noOfPlayers; i++) {
			System.out.print("Enter name of player:");
			String playername = input.nextLine();
			System.out.println();
			games = new game(playername);
		}
		for(int j = 1 ;j <= noOfPlayers ; j++)
		{
			int totalScore = games.play(j);
			if(totalScore >=100)
			System.out.println("Congratulations! Player:" +j+ " won the game:");
			break;
		}
	}
}
public class player {
	String name;
	public void player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
public class game {
	ArrayList<player> play= new ArrayList<player>();
	int scoreTotal = 0;
	Random randomNo = new Random();
	Scanner input = new Scanner(System.in);
	public game(String name) {
		play.add(name);
	}
	public int play(int playerNo) {
		int score = randomNo.nextInt(6);
		while(scoreTotal < 100) {
			if(score == 1) {
				System.out.println("Out of Game...!!!");
				break;
			}	
			if(score > 1 && score < 6) {
				scoreTotal = scoreTotal + score;
				play(playerNo);
			}
			if(score == 6) {
				scoreTotal = scoreTotal +score;
				System.out.print("Do you want to continue? (Y/N)");
				char option = input.nextChar();
				if(option == 'Y' || option == 'y') {
					play(playerNo);
				}
				if(option == 'N' || option == 'n') {
					return scoreTotal;
				}
			}
		}
		return scoreTotal;
	}	
}