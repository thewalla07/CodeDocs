import java.util.*;
import java.math.*;
class LargeSum{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		BigInteger [] nums = new BigInteger[100];
		BigInteger sum = new BigInteger("0");
		for(int y=0;y<100;y++){
			sum = sum.add(new BigInteger(in.next()));
		}
		while(sum.toString().length()>10){sum=sum.divide(new BigInteger("10"));}
		System.out.println(sum);
	}
}