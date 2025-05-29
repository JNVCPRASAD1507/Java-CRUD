package in.jnv.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jnv.main.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	
}
