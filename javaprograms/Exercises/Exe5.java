import java.util.*;
class Person {
  public int age;
  public String gender;
  Person(int age,String gender) {
    this.age = age;
    this.gender = gender;     
  }
}
class Student extends Person{
  public String firstName;
  public String lastName;
  Student(int age,String gender,String firstName,String lastName) {
    super(age,gender);
    this.firstName = firstName;
    this.lastName = lastName;
  }
  public static void sort(Student[] student,int size) {
      Student[] temp = new Student[1];
      for (int i = 0;i < size;i++) {
        for (int j = i+1;j < size;j++) {
          if (((student[i].lastName).compareTo(student[j].lastName)) > 0) {
            temp[0] = student[i];
            student[i] = student[j];
            student[j] = temp[0];
          }
        }
      }  
    }
    
    public static void print(Student[] student,int size) {
      for (int i = 0;i < size;i++) {
        System.out.println("firstname : " + student[i].firstName +
        "\t lastname : " + student[i].lastName +
        "\t age : " + student[i].age +
        "\t Gender : " + student[i].gender);    
      }
    }
}
public class Exe5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    System.out.println("Enter how many students you want to enter");
    int size = s.nextInt();
    Student[] student = new Student[size];
    int index = 0;
    String temp = " ";
    while (index != size) {
      System.out.println("Enter the first name");
      String firstName = sc.nextLine();
      System.out.println("Enter the last name");
      String lastName = sc.nextLine();
      System.out.println("Enter the age");
      int age = s.nextInt();
      System.out.println("Enter the gender");
      String gender = sc.nextLine(); 
      student[index] = new Student(age,gender,firstName,lastName);
      index++;
    }
    student[0].sort(student,size);
    student[0].print(student,size);
  }
}