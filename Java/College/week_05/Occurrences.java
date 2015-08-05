import java.util.*;
class Occurrences{
  public static void main(String [] args){
    HashSet<String> ws = new HashSet<>();
    while(!Console.endOfFile()){
      String word = Console.readToken();
      if(ws.contains(word)){
        System.out.println("Word has occured");
      }
      else{
        System.out.println("Word has not occured");
        ws.add(word);
      }
    }
  }
}