package learnings.sriram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class ContractEmployee extends Employee {
	
	@Column(name="hourlyWage", nullable=true)
	private float hourlyWage;


	public float getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(float hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public ContractEmployee() {
		super();
	}

	public ContractEmployee(int id, String name, String city, String state, String zip) {
		super(id, name, city, state, zip);
	}

	public ContractEmployee(int id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "ContractEmployee [hourlyWage=" + hourlyWage + ", toString()=" + super.toString() + "]";
	}

}
