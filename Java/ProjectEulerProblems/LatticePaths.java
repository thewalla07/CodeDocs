
import java.math.*;
/*
		BigInteger [] nums = new BigInteger[100];
		BigInteger sum = new BigInteger("0");
		for(int y=0;y<100;y++){
			sum = sum.add(new BigInteger(in.next()));
		}
		while(sum.toString().length()>10){sum=sum.divide(new BigInteger("10"));}
		System.out.println(sum);
*/
class LatticePaths{
	//static BigInteger ONE = new BigInteger("1");
	//static BigInteger TWO = new BigInteger("2");
	public static void main(String [] args){
	//	for(long i=0; i<)
	//	System.out.println(gen(20));
	//	BigInteger i =  BigInteger.ONE;
	/*
		while(!(i.equals(new BigInteger("21")))){
			System.out.println((i)+", "+generateCombs(i));
			i=i.add(BigInteger.ONE);
		}	*/
		for(int i = 1; i < 25; i++){
			//Tree t = new Tree(i);
			//System.out.println(t.numLeaves());
			System.out.println(i+", "+gen(i, i));
		}



	}

	public static long gen(int x, int y){
		if(x<=0 && y<=0) return 0;
		else if(x==1) return 1+y;
		else if(y==1) return 1+x;
		else return gen(x-1, y) + gen(x, y-1);
	}
/*
	public static BigInteger generateCombs(BigInteger x){
		if(x.toString().equals("1")) return TWO;
		return (((x.multiply(TWO).subtract(TWO)).multiply((generateCombs(x.subtract(BigInteger.ONE)))))).add(TWO);
	}

	public static long gen(long x){
		return fac(x)/fac(x*2)*((x)-x*2);
	}

	public static long fac(long x){
		if(x==1)return 1;
		return x*fac(x-1);
	}

	public static long paths(long x, long y){
		return 0;
	}
*/
}

class Tree{
	public static int wleaves = 0;
	private class Node{
		//private T item;
		private int ls, rs;
		private Node left, right;

		Node(Node l0, Node r0, int ls0, int rs0){
			//item = i0;
			left = l0;
			right = r0;
			ls = ls0;
			rs = rs0;
		}

		public boolean hasLeft(){
			return ls>0;
		}

		public boolean hasRight(){
			return rs>0;
		}

		public void grow(Node n){
			if(hasLeft()){
				left.grow(new Node(null, null, n.ls-1, n.rs));
			}
			if(hasRight()){
				right.grow(new Node(null, null, n.ls, n.rs-1));
			}
			if(!(hasLeft()&&hasRight())){
				wleaves++;
			}
		}

	}

	private Node root;
	private int leaves;

	Tree(int x){
		root = new Node(null, null, x, x);
		grow(root);
	}

	public int numLeaves(){
		return wleaves;
	}

	public void grow(Node n){
		if(n.hasLeft()){
			n.left.grow(new Node(null, null, n.ls-1, n.rs));
		}
		if(n.hasRight()){
			n.right.grow(new Node(null, null, n.ls, n.rs-1));
		}
		if(!(n.hasLeft()&&n.hasRight())){
			leaves++;
		}
	}
}