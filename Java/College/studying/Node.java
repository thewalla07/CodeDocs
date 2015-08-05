class Tree{
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
	}

	private Node root;
	private int leaves;

	Tree(int x){
		root = new Node(null, null, x, x);
	}

	public int numLeaves(){
		return leaves;
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