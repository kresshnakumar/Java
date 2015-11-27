import java.util.ArrayList;
import java.util.Scanner;
class Course {
  private String course;
  private int credits;
  private int marksObtained = 0;
  ArrayList<Question> test = new ArrayList<Question>();
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
  public void setQuiz() {
    if(course == "IT Workshop") {
      String[] options1 = {"C","Java","DS","OS"};
      Question q = new Question(1,"what is your present Course ?",options1,2);
      test.add(q);
      String[] options2 = {"English","CSS","HTML","JAVA"};
      q = new Question(2,"Programming Language ?",options2,4);
      test.add(q);
      String[] options3 = {"C","Java","DS","OS"};
      q = new Question(3,"Basic Programming Language ?",options3,2);
      test.add(q);
      String[] options4 = {"Data Structures","Data System","Data Source","none"};
      q = new Question(4,"DS ?",options4,1);
      test.add(q);
      String[] options5 = {"Operating Source","Operation System","Operating System","none"};
      q = new Question(5,"OS ? ",options5,2);
      test.add(q);
    }
    if(course == "Intro Programming") {
      String[] options6 = {"C","Java","DS","OS"};
      Question q = new Question(1,"what is your present Course ?",options6,2);
      test.add(q);
      String[] options7 = {"English","CSS","HTML","JAVA"};
      q = new Question(2,"Programming Language ?",options7,4);
      test.add(q);
      String[] options8 = {"C","Java","DS","OS"};
      q = new Question(3,"Basic Programming Language ?",options8,2);
      test.add(q);
      String[] options9 = {"Data Structures","Data System","Data Source","none"};
      q = new Question(4,"DS ?",options9,1);
      test.add(q);
      String[] options10 = {"Operating Source","Operation System","Operating System","none"};
      q = new Question(5,"OS ? ",options10,2);
      test.add(q);
    }
  }
  public int getQuiz() {
    Scanner input = new Scanner(System.in);
    for ( Question ques : test ) {
      System.out.print((ques.getSerialNo()) + ". ");
      System.out.println(ques.getText());
      for (int i1 = 0 ; i1 < 4 ; i1++) {
        System.out.println("choice" + (i1 + 1) + ":" + ques.getChoices()[i1] + "\t");
      }
      System.out.print("Enter your choice:");
      int answer=input.nextInt();
      if(ques.getCorrectAnswer() == answer) {
        marksObtained = marksObtained + credits;
        System.out.println("\nCorrect Answer...........\n");
      }
      else {
        System.out.println("\nWrong Answer...........!!!\n");
      }
    }
    return marksObtained;
  }
}