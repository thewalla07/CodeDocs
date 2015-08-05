public class QueueDemo
{
       public static void main(String[] args)
	   {
	          QueueStringLN             q = new QueueStringLN();

		   // QueueGenericLN<String>    q = new QueueGenericLN<>();

	       // QueueStringUnBA           q = new QueueStringUnBA();  

		   // QueueGenericUnBA<String>  q = new QueueGenericUnBA<>();
               
			  System.out.println("\n----- Before enqueuing or dequeuing -----------------\n");
			  System.out.println("q.isEmpty()  is "+q.isEmpty()  );
			  System.out.println("q.toString() is "+q.toString() );
             
			  q.enq("A");  
			  q.enq("B");
			  q.enq("C");
			  q.enq("D");
			  q.enq("E");
			  System.out.println("\n----- After enqueuing A B C D E to queue ------------\n");

			  System.out.println("q.isEmpty()  is "+q.isEmpty()  );
			  System.out.println("q.toString() is "+q.toString() );

             
              String firstStringRemoved   =  q.deq();
			  String secondStringRemoved  =  q.deq(); 

			  System.out.println("\n----- After dequeuing "+firstStringRemoved+" and "+secondStringRemoved+" -----------------------\n");

			  System.out.println("q.isEmpty()  is "+q.isEmpty()  );
			  System.out.println("q.toString() is "+q.toString() );


			  System.out.println("\n----- After enqueuing A and B again -----------------\n");
			  q.enq("A");  
			  q.enq("B");

			  System.out.println("q.isEmpty()  is "+q.isEmpty()  );
			  System.out.println("q.toString() is "+q.toString() );

			  System.out.println("\n----- After dequeuing everything and adding A and B again \n");
			  
			  while( !q.isEmpty() )   // while q is not empty 
		      {
			     q.deq();
			  }

			  q.enq("A");  
			  q.enq("B");
			  
			  System.out.println("q.isEmpty()  is "+q.isEmpty()  );
			  System.out.println("q.toString() is "+q.toString() ); 
	   }
}

/*
QueueStringLN             is a queue for Strings implemented using Linked Nodes

QueueGenericUnBA<String>  is a queue for Generic types implemented using an UnBounded Array

Below is the output when is q is a QueueStringLN object, a QueueGenericLN<String> object,
a QueueStringUnBA object and also a QueueGenericUnBA<String> object.

>javac QueueDemo.java

>java QueueDemo

----- Before enqueuing or dequeuing -----------------

q.isEmpty()  is true
q.toString() is null

----- After enqueuing A B C D E to queue ------------

q.isEmpty()  is false
q.toString() is A -> B -> C -> D -> E -> null

----- After dequeuing A and B -----------------------

q.isEmpty()  is false
q.toString() is C -> D -> E -> null

----- After enqueuing A and B again -----------------

q.isEmpty()  is false
q.toString() is C -> D -> E -> A -> B -> null

----- After dequeuing everything and adding A and B again

q.isEmpty()  is false
q.toString() is A -> B -> null


*/




