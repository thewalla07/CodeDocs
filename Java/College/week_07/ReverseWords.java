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
class ReverseWords {
  static boolean isProper(String exp){
    Stack<Character> stack = new Stack<Character>();
    int i = 0;
    while(i<exp.length()){
      char tmp = exp.charAt(i);
      if(tmp == '(' || tmp == '{' || tmp == '[')
        stack.push(tmp);
      else if(tmp == ')'){
        if('(' != stack.pop())
          return false;
      }
      else if(tmp == '}'){
        if('{' != stack.pop())
          return false;
      }
      else if(tmp == ']'){
        if('[' != stack.pop())
          return false;
      }
      i++;
    }
    return stack.size()==0;
    
  }
  
	public static void main(String[] args) {
		/*
		
		Stack<String> stack = new Stack<>();
		System.out.println("Enter text");
		while (!Console.endOfFile()){
			stack.push(Console.readToken()); // assume enough room
		}
		System.out.println("Stack is "+stack.size()+" items in size");
		while(!stack.isEmpty()) {
			String s = stack.pop();
			System.out.print(s + " ");
		}
		System.out.println("Stack is "+stack.size()+" items in size");
		
		*/
		System.out.println(isProper("a(bc)[d]e"));
		System.out.println(isProper("a(b{cd})e[]fg"));
		System.out.println(isProper("{[]"));
		System.out.println(isProper("a(bc)[d}e"));
		System.out.println(isProper("[a(b{cd})"));
	}
}