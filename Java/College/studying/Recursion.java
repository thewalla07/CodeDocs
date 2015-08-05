class Recursion{
  static int power(int m, int n){
    if (n==0) return 1;
    return m*power(m,n-1);
  }
  
  static String reverse(String s){
    if (s.equals(""))return "";
      else return reverse(s.substring(1))+s.substring(0,1);
  }
  public static void main(String [] args){
    System.out.println(power(2,19));
    System.out.println(reverse("Cat-tastic"));
  }
}