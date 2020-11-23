package EmpSalary;

import java.util.Scanner;

public  class TestEMD{
	static Scanner sc = new Scanner(System.in);
	static Employee[] em = new Employee[100];
	
	public static void caoZuo() {
		System.out.println("----工資管理系統----");
		System.out.println("-------------------------------------");
		System.out.println("---1增加---");
		System.out.println("---2刪除---");
		System.out.println("---3修改---");
		System.out.println("---4查詢---");
		System.out.println("---0退出---");
		System.out.println("請輸入你要選擇的操作");
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
				System.out.println("指令錯誤請重新輸入");
				caoZuo();
				break;
		}
	}
	
	public static void addEmployee() {
		System.out.println("---增加員工---");
		System.out.println("請輸入相關資訊");
		System.out.println("ID:");
		String id = sc.next();
		System.out.print("姓名");
		String name  = sc.next();
		System.out.print("職務");
		String position = sc.next();
		System.out.println("請假天數");
		int holiday = sc.nextInt();
		System.out.print("基本工資:");
		double salary = sc.nextDouble();
		switch(position) {
		case "普通員工":
			Employee a = new CommonEmployee();
			a.ID = id;
			a.name = name;
			a.position = "普通員工";
			a.holiday = holiday;
			a.salary = salary;
			a.sumSalary();
			for(int i = 0; i<100; i++) {
				if(em[i] == null) {
					em[i] = a;
					System.out.println("新增成功!");
					em[i].display();
					break;
				}else {
					continue;
				}
			}
			break;
		case "經理":
			Employee b =new Manager();
			b.ID = id;
			b.name = name;
			b.position = "經理";
			b.holiday = holiday;
			b.salary = salary;
			b.sumSalary();
			for (int i =0; i<100; i++) {
				if(em[i] == null) {
					em[i] = b;
					System.out.println("新增成功!");
					em[i].display();
					break;
				}else{
					continue;
				}
			}
			break;
		case "董事長":
			Employee c = new Director();
			c.ID = id;
			c.name = name;
			c.position = "董事長";
			c.holiday = holiday;
			c.salary = salary;
			c.sumSalary();
			for(int i = 0; i<100; i++) {
				if(em[i] == null) {
					em[i] = c;
					System.out.println("新增成功!");
					em[i].display();
					break;
				}else{
					continue;
				}
			}
			break;
			default:
			System.out.println("不存在此職務，請重新輸入!");
			addEmployee();
			break;
		}
		caoZuo();
	}
	
	public static void delEmployee() {
		System.out.println("----刪除員工----");
		System.out.println("請輸入員工姓名: ");
		String n = sc.next();
		for(int i=0; i<100; i++) {
			if(em[i] != null) {
				if(em[i].name.equals(n)) {
					System.out.println("你要刪除的是:"+ em[i].toString());
					System.out.println("你確定要刪除嗎?\n [Y]確定，[N]取消");
					String s =sc.next();
					if(s.equals("y")) {
						em[i] = null;
						System.out.println("刪除成功!");
						try {
							Thread.sleep(2000);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
						caoZuo();
					}else if (s.equals("n")) {
						caoZuo();
					}else {
						System.out.println("輸入指定不正確，請重新輸入!");
						delEmployee();
					}
				}
				}else {
					if(i!=99) {
						continue;
					}else {
						System.out.println("你輸入的帳號不存在!請重新輸入");
						delEmployee();
					}
				}
			}
		}
		
		public static void updateEmployee() {
			System.out.println("----修改員工資料----");
			System.out.println("請輸入你要修改姓名");
			String s = sc.next();
			out:for(int i =0; i<100; i++) {
				if(em[i] !=null) {
					if(em[i].name.equals(s)) {
						System.out.println("你要修改的是:");
						em[i].display();
						System.out.println("請重新輸入相關資訊:");
						System.out.println("ID: ");
						String id = sc.next();
						System.out.println("姓名");
						String name = sc.next();
						System.out.print("職務:");
						String position = sc.next();
						System.out.print("請假天數:");
						int holiday = sc.nextInt();
						System.out.println("基本工資");
						double salary = sc.nextDouble();
						switch(position) {
						case "普通員工":
							if(em[i].position.equals("普通員工")) {
								em[i].ID = id;
								em[i].name = name;
								em[i].position = position;
								em[i].holiday = holiday;
								em[i].salary = salary;
								em[i].sumSalary();
								System.out.println("修改成功!");
								em[i].display();
							}else {
								em[i] = null;
								Employee a = new CommonEmployee();
								a.ID = id;
								a.name = name;
								a.position = "普通員工";
								a.holiday = holiday;
								a.salary = salary;
								a.sumSalary();
								for(int j = 0; j<100 ;j++) {
									if(em[j] == null) {
										em[j] = a;
										System.out.println("修改成功!");
										em[j].display();
										break;
									}else {
										continue;
									}
								}
							}
							break;
						case "經理":
							if(em[i].position.equals("經理")) {
								em[i].ID = id;
								em[i].name = name;
								em[i].position = position;
								em[i].holiday = holiday;
								em[i].salary = salary;
								em[i].sumSalary();
								System.out.println("修改成功!");
								em[i].sumSalary();
							}else {
								em[i] = null;
								Employee b = new Manager();
								b.ID = id;
								b.name = name;
								b.position = "經理";
								b.holiday = holiday;
								b.salary = salary;
								b.sumSalary();
								for(int j = 0; j<100; j++) {
									if(em[j] == null) {
										em[j] = b;
										System.out.println("修改成功!");
										em[j].display();
										break;
									}else{
										continue;
									}
								}
							}
							
							break;
						case "董事長":
							if(em[i].position.equals("董事長")) {
								em[i].ID = id;
								em[i].name = name;
								em[i].position = position;
								em[i].holiday = holiday;
								em[i].salary = salary;
								em[i].sumSalary();
								System.out.println("修改成功!");
								em[i].display();
							}else {
								em[i] = null;
								Employee c = new Director();
								c.ID = id;
								c.name = name;
								c.position = "董事長";
								c.holiday = holiday;
								c.salary = salary;
								c.sumSalary();
								for(int j=0; j<100; j++) {
									if(em[j] == null) {
										em[j] = c;
										System.out.println("新增成功!");
										em[j].display();
										break;
									}else {
										continue;
									}
								}
							}
							break;
							default:
								System.out.println("不存在此職務，請重新輸入!");
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
							System.out.println("你輸入的員工不存在!請重新輸入!");
							caoZuo();
						}
					}
				}else {
					if( i != 99) {
						continue out;
					}else {
						System.out.println("你輸入的員工不存在!請重新輸入!");
						caoZuo();
					}
				}
			}
		}
		
		public static void queryEmployee() {
			System.out.println("----所有員工資訊----");
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
