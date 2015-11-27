public class Question
{
  // instance variables - replace the example below with your own
  private int serialNo;
  private String text;
  private String[] choice = new String[4];
  private int correctAnswer;
  /**
  * Constructor for objects of class Question
  */
  public Question(int serialNo,String text,String[] choice,int correctAnswer) {
    // initialise instance variables
    this.serialNo = serialNo;
    this.text = text;
    this.choice
    = choice;
    this.correctAnswer = correctAnswer;
  }
  public int getSerialNo() {
    return serialNo;
  }
  public String getText() {
    return text;
  }
  public String[] getChoices() {
    return choice;
  }
  public int getCorrectAnswer() {
    return correctAnswer;
  }
}