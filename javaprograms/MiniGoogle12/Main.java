import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Main here.
 * 
 * @author Krishna Kumar G 
 * @version 25-08-2015
 */
public class Main
{
  // instance variables - replace the example below with your own
  private String url;
  /**
   * Constructor for objects of class Main
   */
  /*public static void main(String[] args) {
    // initialise instance variables
    MiniGoogle search = new MiniGoogle();
    String site = "http://www.google.com";
    List<String> links = search.extractLinks(site);
    for (String link : links) {
      System.out.println(link);
    }
  }*/
  public final static void main(String[] args) throws Exception{
    String site = "http://minigoogle.msitprogram.net/";
    MiniGoogle search = new MiniGoogle(site);
  }
}
