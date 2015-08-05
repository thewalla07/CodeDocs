import java.util.*;
class Directory{
  public static void main(String [] args){
    HashMap<String, Integer> dir = new HashMap<>();
    while(!Console.endOfFile()){
      try{
      String name = Console.readToken();
      String num = Console.readToken();
      
      if(num.equals("?")){
        if(dir.containsKey(name))
          System.out.println(dir.get(name));
        else
          System.out.println("Can't find "+name);
      }
      else
        dir.put(name, Integer.parseInt(num));
      }
      catch(NumberFormatException e){
        System.out.println("Invalid input in either name, number or query");
      }
    }
  }
}