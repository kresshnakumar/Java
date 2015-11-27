public class CourseManagementHiddenTest {

  public static void main(String[] args) {
	  
	  int score = 0;
	  String summary = "";

    CourseManagementSystem cms = new CourseManagementSystem("MSIT-IIIT");

    /* create courses */
    Course c1 = new Course("Python Workshop", 3);
    Course c2 = new Course("Intro Programming", 4);
	  Course c3 = new Course("Web Development", 3);
    cms.addCourse(c1);
    cms.addCourse(c2);
	  cms.addCourse(c3);

    /* create students */
    Student s1 = new Student("Alice");
    Student s2 = new Student("Dan");
    Student s3 = new Student("Maverick");
    cms.addStudent(s1);
    cms.addStudent(s2);
    cms.addStudent(s3);

    /* enroll students */
    Course[] c = new Course[3];
    c[0] = c1;
    c[1] = c2;
    c[2] = c3;

    /* pass an array of course objects
     * enroll the student into every course */
    cms.enroll(s1, c);
    cms.enroll(s2, c);
    cms.enroll(s3, c);

    /*
     * Get the enrolled courses in the same order of enrollement
     */
    Enrollment[] courses = cms.getEnrollments();

    /* award grade points */
    cms.awardGrade(s1, c[0], 10);
    cms.awardGrade(s1, c[1], 8);
	cms.awardGrade(s1, c[2], 5);
    cms.awardGrade(s2, c[0], 0);
    cms.awardGrade(s2, c[1], 6);
	cms.awardGrade(s2, c[2], 0);
    cms.awardGrade(s3, c[0], 8);
    cms.awardGrade(s3, c[1], 8);
	cms.awardGrade(s3, c[2], 0); // fixed the index of c from 1 to 2

    /* compute GPA should compute the GPA for all the students 
     * Set the calculated GPA to the private instance variable of Student
     */
    cms.computeGPA();

    /* get GPA and print 
     * Expected Output for s1:
     * 7.7
     */
	String s1_marks = ""+s1.getGPA();
	String s2_marks = ""+s2.getGPA();
	String s3_marks = ""+s3.getGPA();
	if(s1_marks.equals("7.7")){
		score = score + 1;
	} else {
		summary = summary + "TestCase #1 Failed (GPA generated is incorrect for Student1) \n";
	}
	if(s2_marks.equals("2.4")){
		score = score + 1;
	} else {
		summary = summary + "TestCase #2 Failed (GPA generated is incorrect for Student2) \n";
	}
	if(s3_marks.equals("5.6")){ // fixed from s2 to s3
		score = score + 1;
	} else {
		summary = summary + "TestCase #3 Failed (GPA generated is incorrect for Student3) \n";
	}

    System.out.println("{\"score\":"+score+", \"summary\":\""+summary+"\"}");
  }
}