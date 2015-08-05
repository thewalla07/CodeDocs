class SpecialPythagoreanTriplet{
	public static void main(String [] args){
		for(int a =0; a<333;a++){
			for(int b=0+a;b<667;b++){
				int c = 1000 - (a+b);
				if(isSpecial(a,b,c)){
					System.out.println(a+" * "+b+" * "+c+" = "+(a*b*c));
				}
			}
		}
	}

	public static boolean isSpecial(int a, int b, int c){
		return (((a*a)+(b*b))==(c*c));
	}
}