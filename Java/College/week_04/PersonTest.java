abstract class Person{
  private String name, address; //to be available in all extensions
  private boolean isMale;
  
  Person(String name0, String address0, boolean isMale0){
    name = name0; address = address0; isMale = isMale0;
  }
  
  abstract int completionYear(); //no body, but note is abstract
  
  void put(){
    System.out.print(name + " from " + address + ". ");
  }
  
}

class Student extends Person{
  private String studentNum, subject;
  private int yearOfStudy;
  
  Student(String n0, String ad0, boolean isM0, String sN0, String sub0, int year0){
    super(n0, ad0, isM0);
    studentNum = n0;
    subject = sub0;
    yearOfStudy = year0;
  }
  
  int completionYear(){
    return (2014 + 5 - yearOfStudy);
  }
  
  void put(){
    super.put();
    System.out.print("Student no: " + studentNum + " Subject: " + subject + " Expected completion date: (" + completionYear() + ")");
  }
}

class Lecturer extends Person{
  private String department, staffNum;
  
  Lecturer(String n0, String ad0, boolean isM0, String dep0, String stN0){
    super(n0, ad0, isM0);
    department = dep0;
    staffNum = stN0;
  }
  
  int completionYear(){
    return (2014 + 65 - Integer.parseInt(staffNum.substring(0,2)));
  }
  
  void put(){
    super.put();
    System.out.print("Staff no: " + staffNum + " Department: " + department + " Expected completion date: (" + completionYear() + ")");
  }
}

class PersonTest{
  public static void main(String[] args) {
    Person[] people = {
			new Student("Mike Smith","10 Main St", true, "5023765", "Computing", 2),
			new Lecturer("Kay Brown", "25 Side St", false, "Business", "3734564")
    };
    int i = 0;
    while(i<people.length){
      people[i].put();
      System.out.println();
      i++;
    }
	}
}