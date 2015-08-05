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
