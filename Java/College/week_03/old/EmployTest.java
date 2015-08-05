import java.util.*;
class Employee{
	private String name, dept;
	
	Employee(String name0, String dept0){
		name = name0;
		dept = dept0;
	}

	Employee(){
		name = ""; dept = "";
	
	}
	
	void put(){
		System.out.println(name+" from "+dept);
	}
	
	boolean equals(Employee e){
		return name==e.name && dept==e.dept;
	}
}

class Tradesman extends Employee{
	private String trade;
	
	Tradesman(String n0, String d0, String t0){
		super(n0, d0);
		trade = t0;
	}
	
	void put(){
		super.put();
		System.out.println("		Trade: "+trade);
	}
}

class Staff{
	private ArrayList<Employee> team = new ArrayList<Employee>();
	
	void hire(Employee e){
		team.add(e);
	}
	
	void fire(Employee e){
		int i = 0;
		while(!team.get(i).equals(e)){
			i++;
		}
		team.remove(i);
	}
	
	void put(){
		for(Employee e: team) if(e!=null)e.put();
	}
}


class EmployTest{
	public static void main(String[] args) {  
		Staff personnel = new Staff();
		Employee e1 = new Employee("Mike","Sales");
		Employee e2 = new Tradesman(
						"Fred","Engineering","Welder");
		Employee e3 = new Employee("Pat","Sales");
		Employee e4 = new Tradesman(
						"Jean","Finishing", "Painter");
		Employee e5 = new Employee("Bill","Marketing");
		Employee e6 = new Tradesman(
						"Anne","Engineering", "Fitter");
		Employee e7 = new Tradesman(
						"Paul","Design", "Draughtsman");
		Employee e8 = new Tradesman(
						"Eddy","Finishing","Painter");
		Employee e9 = new Employee("John","Despatch"); 
		personnel.hire(e1); 
		personnel.hire(e2); 
		personnel.hire(e3); 
		personnel.hire(e4); 
		personnel.hire(e5); 
		personnel.hire(e6);
		personnel.hire(e7); 
		personnel.hire(e8); 
		personnel.hire(e9); 
		System.out.println("\nNew Team is: =============================================\n");
		personnel.put(); 
		System.out.println("\nNew Team is: =============================================\n");
		personnel.fire(e1); 
		personnel.fire(e5); 
		personnel.fire(e9);
		personnel.put(); 
		System.out.println("\nNew Team is: =============================================\n");
		personnel.fire(new Tradesman("Eddy", "Finishing", "Painter"));				personnel.put(); 
	}

}