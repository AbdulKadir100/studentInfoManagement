package com.abdul.studentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdul.studentsystem.model.Student;
import com.abdul.studentsystem.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	//This method will add new student into the database.
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

	//This method will fetch all the student present in the database.
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	//Getting single student from DB.
	@Override
	public Student get(Integer id) {
		return studentRepository.findById(id).get();
	}
	
	//Delete a single student from DB.
	@Override
	public void delete(Integer id) {
		studentRepository.deleteById(id);
	}
	
	
}
