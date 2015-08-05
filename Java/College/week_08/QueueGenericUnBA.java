public class QueueGenericUnBA<T> 
{                               // unbounded

	private T[] seq;            // the sequence
	private int size = 0;       // size of sequence
	private int head = 0; 
	private int tail = 0;       // front, rear

	QueueGenericUnBA()
	{
		seq = (T[])(new Object[1]);
	} 
	
	QueueGenericUnBA(int n) 
	{   // n > 0
		seq = (T[])(new Object[1]); 
	}

	boolean isEmpty() 
	{
		return size==0;
	}

	boolean enq(T t) 
	{       
		if (size==seq.length) 
		{
			T[] temp = (T[])(new Object[2*seq.length]);
			int i = 0; int k = head;
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

	T deq() 
	{
		if (isEmpty()) 
			return null;
		else 
		{
			T temp = seq[head];
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
