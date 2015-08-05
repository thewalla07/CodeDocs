import java.util.*;
class League{
  public static void main(String [] args){
    TreeMap<String, String> tab = new TreeMap<>();
    while(!Console.endOfFile()){
      String name = Console.readToken();
      String score = Console.readToken();
      tab.put(name, score);
    }
    Set<String> teams = tab.keySet(); // Note type of variable
		for (String w: teams)
			System.out.printf("%-20s %5s\n", w, tab.get(w));
  }
}

class FrequencyCount {
	public static void main(String[] args) {
		TreeMap<String,Integer>  map = new TreeMap<>();
									// (word,frequency) map
		while (!Console.endOfFile()) {
			String word = Console.readToken();
			if (!map.containsKey(word))  // first occurrence of word
				map.put(word, 1);  // (using autoboxing for 1)
			else  // word already occurred
				map.put(word, map.get(word)+1); // autoboxing/unboxing
		}
		Set<String> words = map.keySet(); // Note type of variable
		System.out.println("test");
		for (String w: words)
			System.out.printf("%-20s %5d\n", w, map.get(w));
	}
}