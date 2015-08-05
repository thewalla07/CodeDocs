class HighlyDivisibleTriangularNumber{
	/*
	public static int[] createDivisors(){
		int [] divs
	}
	*/	
	static long globalCount=0;
	static long globalXn=0;

	public static long numDivs(long x){
		long count = 0;
		for(long i = 1; i<Math.sqrt(x); i++){
			if(x%i==0){
				count+=2;
			}
		}
		//System.out.println(count);
		return count;
	}

	public static long bigTri(long x, long xn){
		//System.out.print(x+"\t\t\t\t");
		long n = numDivs(x);
		if(n>500||globalCount>10) return n;
		globalCount++;
		globalXn=x;
		System.out.println(n+"\txxx\t"+x);
		return bigTri((x+((x-xn)+1)), x);
	}

	public static void main(String [] args){
		/*
		long num = 1;
		while(num>1000 || num < 500){
			globalCount=0;
			num = bigTri(num,globalXn);
			System.out.println(num+"\t\t"+globalXn);
		}
		*/
		long add = 2;
		long num = 1;
		long div = 1;
		for(int i=0; i<100; i++){
			num+=add;
			add++;
			div=numDivs(num);
			System.out.println("num, add, div: "+num+", "+add+", "+div);
		}
		System.out.println("\n\n\n");
		add = 2;
		num = 1;
		div = 1;
		while(div < 500){
			num+=add;
			add++;
			div=numDivs(num);
			if(add%100==0){
				System.out.println("num, add, div: "+num+", "+add+", "+div);
			}
		}
		System.out.println("DONE: num, add, div: "+num+", "+add+", "+div);
	}
}