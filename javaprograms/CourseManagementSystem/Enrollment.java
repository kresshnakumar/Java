class Enrollment {
  private Student s;
  private Course c;
  private int gradePoints;
  public Enrollment(Student s, Course c) {
  	this.s = s;
  	this.c = c;
  }
  public Student getStudent() {
  	return s;
  }
  public Course getCourse() {
  	return c;
  }
  public void setGradePoints(int gradePoints) {
  	this.gradePoints = gradePoints;
  }
  public int getGradePoints() {
  	return gradePoints;
  }
}