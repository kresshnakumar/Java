import java.util.ArrayList;
import java.text.DecimalFormat;
class Student {
  private String studentName;
  private float GPA; 
  public Student(String studentName) {
  	this.studentName = studentName;
  }
  public String getStudentName() {
  	return studentName;
  }
  public void setGPA(float GPA) {
  	this.GPA = (float)Math.round(GPA * 100)/100;
  }
  public float getGPA() {
  	return GPA;
  }
}