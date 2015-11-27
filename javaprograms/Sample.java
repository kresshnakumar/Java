import java.io.*;

public class Sample {
	public static void main(String args[]) {
		for(int i=0;i < 256 ; i++) {
			int k=i;
			char ch = (char)i;
			System.out.println(k +"-"+ch);
		}
	}
}