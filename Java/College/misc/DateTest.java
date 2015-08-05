import java.util.*;
class DateTest{
  public static void main(String [] args){
    Bag<Date> ds = new Bag<Date>();
    ds.add(new Date(12,4,1965));
    ds.add(new Date(16,8,2003));
    ds.add(new Date(21,9,2005));
    ds.add(new Date(23,8,2014));
    ds.add(new Date(23,9,2015));
    
    System.out.println(ds.numGreater(new Date(11,11,2002)));
  }
}

class Date implements Comparable<Date>{
  private int day, month, year;
  
  Date(int day0, int month0, int year0){
    day = day0; month = month0; year = year0;
  }
  
  public String toString(){
    return "" + day + "/" + month + "/" + year;
  }
  
  public int compareTo(Date d){
    return elapsedDays() - d.elapsedDays();
  }
  
  private int elapsedDays(){
    //number of days elapsed from 1/1/1900 to this date
    int days = (year-1900)*365 + (year-1901)/4;
    int k = 1;
    while(k<month){
      int daysInMonth;
      if(k==9||k==4||k==6||k==11)daysInMonth = 30;
      else if(k==2){
        if(year%4==0 && year!=1900) daysInMonth = 29;
        else daysInMonth = 28;
      }
      else daysInMonth = 31;
      days = days + daysInMonth;
      k++;
    }
    return days + day;
  }
}

class Bag<T extends Comparable<T>> {// generic class with T standing for a class

    private T[] bag = (T[])(new Comparable[100]);
    private int numElements = 0; // junk in bag[numElements..]
    
    void add(T x) { // put x in bag
			bag[numElements] = x; numElements++;
    }
    
    int numGreater(T x){
      int v = 0;
      for (int i=0; i<numElements; i++)if(bag[i].compareTo(x)>0)v++;
      return v;
    }
    
    int freq(T x) { // how many x’s in bag?
			int count = 0;
			for (int i=0; i<numElements; i++)
				if (bag[i].equals(x)) // .equals because T a class
					count++;
			return count;
    }
}