import java.util.*;
class MaximumPathSum{
	public static void main(String [] args){

	}

	static int[][] readArr(){
		Scanner in = new Scanner(System.in);
		int[][] out = new int[][];
		for(int i = 0; i < 15; i++){

		}
	}
}

class Pyramid<T>{
	private class Node<T>{
		private T item;
		private Node left, right, pleft, pright;

		Node(){
			item=null; left=null; right=null; pleft=null; pright=null;
		}

		Node(T i0){
			item=i0; left=null; right=null; pleft=null; pright=null;
		}

		Node(T i0, Node l0, Node r0, Node pl0, Node pr0){
			item=i0; left=l0; right=r0; pleft=pl0; pright=pr0;
		}
	}

	private Node<T> root;
	private int size=0;

	Tree(){
		root=new Node(); size=0;
	}

	Tree(T item){
		root=new Node(item); size=1;
	}

	public boolean add(T t){ // for main use
		int numItems0 = size;	//initial size stored for comparison later
		root = add(root, t);	//if new root
		return(numItems0<size); //was the add succesful
	}

	private Node<T> add(Node<T> n, T t){ // for internal use only
		// add the node at base of pyramid
		if(n==null) size++; return new Node<T>(t, null, null, null, null)
		Node<T> tmp = n.left;
		while(tmp!=null){
			if(tmp.pright==null){
				while(tmp.pleft!=null){
					tmp=tmp.pleft.left;
				}
				tmp=tmp.left;
			}
			else tmp=tmp.pright.right;
		}
		
		
	}
}

//*****************************************************************************************************??
















