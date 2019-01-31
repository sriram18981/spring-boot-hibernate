package learnings.sriram.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PermanantEmployee extends Employee {
	
	private long salary;
	

	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public PermanantEmployee() { super(); }
	

	public PermanantEmployee(int id, String name, String city, String state, String zip) {
		super(id, name, city, state, zip);
	}

	public PermanantEmployee(int id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "PermanantEmployee [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
	
}
