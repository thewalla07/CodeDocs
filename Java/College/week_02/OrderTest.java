
interface  Order {
	boolean lte (Object obj); // note parameter type (Order in 
									   // place of Object would also work)
	// is this object less than or equal to obj?
}

class Point {
	
	private double x, y; // coordinates. 
	
	// public boolean lte(Object obj){
		// if(obj==null) return false;
		// Point p = (Point) obj;
		// return x<p.x||(x==p.x&&y<=p.y);
	// }
	
	Point(double x0, double y0){ 
	    x = x0; y = y0;
	}

	Point(){}; 

	void get() { 
		x = Console.readDouble(); 
		y = Console.readDouble();
	}
	    
	public String toString() {  
		return "(" + x + "," + y + ")";
	}
	    
	double distance(Point r) { 
	// distance from r
		double xdist = x-r.x; 
		double ydist = y-r.y;
		return(Math.sqrt(xdist*xdist+
								ydist*ydist));	
	}
}

class Triangle implements Order {
	
    private Point v1 = new Point();    
    private Point v2 = new Point();    
    private Point v3 = new Point();
	
	public boolean lte(Object obj){
		if(obj == null) return false;
		Triangle t = (Triangle) obj;
		return area()<t.area();
	}

    void get() {
        v1.get(); v2.get(); v3.get(); 
    }

	public String toString() {
		return v1.toString() + "-" + 
			v2.toString() + "-" + 
			v3.toString() + ". Area = " +
			area(); 
	}
	   
    double area() { // area of the triangle
    	double a = v1.distance(v2);
    	double b = v2.distance(v3);
    	double c = v3.distance(v1);
    	double s = (a+b+c)/2;
      return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}

class OrderTest {
	static void sort(Order[] w) { // Sort w[0..]
		final int n = w.length;
		int j = 0; // w[j..] to be sorted
		while (j<n-1) {
			int min = j;  int i = j+1; 
			while (i<n) {
				if (w[i].lte(w[min]))
					min = i;
				i++;
			}
			Order temp= w[j];
			w[j] = w[min]; w[min] = temp;
			j++;
	    }
    }
    
	public static void main(String[] args) {
		Triangle[] ts = new Triangle[3]; 
		System.out.println(
			"Enter " + ts.length + " triangles:");
		for (int i=0; i<ts.length; i++) {
			ts[i] = new Triangle(); ts[i].get();
		}       	
		sort(ts); 
		for (Triangle t: ts)
			System.out.println(t);
	}
}