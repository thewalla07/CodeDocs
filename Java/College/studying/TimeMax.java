class TimeMax {
	private static int maximum(int[] w) { // max in w
		final int repeat = 1000000; // no of repetitions
		int max=0; int k;
		for (k=0; k<repeat; k++) { //repeated for timing 
			max = w[0]; int i=1; 
			while (i<w.length) {
				if (w[i]>max)max = w[i];        
				i++;
			}
		}
		return(max);
	}

	public static void main(String[] args) {
		final int lo = 1;
		final int hi = 100;
		final int step = 1;
		int n;
		for(n=lo; n<=hi; n=n+step) {        
			int[] numbers = new int[n];
			int i=0;
			while (i<numbers.length) {
				numbers[i] = (int)(Math.random()*10000);
				i++;
			}
			long startTime = System.currentTimeMillis();
			maximum(numbers);
			System.out.println(n + ": " + 
				(System.currentTimeMillis()-startTime));
		}
	}   
}