class League{
  public static void main(String [] args){
    HashMap<String, String> tab = new HashMap<>();
    while(!Console.endOfFile()){
      String name = Console.readToken();
      String score = Console.readToken();
      
      tab.put(name, score);
      
    }
    tab.sort();
  }
}