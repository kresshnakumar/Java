class Course {
  private String course;
  private int credits;
  public Course(String course , int credits) {
  	this.course = course;
  	this.credits = credits;
  }
  public String getCourseName() {
  	return course;
  }
  public int getCredits() {
  	return credits;
  }
}