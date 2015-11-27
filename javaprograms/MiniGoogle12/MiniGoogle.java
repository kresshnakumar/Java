import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.*;
import java.io.*;
/**
 * Write a description of class MiniGoogle here.
 * 
 * @author Krishna Kumar G 
 * @version 25-08-2015
 */
public class MiniGoogle {
  // instance variables - replace the example below with your own
  ArrayList<String> result;
  ArrayList<String> links;
  ArrayList<String> words;
  ArrayList<String[]> dictionary;
  /**
   * Constructor for objects of class MiniGoogle
   */
  public MiniGoogle() {
    // initialise instance variables
    result = new ArrayList<String>();
    links = new ArrayList<String>();
    dictionary = new ArrayList<String[]>();
  }
  public void webCrawl(String url) throws IOException,Exception {
    links = extractLinks(url);
    for(int index = 0 ; index < links.size(); index ++) {
      links = extractLinks(result.get(index));
    }
    for (String link : links) {
      //System.out.println(link);
      getPage(link);
    }
  }
  private ArrayList<String> extractLinks(String url) throws IOException {
    //final ArrayList<String> result = new ArrayList<String>();
    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a[href]");
    for (Element link : links) {
      result.add(link.attr("abs:href"));
    }
    return result;
  }
  
  private void getPage(String url) throws Exception {
    URL oracle = new URL(url);
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(oracle.openStream()));
    String line;
    while ( (line = br.readLine()) != null) {
      sb.append(line);
    }
    String nohtml = sb.toString().replaceAll("\\<.*?>","");
    System.out.println(nohtml);
    String delims = "[ .,?!-]+";
    String[] tokens = str.split(delims);
    for(int i = 0; tokens[i] != null ; i++) {
      
    }
  }
}
