class Person {
    private String name;
    private int age;
    private Gender gender;
    public static enum Gender {M,F,D};
    public Person() {
        name = "default";
        age = 0;
        gender = Gender.D;
    }
    public Person(String name) {
       this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String setName() {
        return this.name;
    }
    public int setAge() {
        return this.age;
    }
    public Gender setGender() {
        return this.gender;
    }
    public String toString() {
        return "Name :"+name+"\tAge :"+age+"\tGender :" +gender;
    }
}
class Student extends Person {
    private String college;
    private double gpa;
    public static enum YearInSchool {frosh,sophomore, junior, senior}
    private YearInSchool year;
    public Student() {
        college = "default";
        gpa = 0.0;
        year = YearInSchool.frosh;
    }
    public Student(String name) {
        super(name);
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setYear(YearInSchool year) {
        this.year = year;
    }
    public String getCollege() {
        return college;
    }
    public double getGpa() {
        return gpa;
    }
    public YearInSchool getYear() {
        return year;
    }
    public String toString() {
        return super.toString()+"\n"+"College :"+college+"\t gpa :"+gpa+"\tYear In School :"+year;
    }
}
public class Exe1
{
    public static void main(String args[])
    {
        Student s = new Student("Krishna");
        s.setAge(21);
        s.setGender(Person.Gender.M);
        s.setCollege("BITS");
        s.setYear(Student.YearInSchool.junior);
        s.setGpa(3.5f);
        System.out.println(s.toString());
    }

}