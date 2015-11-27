import java.util.*;
public class DieGame
{
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner it=new Scanner(System.in);
        int totalScore = 0;
        int i;
        Game games=new Game();
        System.out.print("Enter no of players:");
        int noOfPlayers = it.nextInt();
		for(i = 0 ; i<noOfPlayers ; i++) {
		    System.out.print("Enter name of player:");
		    String playerName = input.nextLine();
            System.out.println();
            games.addPlayer(playerName);
        }
        while(totalScore<50) {
            for(i=0;i<noOfPlayers;i++) {
                totalScore = games.play(i);
                if(totalScore>=50)
                    break;
            }
        }
   }
}   
class Game
{
    // instance variables - replace the example below with your own
    ArrayList<Player> play;
    int scoreTotal = 0;
    public Game() {
        play = new ArrayList<Player>();
    }
    public void addPlayer(String names) {
        play.add(new Player(names));
    }
    public int play(int index) {
    int score;
        do {
            Random randomNo = new Random();
            score = (randomNo.nextInt(6)+1);
            if(score == 1) {
                System.out.println(play.get(index).getName()+ " Score is: " +scoreTotal);
                scoreTotal = 0;
                play.get(index).setScore(scoreTotal);
                System.out.println("\n----------Chance to next player----------\n");
                break;
            }   
            else if(score > 1 && score < 6 ) {
                scoreTotal = scoreTotal + score;
                play.get(index).setScore(scoreTotal);
                System.out.println(play.get(index).getName()+ " Score is: " +scoreTotal);
            }
            else if(score == 6) {
                scoreTotal = scoreTotal + score;
                play.get(index).setScore(scoreTotal);
                System.out.println(play.get(index).getName()+ " Score is: " +scoreTotal);
                System.out.print("Do you want to continue? (Y/N)");
                Scanner input = new Scanner(System.in);
                char option = input.next().charAt(0);
                if(option == 'Y' || option == 'y') {
                    continue;
                }
                if(option == 'N' || option == 'n') {
                    System.out.println("\n----------Chance to next player----------\n");
                    break;
                }
            }
        }while(scoreTotal < 50);
        if(scoreTotal >= 50){
            System.out.println("Congratulations! " + play.get(index).getName()+ " won the game.....");
        } 
        return scoreTotal;
    }
}
class Player
{
   private String name;
   private int score;
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    public String getName(){
        return name;
    }
    public void setScore(int score)
    {
        this.score=score;
    }
    public int getScore()
    {
        return score;
    }
}