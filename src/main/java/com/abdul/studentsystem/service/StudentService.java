package com.abdul.studentsystem.service;

import java.util.List;

import com.abdul.studentsystem.model.Student;


public interface StudentService {
	//This method will add new student into the database.
    public Student saveStudent(Student student);
    
    
    //This method will fetch all the student present in the database.
    public List<Student> getAllStudent();
    
  //Getting single student from DB.
  	public Student get(Integer id);
  	
  	//Delete a single student from DB.
  	public void delete(Integer id);
  	
  	}
