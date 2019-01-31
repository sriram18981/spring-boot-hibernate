package learnings.sriram.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="Employee_Details")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Employee_Type")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="Employee_Id")
	private int empId;
	private String name;
	private String city;
	private String state;
	private String zip;
	
	
	public Employee() {super(); }
	
	public Employee(int id, String name, String city, String state, String zip) {
		super();
		this.empId = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}


	public Employee(int id, String name) {
		super();
		this.empId = id;
		this.name = name;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + empId + ", name=" + name + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", tasks=" + tasks + "]";
	}

	@ManyToMany
	@JoinColumn(name="task_id", referencedColumnName="id")
	private List<Task> tasks;

	public int getId() {
		return empId;
	}

	public void setId(int id) {
		this.empId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + empId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (empId != other.empId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
