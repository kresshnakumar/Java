import java.util.ArrayList;
import java.text.DecimalFormat;
class CourseManagementSystem {
  String title;
  ArrayList<Course> cal = new ArrayList<Course>();
  ArrayList<Student> sal = new ArrayList<Student>();
  ArrayList<Enrollment> eal = new ArrayList<Enrollment>();
  public CourseManagementSystem() {}
  public CourseManagementSystem(String title) {
  	this.title = title;
  }
  public void addCourse(Course c) {
  	cal.add(c);
  }
  public void addStudent(Student s) {
  	sal.add(s);
  }
  public void enroll(Student s, Course[] c) {
    for(int i = 0 ; i < 2; i++) {
      Enrollment e = new Enrollment(s,c[i]);
      eal.add(e);
    }
  }
  public Enrollment[] getEnrollments() {
  	Enrollment[] eArray = new Enrollment[10];
  	for(int index = 0 ; index < eal.size(); index++) {
  	  eArray[index] = eal.get(index);
  	}
  	return eArray;
  }
  // public void awardGrade(Student s,Course c, int grade) {
  // 	for(int index = 0 ; index < eal.size(); index++ ) {
  // 	  if(s.getStudentName().equals(eal.get(index).getStudent().getStudentName())) {
  // 	  	if(c.getCourseName().equals(eal.get(index).getCourse().getCourseName())) {
  // 	  	  eal.get(index).setGradePoints(grade);
  // 	  	}
  // 	  }
  // 	}
  // }
  public void generateQuiz(Course c) {
    for(Course temp : cal) {
      if(temp.getCourseName().compareTo(c.getCourseName()) == 0) {
        c.setQuiz();
      }
    }
  }
  public void startQuiz(Student s, Course c) {
    for(int index = 0 ; index < eal.size(); index++ ) {
      if(s.getStudentName().equals(eal.get(index).getStudent().getStudentName())) {
        if(c.getCourseName().equals(eal.get(index).getCourse().getCourseName())) {
          System.out.println(s.getStudentName() + " Test for Course : " + c.getCourseName());
          System.out.println("-------------------------------------------");
          int marks = c.getQuiz();
          eal.get(index).setGradePoints(marks);
        }
      }
    }
  }
  public void computeGPA() {
  	float gpa = 0;
  	int totalCredits = 0;
  	int compute = 0;
  	for(int i = 0; i < sal.size() ; i++ ) {
  		compute = 0;
  		totalCredits = 0;
  		for(int j = 0; j < eal.size() ; j++) {
  			if(sal.get(i).getStudentName().compareTo(eal.get(j).getStudent().getStudentName()) == 0) {
  				for(int k = 0 ; k < cal.size() ; k++) {
  					if(cal.get(k).getCourseName().compareTo(eal.get(j).getCourse().getCourseName()) == 0) {
  						int credits = cal.get(k).getCredits();
  						totalCredits = totalCredits + credits;
  						int grade = eal.get(j).getGradePoints();
  						compute = compute + credits * grade;
  					}
  				}
  			}
  		}
  		gpa = (float)compute / totalCredits;
  		sal.get(i).setGPA(gpa);
  	}
  }
  public String generateTranscript(Student s) {
  	String str = s.getStudentName();
  	str = str + " has enrolled in 2 courses and obtained the following grades.";
  	for(int i = 0; i < eal.size(); i++) {
  		if(s.getStudentName().compareTo(eal.get(i).getStudent().getStudentName()) == 0) {
  			str = str + "\n" + eal.get(i).getCourse().getCourseName();
  			str = str +" " + eal.get(i).getGradePoints();
  		}
  	}
  	str = str +"\nGPA is " + s.getGPA();
  	return str;
  }
}