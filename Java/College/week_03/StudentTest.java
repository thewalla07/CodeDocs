class Student{
	private String name, programme;
	
	Student(String name0, String programme0){
		name = name0; programme = programme0;
	}
	
	void put(){
		System.out.print(name + ": " + programme);
	}
}

class PGStudent extends Student{
	private String supervisor;
	
	PGStudent(String name0, String programme0, String supervisor0){
		super(name0, programme0);
		supervisor = supervisor0;
	}
	
	void put(){
		super.put();
		System.out.print(" ("+ supervisor + ")");
	}
}

class StudentTest{
	private static void printout(Student[] students){
		for(Student s: students){
			s.put();
			System.out.println();
		}
	}

	public static void main(String [] args){
		Student[] students = {
			new Student("Mary Smith", "CA"),
			new PGStudent("Bill Smart", "PhD", "Dr Jim Murphy"),
			new Student("Pat Kelly", "EE")
		};
		printout(students);
	}
}