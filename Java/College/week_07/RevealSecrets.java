class Stack<T> {

	private static class Node<T> {
		private T item;			// data in node
		private Node<T> next = null;	// successor node
		                                                          
		Node(T item0, Node<T> next0) {
			item = item0; next = next0;
		}
	}

	private Node<T> head = null; // first node (null if empty)

	Stack() {}

	Stack(int n) {}

	boolean isEmpty() {return(head==null);}
	
	int size(){
	  Node<T> tmp = head;
	  int count = 0;
	  while(tmp!=null){
	    count++;
	    tmp = tmp.next;
	  }
	  return count;
	}

	boolean push(T t) {
		head = new Node<>(t,head);
		return true; // always space available
	}

	T pop() {
		if (head==null) return null;
		T t = head.item;
		head = head.next;
		return t;
	}
}

class RevealSecrets{
  public static void collectAll(Stack<String> stack, Secrets bag, String str){
    for(char ch='z';ch!='`'; ch--){
      if(bag.hasPrefix(str+ch))
        printAll(stack, bag, str+ch);
      if(bag.has(str+ch))
        stack.push(str+ch);
    }
  }
  
  public static void main(String [] args){
    Secrets bag = new Secrets();
    Stack<String> stck = new Stack<String>();
    collectAll(stck, bag, "");
    while(stck.size()!=0){
      System.out.println(stck.pop());
    }
  }
}