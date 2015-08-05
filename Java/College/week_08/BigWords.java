/*
class Queue<T> {
	
	private static class Node<T> {
		private T item;			// data in node
		private Node<T> next = null;	// successor node

		                                                          
		Node(T item0, Node<T> next0) {
			item = item0; next = next0;
		}
	}
		
	private Node<T> head = null;
	private Node<T> tail = null; // both null, or neither null

	Queue(){}
	
	Queue(int n){} // for compatibility with bounded queue

	boolean isEmpty() {return(head==null);}

	boolean enq(T t) {
		Node<T> tNode = new Node<>(t,null); // new tail node
		if (tail!=null) tail.next = tNode;
		else head = tNode;
		tail = tNode;
		return true;
	}

	T deq() {
		// ... exercise ...
	}
}
*/

class Queue<T> { // bounded

	private T[] seq; // the sequence
	private int size = 0; // size of sequence
	private int head = 0;
	private int tail = 0; // front and rear

	Queue(int n) { // n>0
		seq = (T[])(new Object[1]);
	}

	Queue(){ this(1);} // =  seq=(T[])(new Object[10000]);
	
	boolean isEmpty() { return size==0;}

// 	boolean enq(T t) {
// 	  if (tail==seq.length){
//       T[] temp = (T[])(new Object[2*seq.length]);
//       for(int i = 0; i<seq.length; i++){
//         temp[i]=seq[i];
//       }
//       seq = temp;
// 	  }
// 		seq[tail] = t; tail = (tail+1)%seq.length; size++;
// 		return true;
// 	}


	boolean enq(T t) {       
		if (size==seq.length) {
			T[] temp = (T[])(new Object[2*seq.length]);
			int i = 0; int k = head;
			while (i<size) {
				temp[i] = seq[k]; 
				i++; 
				k = (k+1)%seq.length;
			}
			head = 0; 
			tail = seq.length; 
			seq  = temp; 
		}
		seq[tail] = t; 
		tail = (tail+1)%seq.length; 
		size++; 
		return true;
	}
	boolean enq(T t) { 
	  if (size==seq.length){
	    T[] tmp = (T[])(new Object[(2*size)]);
	    int i=0;
	    int tmpSize = size;
	    while(!isEmpty()){
	      tmp[i]=deq();
	      i++;
	    }
	    size = tmpSize;
      seq=tmp;
      head = 0;
	  }
		seq[tail] = t;
		tail++;
		size++; 
		return true;
	}
	
// 	boolean enq(T t) {
// 		if (size==seq.length) {
// 		  T[] tmp = (T[])(new Object[size*2]);
// 		  for(int i = 0; i<size; i++){
// 		    tmp[i] = seq[i];
// 		  }
// 		  seq = tmp;
// 		}
// 		seq[tail] = t; tail = (tail+1)%seq.length; size++;
// 		System.out.println("Size of queue is ("+seq.length+") num of elements is ("+size+")");
// 		return true;
// 	}
	T deq() {
		if (isEmpty()) return null;
		else {
			T temp = seq[head];
			head = (head+1)%seq.length; size--;
			return temp;
		}
	}
}


class BigWords {
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		int numWords = 0;
		while (!Console.endOfFile()) {
			String s = Console.readToken();
			if(s.equals("deq")){
			  System.out.println(q.deq());
			  numWords--;
			}
			else if(s.equals("num")){
			  System.out.println(numWords);
			}
			else{
  			numWords++;
  			q.enq(s);
			}
		}
		while (!q.isEmpty()) {
			String s = q.deq();
				System.out.println(s);
		}
	}
}