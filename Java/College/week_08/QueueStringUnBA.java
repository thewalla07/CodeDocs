public class QueueStringUnBA       // UnBounded Array
{                              

	private String[] seq;            // the sequence,
	private int size = 0;            // size of sequence,
	private int head = 0;            // front,
	private int tail = 0;            // rear.

	QueueStringUnBA()
	{
		seq = new String[1];
	} 
	
	QueueStringUnBA(int n) 
	{   // n > 0
		seq = new String[1]; 
	}

	boolean isEmpty() 
	{
		return size==0;
	}

	boolean enq(String t) 
	{       
		if (size==seq.length) 
		{
			String[] temp = new String[2*seq.length];
			int i = 0; 
			int k = head;
			while (i<size) 
			{
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

	String deq() 
	{
		if (isEmpty()) 
			return null;
		else 
		{
			String temp = seq[head];
			head = (head+1)%seq.length; 
			size--;
			return temp;
		}
	}

	public String toString()
    {
	    String  str   = "";
	   
		if ( !isEmpty() )
		{
		   int i = head; 

           while ( i != tail )
           {
	 	      str  =  str + seq[i]+" -> ";

			  i    =  (i+1) % seq.length; 
           }  
		}
		str   = str + "null";
        return str;  
     }



}
