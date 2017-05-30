package com.ullas.collections;

import java.util.HashMap;
import java.util.Map;

public class HashCodeEqualsContact {

	public static void main(String[] args) {
		Map <Employee,String> map= loadEmployee();
		Employee e= new Employee(1, "ullas");
		String name= map.get(e);
		System.out.println(name);
		
	}
	public static Map<Employee,String> loadEmployee (){
		Map<Employee, String> map = new HashMap<>();
		Employee e1=new  Employee(1,"ullas");
		Employee e2=new  Employee(1,"sagar");
		Employee e3=new  Employee(1,"gora");
		map.put(e1, "u");
		map.put(e2, "s");
		map.put(e3, "g");
		return map;
	}

}
class Employee{
	int empId;
	String Name;
	
	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		Name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + empId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (empId != other.empId)
			return false;
		return true;
	}
	
	
}