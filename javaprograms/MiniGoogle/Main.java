import java.io.IOException;
/**
 * Write a description of class Main here.
 * 
 * @author Krishna Kumar G 
 * @version 26-08-2015
 */
public class Main
{
  public static void main(String[] args) throws IOException,Exception {
    String site = "http://minigoogle.msitprogram.net/";
    WebCrawler search = new WebCrawler(site);
  }
}
