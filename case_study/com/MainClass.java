package com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.util.HibernateUtil;

public class MainClass {
	
	private static int dispCount1 = 1;
	private static int dispCount2 = 1;
	private static int dispCount3 = 1;
	
	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("casestudy");
		boolean create = false;
		boolean updateNew = false;
		if(session!=null){
			if(create){
				System.out.println("creating table structure...");
				System.out.println("==============================");
				//four states---------------------------------------------------------------------//
				State state1 = new State("221005","PUNJAB");
				State state2 = new State("421003","GUJARAT");
				State state3 = new State("560097","ORISSA");
				State state4 = new State("761005","KERALA");
				
				//two managers one department-----------------------------------------------------//
				Manager manager1 = new Manager("President");
				Manager manager2 = new Manager("Chairman");
				Set<Manager> managerSet1 = new HashSet<Manager>();
				managerSet1.add(manager1);managerSet1.add(manager2);
				
				Department department1 = new Department("Electical");
				Set<Department> departmentSet1 = new HashSet<Department>();
				departmentSet1.add(department1);
			
				manager1.setDepartmentSet(departmentSet1);
				manager2.setDepartmentSet(departmentSet1);
				department1.setManagerSet(managerSet1);
				
				//two department one managers-----------------------------------------------------//
				Manager manager3 = new Manager("Director");
				Set<Manager> managerSet2 = new HashSet<Manager>();
				managerSet2.add(manager3);
				
				Department department2 = new Department("Computing");
				Department department3 = new Department("Payroll");
				Set<Department> departmentSet2 = new HashSet<Department>();
				departmentSet2.add(department2);departmentSet2.add(department3);
				
				manager3.setDepartmentSet(departmentSet2);
				department2.setManagerSet(managerSet2);
				department2.setManagerSet(managerSet2);
				
				//persisting states,managers and departments
				try{
					session.beginTransaction();
						session.save(state1);session.save(state2);session.save(state3);session.save(state4);
						session.save(manager1);session.save(manager2);session.save(manager3);
						session.save(department1);session.save(department2);session.save(department3);
						System.out.println("data saved successfully !!!");
					session.getTransaction().commit();	
				}catch(Exception e){
					System.out.println("exception caught in creating !!!");
					System.out.println(e.getMessage());
					session.getTransaction().rollback();
				}
				
					
			}else if(updateNew){
				System.out.println("updating data in table...");
				System.out.println("==============================");
				try{
					session.beginTransaction();
					Manager manager1 = (Manager) session.get(Manager.class,1);
					Department department1 = (Department) session.get(Department.class,1);
					State state1 = (State) session.get(State.class,1);
					
					//two employees with one state ,manager and department
					Employee employee1 = new Employee("Gabriel", "SouthAmerica", "Brazil","8880376971");
					employee1.setManager(manager1);
					employee1.setDepartment(department1);
					employee1.setState(state1);
					
					Employee employee2 = new Employee("Rivendell","LA" ,"LittleAndaman","9945564050");
					employee2.setManager(manager1);
					employee2.setDepartment(department1);
					employee2.setState(state1);
					
					//persisting employees
					session.save(employee1);
					session.save(employee2);
					session.getTransaction().commit();	
				}catch(Exception e){
					System.out.println("exception caught in updateNew !!!");
					System.out.println(e.getMessage());
					session.getTransaction().rollback();
				}
			}else{
				System.out.println("retreiving data from table...");
				System.out.println("==============================");
				try{
					session.beginTransaction();
					MainClass mainObj = new MainClass();
					//displaying employee details
					mainObj.displayData(session,1,null,null);
					mainObj.displayData(session,2,null,null);
					mainObj.displaySeparator();
					
					//displaying manager details
					mainObj.displayData(session,null,1,null);
					mainObj.displayData(session,null,3,null);
					mainObj.displaySeparator();
					
					//displaying department details
					mainObj.displayData(session,null,null,1);
					mainObj.displayData(session,null,null,3);
					mainObj.displaySeparator();
					
					session.getTransaction().commit();
				}catch(Exception e){
					System.out.println("exception caught in retreivingData !!!");
					System.out.println(e.getMessage());
					session.getTransaction().rollback();
				}
			}
		}else{
			System.out.println("session creation failed");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
	
	public void displayData(Session session,Integer employeeId,Integer mgrId,Integer deptId){
		String key = "";
		if(employeeId!=null)key="emp";
		else if(mgrId!=null)key="mgr";
		else if(deptId!=null)key="dept";
		else key="default";
		switch (key) {
			case "emp":{	
					if(dispCount1>0){
						System.out.println("many employee can have one state,one manager,one department");
						System.out.println("employee can give state,manager & department,but vice-versa not true,so this is a MANY-TO-ONE UNIDIRECTIONAL relationship");
						System.out.println("employee details are:-");
						System.out.println("======================");
					}dispCount1=0;
					//Retrieving employee
					Employee employee = (Employee) session.get(Employee.class,employeeId);
					System.out.println(employee.getId() +"|"+ employee.getName() +"|"+ employee.getAddress() +"|"+ employee.getCity() +"|"+ employee.getPhone());
					System.out.println("\tstate details");
					System.out.println("\t=============");
					System.out.println("\t"+employee.getState().getId() +"|"+ employee.getState().getStatecode() +"|"+ employee.getState().getStateName());
					System.out.println("\tmanager details");
					System.out.println("\t===============");
					System.out.println("\t"+employee.getManager().getId() +"|"+ employee.getManager().getLevel());
					System.out.println("\tdepartment details");
					System.out.println("\t==================");
					System.out.println("\t"+employee.getDepartment().getId() +"|"+ employee.getDepartment().getName());
					System.out.println("----------------------------------------------");
			}
			break;
			case "mgr":{
					if(dispCount2>0){
						System.out.println("one manager can have many departments & one department can have many managers");
						System.out.println("one manager can give many department and vice-versa ,so this is a MANY-TO-MANY BI-DIRECTIONAL relationship");
						System.out.println("manager details are:-");
						System.out.println("======================");
					}dispCount2=0;
					//Retrieving manager
					Manager manager = (Manager) session.get(Manager.class,mgrId);
					System.out.println(manager.getId() +"|"+ manager.getLevel());
					System.out.println("\tdepartment details");
					System.out.println("\t==================");
					Set<Department> departmentSet = manager.getDepartmentSet();
					Iterator<Department> it =  departmentSet.iterator();
					while(it.hasNext()){
						Department department = it.next();
						System.out.println("\t"+department.getId() +"|"+ department.getName());
					}
					System.out.println("----------------------------------------------");
			}
			break;
			case "dept":{
				if(dispCount3>0){
					System.out.println("one department can have many managers & one manager can have many departments");
					System.out.println("one department can give many managers and vice-versa ,so this is a MANY-TO-MANY BI-DIRECTIONAL relationship");
					System.out.println("department details are:-");
					System.out.println("========================");
				}dispCount3=0;
				//Retrieving department
				Department department = (Department) session.get(Department.class, deptId);
				System.out.println(department.getId() +"|"+ department.getName());
				System.out.println("\tmanager details");
				System.out.println("\t==================");
				Set<Manager> managerSet = department.getManagerSet();
				Iterator<Manager> it = managerSet.iterator();
				while(it.hasNext()){
					Manager manager = it.next();
					System.out.println("\t"+manager.getId() +"|"+ manager.getLevel());
				}
				System.out.println("----------------------------------------------");
			}
			break;
			default:{
				System.out.println("neither employee nor manager nor department");
			}
			break;
		}
	}
	
	public void displaySeparator(){
		System.out.println("**************************************************************************************************************************");
	}
}
