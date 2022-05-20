package com.abdul.studentsystem.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.studentsystem.model.Student;
import com.abdul.studentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService stdService;
	
	@PostMapping("/add")
	public String add(@RequestBody Student std) {
		stdService.saveStudent(std);
		return "New Student added";
		
	}
	@GetMapping("/getAll")
	public List<Student> getAllStudent(){
		return stdService.getAllStudent();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getSingle(@PathVariable Integer id) {
		try {
			Student s = stdService.get(id);
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id) {
		try {
		     Student s = stdService.get(id);
			stdService.saveStudent(student);
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		stdService.delete(id);
		return "Deleted student with id "+id;
	}

}
