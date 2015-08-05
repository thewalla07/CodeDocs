import java.util.*;
class Frequency{
  public static void main(String [] args){
    HashMap<Integer, Integer> map = new HashMap<>();
    while(!Console.endOfFile()){
      int length = Console.readToken().length();
      if(map.containsKey(length)){
        map.put(length, map.get(length) + 1);
      }
      else map.put(length, 1);
    }
    System.out.printf("%-15s %-15s\n", "Length", "Frequency");
    Set<Integer> set = map.keySet();
    for(int i: set) System.out.printf("%-15d %-15d\n", i, map.get(i));
  }
}