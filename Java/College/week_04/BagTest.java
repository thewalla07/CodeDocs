class Bag<T> {// generic class with T standing for a class

    private T[] bag = (T[])(new Object[100000]);
    private int numElements = 0; // junk in bag[numElements..]
    
    void add(T x) { // put x in bag
			bag[numElements] = x; numElements++;
    }
    
    int freq(T x) { // how many x’s in bag?
			int count = 0;
			for (int i=0; i<numElements; i++)
				if (bag[i].equals(x)) // .equals because T a class
					count++;
			return count;
    }
    
    void remove(T x) {
      
      for (int i = 0; i<numElements-1; i++){
        while(bag[numElements-1].equals(x))
          numElements--;
        while(bag[i].equals(x)){
          bag[i] = bag[numElements-1];
          numElements--;
        }
      }
    }
    
    
}

class BagTest{
  public static void main(String [] args){
		Bag<String> b = new Bag<String>();
		for(int i = 0; i <10000; i++){
		  int r = (int)(Math.random()*3) + 1;
		  if(r == 1)b.add("cat");
		  if(r == 2)b.add("dog");
		  if(r == 3)b.add("horse");
		}
		b.add("cat"); b.add("dog"); b.add("horse"); b.add("dog"); b.add("horse"); b.add("dog"); b.add("horse");
		System.out.println("Num of cats is : " + b.freq("cat")); // see output 2
		System.out.println("Num of dogs is : " + b.freq("dog")); // see output 2
		System.out.println("Num of horses is : " + b.freq("horse")); // see output 2
		b.remove("horse");
		System.out.println("Num of cats is : " + b.freq("cat")); // see output 2
		System.out.println("Num of dogs is : " + b.freq("dog")); // see output 2
		System.out.println("Num of horses is : " + b.freq("horse")); // see output 2
  }
}