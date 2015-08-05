class LongestCollatzSequence{
	public static void main(String [] args){
		long num = 1;
		long max = 0;
		for(long i = 1; i <= 1000000; i++){
			long tmp = getCount(i);
			//System.out.println(tmp);
			if(tmp>num){
				num=tmp;
				max=i;
			}
			if(i%1000==0){
				System.out.println(i/1000);
			}
		}
		System.out.println("DONE: "+num+", "+max);
	}


	public static long getCount(long x){
		long count = 1;
		while(x!=1){
			if(x%2==0){
				x=x/2;
				count++;
			}
			else{
				x=((x*3)+1)/2;
				count+=2;
			}
		}
		return count;
	}
}