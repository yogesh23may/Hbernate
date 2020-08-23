package peClassHierarchy;

import javax.transaction.Transaction;

import org.hibernate.Session;
import com.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = new HibernateUtil().getSession("perClassHierarchy");
		if(session !=null){
			System.out.println("session creation successful...");
			Employee emp = new Employee();
			emp.setName("Rivendell");
			
			RegularEmployee rEmp = new RegularEmployee();
			rEmp.setName("Aragon");
			rEmp.setBonus(500);
			rEmp.setSalary(25000.00f);
			
			ContractEmployee cEmp = new ContractEmployee();
			cEmp.setName("Eowyn");
			cEmp.setPayPerHour(5000.00f);
			cEmp.setContractPeriod("10");
			
			session.beginTransaction();
			session.save(emp);
			session.save(rEmp);
			session.save(cEmp);
			session.getTransaction().commit();
		}else{
			System.out.println("session creation failed...");
			System.out.println("exitting !!!");
			System.exit(0);
		}
	}
}
