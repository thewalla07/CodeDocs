class PerfectNums{
	static int sumFacs(int n){
		int x = 1;
		int sum = 0;
		while(x<n){
			if(n%x==0)
				sum+=x;
			x++;
		}
		return sum;
	}
	
	static boolean isPerfect(int n){
		return sumFacs(n)==n;
	}
	
	public static void main(String[]args){
		for(int i = 0; i<=1000; i++){
			if(isPerfect(i))
				System.out.println(i);
		}
	}
	
}