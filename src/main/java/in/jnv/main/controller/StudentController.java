package in.jnv.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jnv.main.entities.Student;
import in.jnv.main.repository.StudentRepository;


@RestController
//@RequestMapping
public class StudentController {

	@Autowired
	StudentRepository repo;
	//get all the students 
	//localhost:8080/students
	
//	@PostMapping("/students")
//	public Student addStudent(@ModelAttribute Student student) {
//		Student std = repo.save(student);
//		return std;
//	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
	    Student std = repo.save(student);
	    return std;
	}

	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		List<Student> students = repo.findAll();
		return students;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		try {
			Student student = repo.findById(id).get();
			return student;
			
			// return repo.findById(id).get();
			
		}catch(Exception e) {
			System.out.println("Not found : "+id);
			return null;
		}
		 
	}
	
	
	@PutMapping("/student/{id}")
	public Student updStudent(@PathVariable int id) {
		
		try{Student student = repo.findById(id).get();
		student.setName("manoj");
		repo.save(student);
		return student;
		}catch(Exception e) {
			System.out.println("not found : "+id);
			return null;
		}
		
	}

	
	@DeleteMapping("/student/{id}")
	public Student delStudent(@PathVariable int id) {
		
	    Student student = repo.findById(id).orElse(null); 
	    if (student != null) {
	        repo.deleteById(id);
	    }
	    return student;
	}
	
}
