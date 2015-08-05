class NumberLetterCounts{
	public static void main(String [] args){
		int k = 0;
		for(int i=1; i<=1000; i++){
			System.out.println(i+", "+letters(i));
			k+=letters(i);
		}
		System.out.println(k);

	}

	static String [] ONES = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String [] TENS = {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	static int TH = "thousand".length();
	static int HU = "hundred".length();
	static int AND = 3;
	static int letters(int x){
		int total = 0;
		//thousands
		if(x==0) return 4;
		//th
		if(x/1000>0){
			total += ONES[(x/1000)].length()+TH;
			x=x%1000;
		}
		if(x/100>0){
			total += ONES[x/100].length()+HU;
			x=x%100;
			if(x>0) total += 3;
		}
		if(x<20) total+= ONES[x].length();
		else total+= TENS[x/10].length() + ONES[x%10].length();
		return total;
	}
}