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
class Employee extends Person {
    private String company;
    private double salary;
    public static enum Designation {assistant, teamLeader,manager};
    private Designation design;
    public Employee() {
        company = "default";
        salary = 0.0;
        design = Designation.assistant;
    }
    public Employee(String name) {
        super(name);
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDesignation(Designation design) {
        this.design = design;
    }
    public String getCompany() {
        return company;
    }
    public double getSalary() {
        return salary;
    }
    public Designation getDesignation() {
        return design;
    }
    public String toString() {
        return super.toString()+"\n"+"Company :"+company+"\t Salary :"+salary+"\t Designation :"+design;
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
public class Exe2
{
    public static void main(String args[])
    {
        Student s = new Student("Krishna");
        s.setAge(21);
        s.setGender(Person.Gender.M);
        s.setCollege("BITS");
        s.setYear(Student.YearInSchool.junior);
        s.setGpa(3.5f);
        System.out.println(s);
        Employee emp = new Employee("kumar");
        emp.setAge(21);
        emp.setGender(Person.Gender.M);
        emp.setCompany("MICROSOFT");
        emp.setDesignation(Employee.Designation.manager);
        emp.setSalary(2500000);
        System.out.println(emp);
    }

}