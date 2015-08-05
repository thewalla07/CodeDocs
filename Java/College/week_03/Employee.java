class Employee{
	private String name, department;
	
	Employee(String n0, String d0){
		name = n0;
		department = d0;
	}
	
	void put(){
		System.out.print(name + ": " + department + " ");
	}
	
	boolean equals(Employee e){
		return (name.compareTo(e.name)==0 && department.compareTo(e.department)==0);
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
		System.out.print("(" + trade + ")");
	}
}

class Staff{
	//We are magicians
	private Employee [] team = new Employee[30];
	private int count = 0;
	
	void hire(Employee e){
		team [count] = e;
		count++;
	}

	void fire(Employee e){
		int i = 0;
		while(!e.equals(team[i])){
			i++;
		}
		team[i] = null;
		while(i<count){
			team[i] = team[i++];
			i++;
		}
		count--;
	}
	
	void put(){
		for(Employee e: team){
			e.put();
			System.out.println();
		}
	}
}

class StaffTest{
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
		personnel.hire(e1); personnel.hire(e2); 
		personnel.hire(e3); personnel.hire(e4); 
		personnel.hire(e5); personnel.hire(e6);
		personnel.hire(e7); personnel.hire(e8); 
		personnel.hire(e9); 
		personnel.put(); System.out.println();
		personnel.fire(e1); personnel.fire(e5); 
		personnel.fire(e9);
		personnel.put(); System.out.println();
		personnel.fire(new Tradesman(
						"Eddy", "Finishing", "Painter"));				personnel.put(); 
	}

}






























