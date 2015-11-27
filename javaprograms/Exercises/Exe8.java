import java.util.*;
abstract class AbstractCounter {
	abstract public void click();
	protected int value;
	public int get() {
		return value;
	}
	public void set(int x) {
		value = x;
	}
	public String toString() {
		return String.valueOf(value);
	}
}
class counter extends AbstractCounter {
	public void click() {
		value = (value + 1) % 100;
	}
}
class CountByTwo extends AbstractCounter {
	public void click() {
		value = (value + 2) % 100;
	}
}
class Timer extends AbstractCounter {
	public void click() {
		value++;
	}
	public int hour() {
		return (get()/(60*60));
	}
	public String toString() {
		return (value / 60) + " minutes , " + (value % 60) + " seconds";
	}
}
class Clock extends Timer {
	public Clock(int v) {
		set(v);
	}
	public void click() {
		value++;
	}
	public int hour() {
		return (get()/(60*60));
	}
	public String toString() {
		return (value / 60) + " minutes , " + (value % 60) + " seconds";
	}
}
public class Exe8 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter seconds:");
		int seconds = input.nextInt();
		Clock time = new Clock(seconds);
		System.out.println("Hours:" + time.hour() + " Minutes: " +(time.get()/60)%60 + " Seconds: " + (time.get())%60);
		System.out.println(time);
	}
}