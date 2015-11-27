import java.util.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    public static void main(String args[]) {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter no of Students:");
        int noOfStudents = input1.nextInt();
        Student[] detail = new Student[noOfStudents];
        Student s;
        System.out.println();
        for(int i =0;i<noOfStudents ; i++) {
            System.out.print("Enter fname:");
            String fname = input2.nextLine();
            System.out.print("Enter lname:");
            String lname = input2.nextLine();
            System.out.print("Enter College:");
            String college = input2.nextLine();
            System.out.print("Enter fname:");
            int age = input2.nextInt();
            System.out.print("Enter fname:");
            double gpa = input2.nextDouble();
            s=new Student(fname,lname,age,college,gpa);
            detail[i]=s;
        }  
        s.Sort();
        s.Display();
    }    
}
