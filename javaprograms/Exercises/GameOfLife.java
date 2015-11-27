import java.util.Scanner;

class GameOfLife {
	private String currentGen[][];
	private String nextGen[][];
	public GameOfLife() {
		currentGen[][] = new Strring[size][size];
		nextGen[][] = new String[size][size];
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
			for (int j = 0 ; j <size ; j++) {
				if(j != size-1)
					s = s + currentGen[i][j] + " ";
				else 
					s = s + currentGen[i][j];
			}
			System.out.println();
		}
		return s;
	}
}
public class MainClass() {
	public static void main(String args[]) {
		GameOfLife gen = new GameOfLife();
		System.out.println(gen);
	}
}