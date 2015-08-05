/* INSERT YOUR NAME AND STUDENT NUMBER HERE */

class MyQueue 
{	

    private Node head = null; // (reference to) first node
	private Node tail = null; // (reference to) last node; 

	private static class Node 
	{            
		private String item;			// data in node     
		private Node next = null;		// successor node 
		                                                          
		Node(String item0, Node next0) 
		{ 
			item = item0; 
			next = next0;
		}
	}
		

	boolean isEmpty() 
	{
		// REPLACE THE FOLLOWING LINE WITH THE CORRECT CODE
		if(head == null && tail == null)
		{
			return true;
		}
		return false;
	}

	void enq(String t) 
	{ 
		// REPLACE THE FOLLOWING LINE WITH THE CORRECT CODE
		Node tNode = new Node(t,null);
		if ( isEmpty() )
		{
			head = tNode;	
		}
		else
	    {
			tail.next = tNode;
		}
		tail = tNode;
        return;
	}

	String deq() 
	{ 
		// REPLACE THE FOLLOWING LINE WITH THE CORRECT CODE
		if ( !isEmpty() )
		{
			String t = head.item;
			head = head.next;

			if (head == null)
			{
				tail = null;
			}
			return t;
		}
		return null;
		
	}
  
    public String toString()
	{
		// REPLACE THE FOLLOWING LINE WITH THE CORRECT CODE

        if ( !isEmpty() )
		{  
            Node tNode = head;
            String str = tNode.item;
			while (tNode.next != null)
			{
				tNode = tNode.next;
                str = str + " -> " + tNode.item;
			}
			return str;
		}
		return null;
		//return "";
    }

}

class MyQueueTest 
{
	public static void main(String[] args)
	{
		MyQueue q = new MyQueue();
		
		if(q.isEmpty())
			System.out.println("queue is empty");
		else 
			System.out.println("queue is not empty");
		
		q.enq("cow"); 
		
		if(q.isEmpty())
			System.out.println("queue is empty");
		else 
			System.out.println("queue is not empty");   
		

		System.out.println(q.deq() + " ");

		if(q.isEmpty()) 
			System.out.println("queue is empty");
		else 
			System.out.println("queue is not empty");   
		
		System.out.println("1 "+q.toString());
		q.enq("cat"); 
		q.enq("ant"); 
		q.enq("cat"); 
		System.out.println("2 "+q.toString());
		
		System.out.print(q.deq() + " "); 
		System.out.print(q.deq() + " "); 
		System.out.print(q.deq() + " ");
		System.out.println();
		
		if (q.deq()==null) 
			System.out.println("queue is empty");
		else 
			System.out.println("queue is not empty");
		
		System.out.println("3 "+q.toString());
		q.enq("pig");
		q.enq("pig");
		q.enq("rat"); 
		q.enq("fox"); 
	    System.out.println("4 "+q.toString());
	}
}


/*

>javac MyQueueTest.java

>java MyQueueTest
queue is empty
queue is not empty
cow
queue is empty
cat ant cat
queue is empty
null
pig pig rat fox

*/
        
        