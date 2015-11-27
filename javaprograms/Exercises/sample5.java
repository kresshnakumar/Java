import java.util.*;
class Person {
    private String fname;
    private String lname;
    private int age;
    private Gender gender;
    public static enum Gender {M,F,D};
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setName(String fname,String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    public String getFName() {
        return this.fname;
    }
    public String getLName() {
        return this.lname;
    }
    public int getAge() {
        return this.age;
    }
    public Gender getGender() {
        return this.gender;
    }
    public String toString() {
        return "F Name :"+fname+"\tAge :"+age+"\tGender :" +gender;
    }
}
class Student extends Person {
    private String college;
    private double gpa;
    //public static enum YearInSchool {frosh,sophomore, junior, senior}
    //private YearInSchool year;
    public Student(String fname,String lname,int age,String college) {
        super.setName(fname,lname);
        super.setAge(age);
        this.college = college;
        //year = YearInSchool.frosh;
    }
    public String getCollege() {
        return college;
    }
    public double getGpa() {
        return gpa;
    }
    /*public YearInSchool getYear() {
        return year;
    }*/
    public String toString() {
        return super.toString()+"\n" + " College :" + college ;
    }
}
class StudentDetails {
    ArrayList<Student> student;
    private String fname;
    private String lname;
    private String college;
    private int age;
    public StudentDetails() {
        student = new ArrayList<Student>();
    }
    //private String year;
    public void addStudent(String fname,String lname,int age,String college) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.college = college;
        student.add(new Student(fname,lname,age,college));
    }
    public void Sort() {
        System.out.println("  Hello ");
        for(int i = 0 ; i <student.size(); i++) {
            int j;
            int k;
            String temp1;
            String temp2;
            temp1 = student.get(i).getLName();

            System.out.println("  Hello 1");
            for(j = 1; j<student.size() ; j++) {
                System.out.println("  Hello 2");
                temp2 = student.get(j).getLName();
                if(temp1.compareTo(temp2) < 0) {
                    continue;
                }
                else if(student.get(i).getLName().compareTo(student.get(j).getLName()) < 0) {
                    ystem.out.println("  Hello 3");
                    temp1 = temp2;
                }
            }
            for(k = 0 ; k < student.size() ; k++) {
                if(temp1.compareTo(student.get(k).getLName()) == 0) {
                    break;
                }
            }
            if(i < k)
            {
               
               
            }
        }
    }
    public void Show() {
        for(Student temp : student) {
            System.out.println("First Name:" + temp.getFName() +"\tLast Name :" + temp.getLName());
            System.out.println("Age is :" + temp.getAge());
            System.out.println("College :" + temp.getCollege());
        }
    }
}
public class Exe5
{
    public static void main(String args[])
    {
        StudentDetails stud = new StudentDetails();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        char ch;
        do {
            System.out.println("Enter First name:");
            String fname=input.nextLine();
            System.out.println("Enter last name:");
            String lname=input.nextLine();
            System.out.println("Enter college name:");
            String college = input.nextLine();
            System.out.println("Enter age:");
            int age=input2.nextInt();
            //String yearInSchool = input.nextLine();
            stud.addStudent(fname,lname,age,college);
            ch = input3.next().charAt(0);
        }while(ch == 'Y' || ch == 'y');
        stud.Sort();
        stud.Show();
    }

}