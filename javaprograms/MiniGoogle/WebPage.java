import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Write a description of class WebPage here.
 * 
 * @author Krishna Kumar G 
 * @version 26-08-2015
 */
public class WebPage
{
  ArrayList<String> alllinks;
  ArrayList<String> result = new ArrayList<String>();
  ArrayList<String> words;
  ArrayList<String> stopwords;
  ArrayList<String> nostopwords;
  ArrayList<String[]> tempdicnry = new ArrayList<String[]>();
  public ArrayList<String> getAllLinks(String url) throws IOException,Exception {
    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a[href]");
    for (Element link : links) {
      result.add(link.attr("abs:href"));
    }
    return result;
  }
  
  public String getContent(String url) throws IOException,Exception {
    URL urlname = new URL(url);
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(urlname.openStream()));
    String line;
    while ( (line = br.readLine()) != null) {
      sb.append(line);
    }
    String content = sb.toString().replaceAll("\\<.*?>","");
    //System.out.println(content);
    return content;
  }
  
  public ArrayList<String[]> getWords(String content) throws IOException,Exception {
    //System.out.println(content);
    words = new ArrayList<String>();
    nostopwords = new ArrayList<String>();
    StringTokenizer st = new StringTokenizer(content," ");
    while (st.hasMoreTokens()) {
      //System.out.println(st.nextToken());
      words.add(st.nextToken());
    }
    /*for (String temp : words) {
      System.out.println(temp);
    }*/
    getStopWords();
    for (String temp1 : words) {
      int count = 0;
      for (String temp2 : stopwords) {
        if(temp1.compareToIgnoreCase(temp2) == 0) {
          count++;
        }
      }
      if(count == 0) {
        nostopwords.add(temp1);
      }
    }
    /*for (String temp : nostopwords) {
      System.out.println(temp);
    }*/
    //allwords.addAll(nostopwords);
    for (String temp3 : nostopwords) {
      int freq = getKeywordFrequency(temp3);
      String[] text = { temp3,Integer.toString(freq)};
      tempdicnry.add(text);
    }
    /*for (String[] temp4 : tempdicnry) {
      System.out.println(temp4[0] +"\t" + temp4[1]);
    }*/
    return tempdicnry;
  }
  
  public void getStopWords() {
    try {
      stopwords = new ArrayList<String>();
      BufferedReader in = new BufferedReader(new FileReader("StopWords.txt"));
      String str;
      while ((str = in.readLine()) != null) {
        stopwords.add(str);
      }
      /*for (String temp : stopwords) {
        System.out.println(temp);
        }*/
      //System.out.println(str);
    }
    catch (IOException e) {
    }
  }  
  
  public int getKeywordFrequency(String word){
    int frequency = 0;
    for (String temp2 : nostopwords) {
      //System.out.println(temp2);
      if(word.compareToIgnoreCase(temp2) == 0) {
        frequency++;
      }
    }
    return frequency;
  }
 /* public void removeChar(String word) {
   int i;
      for(i = 0 ; i < word.length(); i++) {
     int value = Character.getNumericValue(word.charAt(i));
     if(value >= 65 && value <= 90 && value >= 97 && value <= 122) {
       continue;
     }
     else {
      int j;
      //word.charAt(i)= '';
       for (j = i; j < word.length() ; j++ )
       {
        word.charAt(j) = word.charAt(j+1);
      }
      word.charAt(j) = '\0';
    }
   }
   //return word;
  }*/
}