interface Printable{
	void put();
}

interface  Order {
	boolean lte (Object obj); // note parameter type (Order in 
						 // place of Object would also work)
	// is this object less than or equal to obj?
}

class Point implements Order, Printable {
	private int x; 
	private int y;

	Point (int x0, int y0) {
		x = x0; y = y0;
	}

	public boolean lte(Object obj) {// Note param type; note public
	   if (obj==null) return false;
	   Point p = (Point) obj; // error if obj not of type Point
	   return x<p.x||(x==p.x&&y<=p.y);
  	}
  
  	public void put() {
  		System.out.println("(" + x + "," + y + ")"); 
  	}
}

class Time implements Order, Printable {
	private int hours; // 0..23
	private int mins; // 0..59

	Time (int hours0, int mins0) {
		hours = hours0; mins = mins0;
	}

	public boolean lte(Object obj) {// Note param type; note public
	   if (obj==null) return false;
	   Time t = (Time) obj; // error if obj not of type Time
	   return hours*60+mins<=t.hours*60+t.mins;
  	}
  
  	public void put() {
  		System.out.printf("%02d:%02d\n", hours, mins); 
  	}
}

class PrintableTest{
	static void print(Printable obj){
		obj.put();
	}

	// public static void main(String[]args){
		
	// }
}

class OrderDemo {
	
	static void sort(Order[] w) {
    // Sort w[0..]
	    final int n = w.length;
	    int j = 0; // w[j..] to be sorted
	    while (j<n-1) {
	        // find minimum in w[j..]
	        int min = j;  int i = j+1; 
	        // always w[min] is minimum in w[j..i-1]
	        while (i<n) {
	            if (w[i].lte(w[min])) 
	                min = i;
	            i++;
	        }
	        // w[min] is minimum in w[j..]. swap w[j] and w[min] 
	        Order temp = w[j]; // note type
	        w[j] = w[min]; w[min] = temp;
	        j++;
	   }
   }
	
   public static void main(String[] args)
   {
      Point[] points = {new Point(5,4), new 
		   	Point(3,5), new Point(6,1), new Point(3,3)}; 
      sort(points); // note Point[] matches Order[]
      for (Printable p: points) p.put();
      Time[] times = {new Time(15,10), new 
				Time(11,5), new Time(9,20)};
      sort(times); // same sort() as for points!
      for (Printable p: times) p.put();
  }
}






















