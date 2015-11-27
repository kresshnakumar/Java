//PredatorPrey.java - top level class
import java.util.*;
class PredatorPrey {
	public static void main(String[] args) {
		World odd = new World(10), even = new World(10);
		int i, cycles = 10;
		even.eden();
		//generate initial World
		System.out.println(even); //print initial state
		for (i = 0; i < cycles; i++) {
			System.out.println("Cycle = " + i + "\n\n");
			if (i % 2 == 1) {
				even.update(odd);
				System.out.println(even);
			}
			else {
				odd.update(even);
				System.out.println(odd);
			}
		}
	}
}
//World.java - square grid of life form cells
class World {
	Living[][] cells;
	private int size;
	//set in constructor
	World(int n) {
		size = n;
		cells = new Living[n][n];
		for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			cells[i][j] = new Empty(i,j);
	}
	public void clearNeighborCounts() {
		Fox.neighborCount.set(0);
		Rabbit.neighborCount.set(0);
		Grass.neighborCount.set(0);
		Empty.neighborCount.set(0);
	}
	void eden() { // left as an excercise 
		for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
		{
		   	Random object = new Random();
			int var = object.nextInt(4);
		   	if(var == 0)
				cells[i][j] = new Empty(i,j);
		   	if(var == 1)
		    	cells[i][j] = new Grass(i,j);
		    if(var == 2)
		    	cells[i][j] = new Rabbit(i,j,0);
		    if(var == 3)
		    	cells[i][j] = new Fox(i,j,0);
		}		 
	}
	public String toString() { // left as an excercise 
		String aString = "";
		for (int i = 0; i < size; i++) { 
		for (int j = 0; j < size; j++) {
			if(j != size-1)
				aString =  aString + cells[i][j].toChar() + " ";
			else
				aString = aString + cells[i][j].toChar();
		}
		aString = aString + "\n";

	}
		return aString ;
	}
	public void update(World oldWorld) {
		//borders are taboo
		for (int i = 1; i < size - 1; i++) 
		for (int j = 1; j < size - 1; j++)
			cells[i][j] = oldWorld.cells[i][j].next(oldWorld);
	}
}
//Living.java - the superclass for all life forms
abstract class Living {
	int row, column; //location
	abstract Count getCount();
	abstract Living next(World world);
	abstract char toChar(); // character for this form
	void computeNeighbors(World world) { 
		world.clearNeighborCounts();
		world.cells[row][column].getCount().set(-1);
		for (int i = -1; i <= 1; i++)
		for (int j = -1; j <= 1; j++)
			world.cells[row+i][column+j].getCount().inc();
	}
}
class Count {
	private int count;
	public Count() {
		count = 0;
	}
	public void set(int c) {
		count = c;
	}
	public int get() {
		return count;
	}
	public void inc() {
		count++;
	}
}
//Fox.java - prey class
class Fox extends Living {
	static Count neighborCount = new Count();
	private int age;
	private final int LIFE_EXPECTANCY = 5;
	Fox(int r, int c, int a ) { 
		row = r; 
		column = c; 
		age = a;
	}
	Living next(World world) {
		computeNeighbors(world);
		if (Fox.neighborCount.get() > 5 )
			//too many Foxes
			return new Empty(row, column);
		else if (age > LIFE_EXPECTANCY)
			//Fox is too old
			return new Empty(row, column);
		else if (Rabbit.neighborCount.get() == 0)
			return new Empty(row, column);
		// starved
		else
			return new Fox(row, column, age + 1);
	}
	public String toString(){ 
		return "Fox age " + age; 
	}
	char toChar() {
		return 'F'; 
	}
	Count getCount() {
		return neighborCount;
	}
}
//Rabbit.java - prey class
class Rabbit extends Living {
	static Count neighborCount = new Count();
	private int age;
	private final int LIFE_EXPECTANCY = 3;
	Rabbit(int r, int c, int a ) { 
		row = r; 
		column = c; 
		age = a;
	}
	Living next(World world) {
		computeNeighbors(world);
		if (Fox.neighborCount.get() >= Rabbit.neighborCount.get() )
			return (new Empty(row, column));
		// eat Rabbits
		else if (age > LIFE_EXPECTANCY)
			return (new Empty(row, column));
		// too old
		else if (Grass.neighborCount.get() == 0)
			return (new Empty(row, column));
		// starved
		else
			return (new Rabbit(row, column, age + 1));
	}
	public String toString() {
		return "Rabbit age " + age;
	}
	char toChar() { 
		return 'R'; 
	}
	Count getCount() {
		return neighborCount; 
	}
}
//Grass.java - something for the rabbits to eat
class Grass extends Living {
	static Count neighborCount = new Count();
	public Grass(int r, int c) { 
		row = r; 
		column = c; 
	}
	public Living next(World world) {
		computeNeighbors(world);
		if (Grass.neighborCount.get() > 2*Rabbit.neighborCount.get())
			// rabbits move in to eat the grass
			return (new Rabbit(row, column, 0));
		else if (Grass.neighborCount.get() > Rabbit.neighborCount.get())
			// grass remains
			return (new Grass(row, column));
		else
			// rabbits eat all the grass
			return (new Empty(row, column));
	}
	public String toString() { 
		return "Grass"; 
	}
	char toChar() { 
		return 'G'; 
	}
	Count getCount() {
		return neighborCount; 
	}	
}
//Empty.java - representation of an empty cell
class Empty extends Living {
	static Count neighborCount = new Count();
	Empty(int r, int c) { 
		row = r; 
		column = c; 
	}
	Living next(World world) {
		computeNeighbors(world);
		if (Rabbit.neighborCount.get() > 2)
			return (new Fox(row, column, 0));
		else if (Grass.neighborCount.get() > 4)
			return (new Rabbit(row, column, 0));
		else if (Grass.neighborCount.get() > 0)
			return (new Grass(row, column));
		else
			return (new Empty(row, column));
	}
	public String toString() { 
		return "."; 
	}
	char toChar() { 
		return '.'; 
	}
	Count getCount() {
		return neighborCount; 
	}
}
