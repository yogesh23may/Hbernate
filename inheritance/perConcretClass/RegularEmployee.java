package perConcretClass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="REGULAR_EMPLOYEE")
@AttributeOverrides({
	@AttributeOverride(name="id",column=@Column(name="ID")),
	@AttributeOverride(name="name",column=@Column(name="NAME"))
})
public class RegularEmployee extends Employee{
	
	@Column(name="SALARY")
	private float salary;
	
	@Column(name="BONUS")
	private int bonus;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
