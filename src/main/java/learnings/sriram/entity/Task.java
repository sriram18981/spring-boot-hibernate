package learnings.sriram.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private int id;
	private String taskName;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="emp_id", referencedColumnName="id")
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Task() { super(); }
	
	public Task(String taskName) { super(); this.taskName=taskName; }

	public Task(int id, String taskName) {
		super();
		this.id = id;
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", employees=" + employees + "]";
	}
	
	
	
}
