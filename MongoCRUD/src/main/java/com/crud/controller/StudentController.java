package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.IStudentRepository;

@RestController
public class StudentController {
	@Autowired
	private IStudentRepository iStudentRepository;
 
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student ){
		Student save = this.iStudentRepository.save(student);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/getStudents")
	public ResponseEntity<?> getStudents(){
		return ResponseEntity.ok(this.iStudentRepository.findAll());
	}
	
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?> getStudents(@PathVariable Integer id,@RequestBody Student studentData){
		Student student=this.iStudentRepository.findById(id).get();
		System.out.println("name----"+ studentData.getName());
		System.out.println("city----"+ studentData.getCity());
		System.out.println("Collage----"+ studentData.getName());
		student.setName(studentData.getName());
		student.setCity(studentData.getCity());
		student.setCollage(studentData.getCollage());
		return ResponseEntity.ok(student);
		}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudentByID(@PathVariable Integer id){
		this.iStudentRepository.deleteById(id);
		System.out.println("Student id---"+ id +"---has been delete successfully");
		
		}
	
	@DeleteMapping("/deleteAllStudent")
	public void deleteAllStudent(){
		this.iStudentRepository.deleteAll();
		System.out.println(" All Student has been delete successfully");
		
		}
	
}
