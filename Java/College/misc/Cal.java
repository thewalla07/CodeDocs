import java.util.*;
class Cal{
  public static void main(String [] args){
    GregorianCalendar tadhg = new GregorianCalendar();
    int day = tadhg.get(GregorianCalendar.DATE);
    int month = tadhg.get(GregorianCalendar.MONTH)+1;
    int year = tadhg.get(GregorianCalendar.YEAR);
    
    System.out.println(day);
    System.out.println(month);
    System.out.println(year);
  }
}