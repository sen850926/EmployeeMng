package EmpSalary;

import java.util.Scanner;

public  class TestEMD{
	static Scanner sc = new Scanner(System.in);
	static Employee[] em = new Employee[100];
	
	public static void caoZuo() {
		System.out.println("----�u��޲z�t��----");
		System.out.println("-------------------------------------");
		System.out.println("---1�W�[---");
		System.out.println("---2�R��---");
		System.out.println("---3�ק�---");
		System.out.println("---4�d��---");
		System.out.println("---0�h�X---");
		System.out.println("�п�J�A�n��ܪ��ާ@");
		Scanner sc = new Scanner(System.in);
		String s =sc.next();
		switch(s) {
		case "1":
			addEmployee();
			break;
		case "2":
			delEmployee();
			break;
		case "3":
			updateEmployee();
			break;
		case "4":
			queryEmployee();
			break;
			default:
				System.out.println("���O���~�Э��s��J");
				caoZuo();
				break;
		}
	}
	
	public static void addEmployee() {
		System.out.println("---�W�[���u---");
		System.out.println("�п�J������T");
		System.out.println("ID:");
		String id = sc.next();
		System.out.print("�m�W");
		String name  = sc.next();
		System.out.print("¾��");
		String position = sc.next();
		System.out.println("�а��Ѽ�");
		int holiday = sc.nextInt();
		System.out.print("�򥻤u��:");
		double salary = sc.nextDouble();
		switch(position) {
		case "���q���u":
			Employee a = new CommonEmployee();
			a.ID = id;
			a.name = name;
			a.position = "���q���u";
			a.holiday = holiday;
			a.salary = salary;
			a.sumSalary();
			for(int i = 0; i<100; i++) {
				if(em[i] == null) {
					em[i] = a;
					System.out.println("�s�W���\!");
					em[i].display();
					break;
				}else {
					continue;
				}
			}
			break;
		case "�g�z":
			Employee b =new Manager();
			b.ID = id;
			b.name = name;
			b.position = "�g�z";
			b.holiday = holiday;
			b.salary = salary;
			b.sumSalary();
			for (int i =0; i<100; i++) {
				if(em[i] == null) {
					em[i] = b;
					System.out.println("�s�W���\!");
					em[i].display();
					break;
				}else{
					continue;
				}
			}
			break;
		case "���ƪ�":
			Employee c = new Director();
			c.ID = id;
			c.name = name;
			c.position = "���ƪ�";
			c.holiday = holiday;
			c.salary = salary;
			c.sumSalary();
			for(int i = 0; i<100; i++) {
				if(em[i] == null) {
					em[i] = c;
					System.out.println("�s�W���\!");
					em[i].display();
					break;
				}else{
					continue;
				}
			}
			break;
			default:
			System.out.println("���s�b��¾�ȡA�Э��s��J!");
			addEmployee();
			break;
		}
		caoZuo();
	}
	
	public static void delEmployee() {
		System.out.println("----�R�����u----");
		System.out.println("�п�J���u�m�W: ");
		String n = sc.next();
		for(int i=0; i<100; i++) {
			if(em[i] != null) {
				if(em[i].name.equals(n)) {
					System.out.println("�A�n�R�����O:"+ em[i].toString());
					System.out.println("�A�T�w�n�R����?\n [Y]�T�w�A[N]����");
					String s =sc.next();
					if(s.equals("y")) {
						em[i] = null;
						System.out.println("�R�����\!");
						try {
							Thread.sleep(2000);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
						caoZuo();
					}else if (s.equals("n")) {
						caoZuo();
					}else {
						System.out.println("��J���w�����T�A�Э��s��J!");
						delEmployee();
					}
				}
				}else {
					if(i!=99) {
						continue;
					}else {
						System.out.println("�A��J���b�����s�b!�Э��s��J");
						delEmployee();
					}
				}
			}
		}
		
		public static void updateEmployee() {
			System.out.println("----�ק���u���----");
			System.out.println("�п�J�A�n�ק�m�W");
			String s = sc.next();
			out:for(int i =0; i<100; i++) {
				if(em[i] !=null) {
					if(em[i].name.equals(s)) {
						System.out.println("�A�n�ק諸�O:");
						em[i].display();
						System.out.println("�Э��s��J������T:");
						System.out.println("ID: ");
						String id = sc.next();
						System.out.println("�m�W");
						String name = sc.next();
						System.out.print("¾��:");
						String position = sc.next();
						System.out.print("�а��Ѽ�:");
						int holiday = sc.nextInt();
						System.out.println("�򥻤u��");
						double salary = sc.nextDouble();
						switch(position) {
						case "���q���u":
							if(em[i].position.equals("���q���u")) {
								em[i].ID = id;
								em[i].name = name;
								em[i].position = position;
								em[i].holiday = holiday;
								em[i].salary = salary;
								em[i].sumSalary();
								System.out.println("�ק令�\!");
								em[i].display();
							}else {
								em[i] = null;
								Employee a = new CommonEmployee();
								a.ID = id;
								a.name = name;
								a.position = "���q���u";
								a.holiday = holiday;
								a.salary = salary;
								a.sumSalary();
								for(int j = 0; j<100 ;j++) {
									if(em[j] == null) {
										em[j] = a;
										System.out.println("�ק令�\!");
										em[j].display();
										break;
									}else {
										continue;
									}
								}
							}
							break;
						case "�g�z":
							if(em[i].position.equals("�g�z")) {
								em[i].ID = id;
								em[i].name = name;
								em[i].position = position;
								em[i].holiday = holiday;
								em[i].salary = salary;
								em[i].sumSalary();
								System.out.println("�ק令�\!");
								em[i].sumSalary();
							}else {
								em[i] = null;
								Employee b = new Manager();
								b.ID = id;
								b.name = name;
								b.position = "�g�z";
								b.holiday = holiday;
								b.salary = salary;
								b.sumSalary();
								for(int j = 0; j<100; j++) {
									if(em[j] == null) {
										em[j] = b;
										System.out.println("�ק令�\!");
										em[j].display();
										break;
									}else{
										continue;
									}
								}
							}
							
							break;
						case "���ƪ�":
							if(em[i].position.equals("���ƪ�")) {
								em[i].ID = id;
								em[i].name = name;
								em[i].position = position;
								em[i].holiday = holiday;
								em[i].salary = salary;
								em[i].sumSalary();
								System.out.println("�ק令�\!");
								em[i].display();
							}else {
								em[i] = null;
								Employee c = new Director();
								c.ID = id;
								c.name = name;
								c.position = "���ƪ�";
								c.holiday = holiday;
								c.salary = salary;
								c.sumSalary();
								for(int j=0; j<100; j++) {
									if(em[j] == null) {
										em[j] = c;
										System.out.println("�s�W���\!");
										em[j].display();
										break;
									}else {
										continue;
									}
								}
							}
							break;
							default:
								System.out.println("���s�b��¾�ȡA�Э��s��J!");
								addEmployee();
								break;
						}
						
						try {
							Thread.sleep(2000);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
						caoZuo();
					}else {
						if(i != 99) {
							continue out;
						}else {
							System.out.println("�A��J�����u���s�b!�Э��s��J!");
							caoZuo();
						}
					}
				}else {
					if( i != 99) {
						continue out;
					}else {
						System.out.println("�A��J�����u���s�b!�Э��s��J!");
						caoZuo();
					}
				}
			}
		}
		
		public static void queryEmployee() {
			System.out.println("----�Ҧ����u��T----");
			for(int i=0; i<100; i++) {
				if(em[i] != null) {
					em[i].display();
				}
			}
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			caoZuo();
		}
		
		public static void main(String[] args) {
			TestEMD.caoZuo();
		}
	}
