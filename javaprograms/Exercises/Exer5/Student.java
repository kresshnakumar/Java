
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student 
{
    // instance variables - replace the example below with your own
    private String college;
    private int gpa;
    /**
     * Constructor for objects of class Student
     */
    public Student(String fname,String lname,int age,String college,double gpa)
    {
        // initialise instance variables
        this.college = college;
        this.gpa = gpa;
        super.setName(fname,lname);
        super.setAge(age);
    }

}
