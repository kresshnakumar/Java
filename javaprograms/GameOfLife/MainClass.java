import java.util.Scanner;
class GameOfLife {
	private String[][] currentGen;
	private String[][] nextGen;
	final int size = 5;
	public GameOfLife() {
		currentGen = new String[size][size];
		nextGen = new String[size][size];
		initializeGen();
	}
	private void initializeGen() {
		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j <size ; j++) {
				currentGen[i][j] = ".";
			}
		}
		currentGen[1][2] = "X";
		currentGen[2][2] = "X";
		currentGen[3][2] = "X";
	}
	public String toString(){
		String s = "";
		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j < size ; j++) {
				if (j != size - 1)
					s = s + currentGen[i][j] + "";
				else 
					s = s + currentGen[i][j];
			}
			s = s + "\n";
		}
		return s;
	}
	public void getNextGen() {
		int count1 = 0;
		for(int i = 0 ; i < size ; i++ ) {
			for (int j = 0 ; j < size; j++) {
				count1 = getNeighbourCount(i,j);
				if(count1 == 3)
					nextGen[i][j] = "X";
				else if (count1 == 2 && currentGen[i][j] == "X")
					nextGen[i][j] = "X";
				else
					nextGen[i][j] = ".";				
			}
		}
		swap();
	}
	private String getValue(int i , int j) {
		return currentGen[i][j];
	}
	private void swap() {
		for(int k = 0 ; k < size ; k++ ) {
			for (int l = 0 ; l < size; l++) {
				 currentGen[k][l] = nextGen[k][l];
			}
		}
	}
	private int getNeighbourCount(int i,int j) {
		int count = 0;
		if(i == 0 || j == 0 || i == size - 1 || j == size - 1) {
			return 0;
		}
		for(int k = i - 1 ; k <= i + 1 ; k++ ) {
			for (int l = j - 1 ; l <= j + 1; l++) {
				if(getValue(k,l) == "X") {
					count ++;
				}
			}
		}
		if(getValue(i,j) == "X") {
			count--;
		}
		return count;
	}
}
public class MainClass {
	public static void main(String args[]) {
		int noOfGen = 3;
		GameOfLife gen = new GameOfLife();
		System.out.println(gen);
		for (int i = 1 ; i <= noOfGen ; i++) {
			gen.getNextGen();
			System.out.println(gen);
		}
	}
}