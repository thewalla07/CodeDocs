class Structures{
  public static void main(String [] args){
    //main code here
    
    
    Stack<String> stack = new Stack<String>();
    stack.push("hello");
    stack.push("world");
    System.out.println(stack.pop()+ " " + stack.pop());
    QueueUA<String> queue = new QueueUA<String>();
    queue.enq("hello");
    queue.enq("world");
    System.out.println(queue.deq()+ " " + queue.deq());
    QueueN<String> queueN = new QueueN<String>();
    queueN.enq("hello");
    queueN.enq("world");
    System.out.println(queueN.deq()+ " " + queueN.deq());
    queueN.enq("hello");
    queueN.enq("world");
    System.out.println(queueN.deq()+ " " + queueN.deq());
    queueN.enq("hello");
    queueN.enq("world");
    queueN.enq("hello");
    queueN.enq("world");
    System.out.println(queueN.deq()+ " " + queueN.deq());
    System.out.println(queueN.deq()+ " " + queueN.deq());
    
    //joe's queue test
    QueueN<String> q = new QueueN<>(); 						
		int totalLength = 0; int numWords = 0;
		while (!Console.endOfFile()) {
			String s = Console.readToken(); 
			numWords++; 
			totalLength = totalLength+s.length();
			q.enq(s);

		}
		int meanLength = totalLength/numWords;
		while (!q.isEmpty()) { 
			String s = q.deq();
			if (s.length()>meanLength) 
				System.out.println(s);
		}
  }
}

class QueueN<T>{
  private static class Node<T>{
    private Node<T> next = null;
    private T item;
    
    Node(T i0, Node<T> n0){
      item = i0;
      next = n0;
    }
  }
  
  private Node<T> head = null;
  private Node<T> tail = null;
  int size = 0;
  
  QueueN(int n){
    
  }
  QueueN(){
    
  }
  
  boolean isEmpty(){return head==null;}

  boolean enq(T t){
    Node<T> tmp = new Node<T>(t, null);
    if(tail!=null)tail.next=tmp;
    else head = tmp;
    tail = tmp;
    return true;
  }
  
  T deq(){
    if(isEmpty())return null;
    T tmp = head.item;
    if(head.next==null)
    tail = null;
    head = head.next;
    return tmp;
  }
}

class QueueCA<T>{
  private T[] seq;
  private int size = 0;
  private int head = 0;
  private int tail = 0;
  
  QueueCA(int n){
    seq = (T[])(new Object[n]);
  }
  
  QueueCA(){
    this(10000);
  }
  
  boolean isEmpty(){
    return size==0;
  }
  
  boolean enq(T t){
    if(size==seq.length)return false;
    seq[tail] = t;
    tail = (tail+1)%seq.length;
    size++;
    return true;
  }
  
  T deq(){
    if(size==0)return null;
    T ret = seq[head];
    head = (head+1)%seq.length;
    size--;
    return ret;
  }
}

class QueueUA<T>{
  private T[] seq;
  private int size = 0;
  private int head = 0;
  private int tail = 0;
  
  QueueUA(int n){
    seq = (T[])(new Object[1]);
  }
  
  QueueUA(){
    this(1);
  }
  
  boolean isEmpty(){
    return size==0;
  }
  
  boolean enq(T t){
    if(size==seq.length){
      T[] tmp = (T[])(new Object[size*2]);
      for(int i = 0; i<size; i++){
        tmp[i] = seq[i];
      }
      seq = tmp;
    }
    seq[tail] = t;
    tail = (tail+1);
    size++;
    return true;
  }
  
  T deq(){
    if(size==0)return null;
    T ret = seq[head];
    head = (head+1);
    size--;
    return ret;
  }
}

class Stack<T>{
  private static class Node<T>{
    private T item;
    private Node<T> next = null;
    
    Node(T i0, Node<T> n0){
      item = i0;
      next = n0;
    }
  }
  
  private Node<T> head = null;
  private int length = 0;
  Stack(){
    
  }
  
  Stack(int n){
    
  }
  
  boolean isEmpty(){
    return(head==null);
  }
  
  boolean push(T t){
    head = new Node<T>(t, head);
    return true;
  }
  
  T pop(){
    if(isEmpty())return null;
    T t = head.item;
    head = head.next;
    return t;
  }
  
  int size(){
    Node<T> tmp = head;
    int i = 0;
    while(tmp.next!=null){
      i++;
      tmp = tmp.next;
    }
    return i;
  }
}

//////

class TreeSet<T extends Comparable<T>> { // sets using trees
  private static class Node<T> { // node of binary search tree
    private T item;               // data item - must supply compareTo method 
    private Node<T> left, right; //left and right subtrees
      
    Node(T item0, Node<T> left0, Node<T> right0)  {
      item = item0; left = left0; right = right0;
    }
  }

  private Node<T> root = null; // root of tree encoding the set 
  private int numItems = 0; // size of set = number of  nodes

  public int size() {return numItems;} 

  public boolean contains(T t) {
    Node<T> p = root;
    while (p!=null && !t.equals(p.item)) {
      if (t.compareTo(p.item)<0) p = p.left;
      else p = p.right;
    }
    return p!=null;
  }

  boolean contains(T t) { // as before, but using recursion
    return contains(root,t); // set-up step for tree recursion
  }

  private boolean contains(Node<T> p, T t) { // note private
    // is t in binary search tree rooted at p?
    if (p==null) return false;
    else if ((p.item).equals(t)) return true;
    else if ((p.item).compareTo(t)>0) return contains(p.left,t);
    else return contains(p.right,t);
  } 

  public boolean add(T t) { 
    int numItems0 = numItems; // initial number of nodes
    root = add(root,t);  // catering for possible new root
    return (numItems0<numItems); 
  } 
      
  private Node<T> add(Node<T> p, T t) { 
    // add t (if not present) to binary search tree rooted at p
    // & return root of new tree (which is usually p)
    if (p==null) { // tree empty 
      numItems++; return new Node<T>(t,null,null);
    }
    else if ((p.item).compareTo(t)>0) {// t small, so add on left       
      p.left = add(p.left,t);// note possible new p.left 
      return p;
    }
    else if (t.compareTo(p.item)>0) { // t big, so add on right       
      p.right = add(p.right,t); // note possible new p.right
      return p;
    }
    else // t present in node p, so no change 
      return p;
  }

  public boolean remove(T t) {
    int numItems0 = numItems; // initial number of nodes
    root = remove(root,t); // note catering for possible new root
    return (numItems<numItems0);
  }

  private Node<T> remove(Node<T> p, T t) {
  // remove t (if  present) from binary search tree rooted at p
  // & return root of new tree
    if (p==null) // tree empty, so can't remove t 
      return p;
    else if ((p.item).compareTo(t)>0) {//t small so remove on left 
      p.left = remove(p.left,t); // note possible new p.left
      return p;
    }
    else if ((p.item).compareTo(t)>0) {// t big so remove on right 
      p.right = remove(p.right,t); // note possible new p.right
      return p;
    }
    else { // t in node p: remove node p & merge its two subtrees
      numItems--;
      return mergeTrees(p.left,p.right);      
    }
  } 
//  I see the study is going well :P
  private Node<T> mergeTrees(Node<T> p, Node<T> q) {
  // merge binary search trees rooted at p and q and return 
  // new root. Input trees are disjoint, and values in tree p 
  // are less than values in tree q. 
  }
}
