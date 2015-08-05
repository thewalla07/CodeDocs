import java.util.*;
class EvenOrderTest{
  public static void main(String [] args){
    ArrayList<Integer> evenArr = new ArrayList<>();
    ArrayList<Integer> oddArr = new ArrayList<>();
    while(!Console.endOfFile()){
      int x = Console.readInt();
      if(x%2==0)evenArr.add(x);
      else oddArr.add(x);
    }
    Collections.sort(evenArr);
    Collections.sort(oddArr);
    for(int i: evenArr)System.out.print(i + " ");
    for(int i: oddArr)System.out.print(i + " ");
  }
}
