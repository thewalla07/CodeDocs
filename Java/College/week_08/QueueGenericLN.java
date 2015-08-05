public class QueueGenericLN<T>
{
//-------------------------------------------------------
    private static class Node<T> 
	{ 
       private T       item;          // data in node 
       private Node<T> next = null;   // successor node 
       
	   Node(T item0, Node<T> next0) 
	   { 
           item = item0; 
		   next = next0;
	   }
	}
//-------------------------------------------------------
	private Node<T> head = null; // (reference to) first node
    private Node<T> tail = null; // (reference to) last node; 
       
	boolean isEmpty() 
	{
		    if (head == null && tail == null)
		    {
			   return true;
		    }
            return false;
    }

    boolean enq(T t)   
	{ 
		 Node<T> tNode = new Node<>(t,null);

         if ( isEmpty() )
         {		
		     head = tNode;				
         }
	     else
		 {   
			 tail.next  = tNode;
	     }
         tail = tNode;
         return true;
    }
       
	T deq() 
	{ 
	    if ( !isEmpty() )
	    { 
	  	    if (head.next == null)
			{
			    T      t = head.item;
				head     = null;
				tail     = null;
				return t;
		    }
			else
			{
			    T      t  = head.item;
			    head      = head.next;
			    return t;
			}
		}
        return null;


		/* Below is Joe's code
		if (isEmpty()) 
			return null;
		
		T t = head.item;
		
		head = head.next; 
		
		if (head==null) 
			tail = null;
		
		return t;	
		*/
    }

    public String toString()
    {
	    String  str   = "";
	    Node<T> pNode = head; 
		
		if ( !isEmpty() )
		{
           while (pNode != null )
           {
	 	      str   = str + pNode.item+" -> ";
			  pNode = pNode.next;
           }
		}
		str   = str + "null";
        return str;  
     }
}
