import java.io.*;
import java.util.*;
class Dodgy{
  public static void main(String [] args){
    Scanner input = null;
    HashSet<String> u = new HashSet<>();
    HashSet<String> t = new HashSet<>();
    
    try{
      input = new Scanner(new File("unemployed.txt"));
    }
    catch(FileNotFoundException e){
      System.out.println("Could not find the file");
    }
    
    while(input.hasNextLine()){
      String name = input.nextLine();
      u.add(name);
    }
    
    try{
      input = new Scanner(new File("taxpayers.txt"));
    }
    catch(FileNotFoundException e){
      System.out.println("Could not find the file");
    }
    
    while(input.hasNextLine()){
      String name = input.nextLine();
      if(u.contains(name)){
        System.out.println(name + " is a dodgy character.");
      }
    }
  }
}