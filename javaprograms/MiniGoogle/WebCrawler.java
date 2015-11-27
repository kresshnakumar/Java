import java.util.*;
import java.io.IOException;
/**
 * Write a description of class WebCrawler here.
 * 
 * @author Krishna Kumar G 
 * @version 26-08-2015
 */
public class WebCrawler
{
  // instance variables - replace the example below with your own
  ArrayList<String> link;
  ArrayList<String> alllinks;
  ArrayList<String[]> allwords;
  ArrayList<String[]> words;
  WebPage page = new WebPage();
  SearchIndex search = new SearchIndex();
  /**
   * Constructor for objects of class WebCrawler
   */
  public WebCrawler(String url) throws IOException,Exception {
    // initialise instance variables
    link = new ArrayList<String>();
    alllinks = new ArrayList<String>();
    allwords = new ArrayList<String[]>();
    Crawl(url);
  }
  
  public void Crawl(String url) throws IOException,Exception {
    words = new ArrayList<String[]>();
    link = page.getAllLinks(url);
    for(int index = 0 ; index < link.size(); index ++) {
      alllinks = page.getAllLinks(link.get(index));
    }
    for (String link1 : alllinks) { 
      //System.out.println(link1);
      String content = page.getContent(link1);
      //System.out.println(content);
      //System.out.println("hello");
      words = page.getWords(content);
      for (String[] temp2 : words) {
          int flag = 0;
        for(String[] temp5 : allwords) {
          if(temp2[0].compareToIgnoreCase(temp5[0])== 0 && link1.compareToIgnoreCase(temp5[1] ) == 0){
            flag++;
          }
        }
        if(flag == 0){
          String[] str = {temp2[0],link1,temp2[1]};
          allwords.add(str);
        }
      } 
      for (String[] temp4 : words) {
        //System.out.println(temp4[0] +"\t" + temp4[1]);
      }
      for (String[] temp : allwords) {
        System.out.println(temp[0] +"\t" + temp[1] + "\t" + temp[2]);
      }
    }
    //int frequency = page.getKeywordFrequency("yggg");
  }
  
}



