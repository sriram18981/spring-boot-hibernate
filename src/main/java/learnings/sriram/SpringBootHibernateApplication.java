package learnings.sriram;

import java.util.List;

import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import learnings.sriram.entity.Employee;
import learnings.sriram.entity.Student;
import learnings.sriram.entity.Task;
import learnings.sriram.repository.EmployeeRepository;
import learnings.sriram.repository.StudentRepository;
import learnings.sriram.repository.TaskRepository;

@SpringBootApplication
public class SpringBootHibernateApplication implements CommandLineRunner {
	
	private static Logger logger = LoggerFactory.getLogger(SpringBootHibernateApplication.class);

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentManipulations();

		empManipulations();
		
		
	}

	private void empManipulations() {
		logger.info("New task created -> {}",  taskRepo.save(new Task("Task1")));
		logger.info("New task created -> {}",  taskRepo.save(new Task("Tsask1")));
		
		Employee emp1 = new Employee("Emp1");
		empRepo.save(emp1);
		
		Task task1 = new Task("task with employee");
		task1.setEmployees(List.of(emp1));
		
		taskRepo.save(task1);
		
		logger.info("All emps -> {}", empRepo.findAll());
		logger.info("all Tasks -> {}", taskRepo.findAll());
		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	private void studentManipulations() {
		logger.info("Student id 10001 -> {}", studentRepo.findById(10001));
		
		logger.info("All users 1 -> {}", studentRepo.findAll());
		
		
		logger.info("Inserting -> {}", studentRepo.save(new Student("John", "A1234657")));
		studentRepo.save(new Student("Sriram","Passport Number"));
		
		
		logger.info("Fetch all again --> {}", studentRepo.findAll());
		
		logger.info("Update 10001 -> {}", studentRepo.save(new Student(10001, "Name-Updated", "New-Passport")));

		logger.info("Fetch all again --> {}", studentRepo.findAll());
		
		studentRepo.deleteById(10001);
		
		logger.info("Fetch all again --> {}", studentRepo.findAll());
	}

}

