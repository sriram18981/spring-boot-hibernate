package learnings.sriram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learnings.sriram.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
