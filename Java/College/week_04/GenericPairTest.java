class Pair <T, U> {//genreic class, where T and U stand for classes unknown.
  private T t;
  private U u;
  
  Pair(T t0, U u0){
    t = t0;
    u = u0;
  }
  
  public String toString(){
    return t + ", " + u;
  }
}

class GenericPairTest {

  public static void main(String[] args) {
    Pair<String,Integer> phoneNumber = new Pair<>("Bill's number", 1324);
    System.out.println(phoneNumber);
    Pair<Double,Double> point = new Pair<>(3.14, 2.32);
    System.out.println(point);
  }
}

// Bill's number 1324
// 3.14 2.32