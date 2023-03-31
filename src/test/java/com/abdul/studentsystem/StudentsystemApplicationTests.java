package com.abdul.studentsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import com.abdul.studentsystem.model.Student;
import com.abdul.studentsystem.repository.StudentRepository;
import com.abdul.studentsystem.service.StudentService;
import com.abdul.studentsystem.service.StudentServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentsystemApplicationTests {

	@Autowired
	private StudentServiceImp service;
	
	@MockBean
	private StudentRepository repo;
	
	@Test
	public void getAllStudent() {
		when(repo.findAll()).thenReturn(Stream.of(new Student(1,"Abdul Kadir","Roorkee"),
				new Student(2,"Anhar","Roorkee")).collect(Collectors.toList()));
		assertEquals(2, service.getAllStudent().size());
	}
	

	@Test
	public void saveStudentTest() {
		Student s = new Student(6,"Pandey","New Delhi");
		when(repo.save(s)).thenReturn(s);
		
		assertEquals(s, service.saveStudent(s));
		
	}
	


}
