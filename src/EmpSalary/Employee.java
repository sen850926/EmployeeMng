package EmpSalary;

import java.util.Scanner;

public class Employee {
	String ID;
	String name;
	String position;
	int holiday;
	double salary;
	public Employee() {}
	public void sumSalary() {}
	public void display() {
		System.out.println("ID:" +ID+"�P�m�W" +name+",¾��:" +position+",�а��Ѽ�:" +holiday+"�u��"+salary);
	}
}
	 class CommonEmployee extends Employee{
		@Override
		public void sumSalary() {
			super.salary= super.salary+super.salary*0.1+super.salary*0.5+200-super.holiday*(super.salary/30);
		}
	}
	
	 class Manager extends Employee{
		@Override
		public void sumSalary() {
			super.salary= super.salary+super.salary*0.2+super.salary*0.5+200-super.holiday*(super.salary/30);
		}
	}
	
	 class Director extends Employee{
		@Override
		public void sumSalary() {
			super.salary=super.salary+super.salary*0.08+super.salary*0.3+2000+3000-super.holiday*(super.salary/30);
		}
	}
	
	
	
