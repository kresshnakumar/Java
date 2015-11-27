import java.util.ArrayList;
class Board {
	ArrayList<int[]> ladder = new ArrayList<int[]>();
	ArrayList<int[]> snake = new ArrayList<int[]>();
	ArrayList<Player> player = new ArrayList<Player>();
	private Player p;
	private int count1 = 0;
	private int count2 = 0;
	public Board() {}
	public boolean addLadder(int start, int end) {
		if(start != end) {
			if(count1 <= 6 ) {
				if(count1 == 0) {
					int[] temp = {start, end};
					ladder.add(temp);
					count1++;
					return true;
				}
				int flag = 0;
				for(int i = 0 ; i < ladder.size() ; i++ ) {
					for(int j = 0 ; j < 2 ; j++) {
						if(ladder.get(i)[j] == start || ladder.get(i)[j] == end) {
							return false;
						}
					}
				}
				for(int i = 0 ; i < snake.size() ; i++ ) {
					for(int j = 0 ; j < 2 ; j++) {
						if(snake.get(i)[j] == start || snake.get(i)[j] == end) {
							return false;
						}
					}
				}
				if(flag == 0) {
					int[] temp = {start, end};
					ladder.add(temp);
					count1++;
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public boolean addSnake(int start, int end) {
		if(start != end) {
			if(count2 <= 6 ) {
				if(count2 == 0) {
					int[] temp = {start, end};
					snake.add(temp);
					count2++;
					return true;
				}
				for(int i = 0 ; i < ladder.size() ; i++ ) {
					for(int j = 0 ; j < 2 ; j++) {
						if(ladder.get(i)[j] == start || ladder.get(i)[j] == end) {
							return false;
						}
					}
				}
				for(int i = 0 ; i < snake.size() ; i++ ) {
					for(int j = 0 ; j < 2 ; j++) {
						if(snake.get(i)[j] == start || snake.get(i)[j] == end) {
							return false;
						}
					}
				}
				int[] temp = {start, end};
				snake.add(temp);
				count2++;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public void addPlayer(Player p) {
		player.add(p);
	}
	public boolean startGame() {
		int condition = 1;
		//System.out.println("P :" +player.size() +"L: "+ ladder.size() +"S: "+ snake.size());
		if((player.size() > 2) && (ladder.size() >= 5) && (snake.size() >= 5) ) {
			//System.out.println("hello..........");
			while(condition == 1) {
				for(int index = 0 ; index < player.size() ; index++ ) {
					//System.out.println("\n" + player.get(index).getName());
					int diceRoll = Dice.roll();
					diceRoll = diceRoll + player.get(index).getScore();
					if(diceRoll == 100) {
						player.get(index).setScore(diceRoll);
						//System.out.print("\t" +diceRoll);
						p = new Player(player.get(index).getName());
						condition = 0;
						return true;
					}
					else if(diceRoll > 100) {
						break;
					}
					else {
						int flag = 0;
						for(int i = 0 ; i < ladder.size() ; i++) {
							if(diceRoll == ladder.get(i)[0]) {
								player.get(index).setScore(ladder.get(i)[1]);
								flag++;
							}
						}
						if(flag == 0) {
							for(int i = 0 ; i < snake.size() ; i++ ) {
								if(diceRoll == snake.get(i)[0]) {
									player.get(index).setScore(snake.get(i)[1]);
									flag++;
								}
							}
							if(flag == 0) {
								player.get(index).setScore(diceRoll);
							}
						}
					}
				}
			}
		}
		else {
			return false;
		}
		return false;
	}
	public Player getWinner() {
		return p;
	}
}