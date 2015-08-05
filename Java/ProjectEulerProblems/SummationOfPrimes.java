class SummationOfPrimes{
	public static void main(String [] args){
		int initPrime = 3;
		int count = 2;
		long sum = 5;
		for(int i = initPrime; i < 2000000; i+=2){
			if(isPrime(initPrime, i)){
				count++;
				sum+=i;
				//System.out.println(i+" is "+count+"th prime"); 
			}
		}
		System.out.println("DONE "+sum);
	}
	public static boolean isPrime(int y, int x){
		int sqrt = (int)Math.sqrt(x);
		//System.out.println("y = "+y+ ", x = "+x);
		if(x%y==0) return false;
		if(y>=sqrt) return true;
		return true && (isPrime(y+1, x));
		//for(int i = 3; i < sqrt; i+=2){
	}
}