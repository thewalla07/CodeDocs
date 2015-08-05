import java.math.*;
class PowerDigitSum{
	public static void main(String [] args){

		for(int i = 1; i <=1000; i++){
			BigInteger k = new BigInteger(i+"");
			System.out.println(i+", "+pow(k));
		}

		BigInteger k = new BigInteger(1000+"");
		System.out.println("\n\n"+sum(pow(k).toString()));
	}

	public static long sum(String s){
		if(s.length()==1) return Long.parseLong(s);
		return Long.parseLong(s.charAt(0)+"") + sum(s.substring(1));
	}

	public static BigInteger pow(BigInteger x){
		if(x.equals(BigInteger.ONE)) return new BigInteger("2");
		return	new BigInteger("2").multiply(pow(x.subtract(BigInteger.ONE)));
	}
}