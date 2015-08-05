class Runner{
	public static void main(String [] args){
		long num = 1;
		for(int i = 20; i>0; i--){
			boolean yes = true;
			if(prime(i)){
				if(div(num, k))
				num *= i;

				for(int j = 1; j<=20; j ++){
					if(num%j!=0) yes = false;
				}
				if(yes) System.out.println(num);
			}
		}
	}
	static boolean div(long l){
		for(int j = 1; j<=20; j ++){
			if(l%j!=0) return true;
		}
	}

	public static boolean prime(long l, k){
		if(l==2) return true;
		for(int i = 2; i < l; i++){
			if(l%i==0) return false;
		}
		System.out.println(l+" is prime");
		return true;
	}
}