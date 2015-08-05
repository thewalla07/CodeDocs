public class QueueStringLN
{
//-------------------------------------------------------
    private static class Node 
	{ 
       private String item;          // data in node 
       private Node   next = null;   // successor node 
       
	   Node(String item0, Node next0) 
	   { 
           item = item0; 
		   next = next0;
	   }
	}
//-------------------------------------------------------
	private Node head = null; // (reference to) first node
    private Node tail = null; // (reference to) last node; 
       
	boolean isEmpty() 
	{
		    if (head == null && tail == null)
		    {
			   return true;
		    }
            return false;
    }

    void enq(String t)   
	{ 
         Node tNode = new Node(t, null);   	
         if ( isEmpty() )
         {		
			 // System.out.println("queue is empty ");
		     head = tNode;				
         }
	     else
		 {   
			 // System.out.println("queue is not empty ");
			 tail.next  = tNode;
	     }
         tail = tNode;
         return;
    }
       
	String deq() 
	{ 
	    if ( !isEmpty() )
	    { 
	  	    if (head.next == null)
			{
			    String t = head.item;
				head     = null;
				tail     = null;
				return t;
		    }
			else
			{
			    String t  = head.item;
			    head      = head.next;

			    return t;
			}
		}
        return null;
    }

    public String toString()
    {
	    String str = "";
	    Node pNode = head; 
		
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

