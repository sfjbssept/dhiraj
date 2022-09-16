package com.student.app.controller;

import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.entity.Student;

@RestController
public class StudentServiceController {

	public static Map<String, List<Student>> schoolDB = new HashMap<String, List<Student>>();
	static {
		schoolDB = new HashMap<String, List<Student>>();
		List<Student> studentList = new ArrayList<Student>();
		Student std = new Student("Nishant", "class12");
		Student std1 = new Student("Vinay", "class11");
		studentList.add(std);
		studentList.add(std1);
		schoolDB.put("school1", studentList);

		// Student 2nd 
		List<Student> studentList11 = new ArrayList<Student>();

		Student std2 = new Student("Kamal", "class10");
		Student std3 = new Student("Naveen", "class11");
		studentList11.add(std2);
		studentList11.add(std3);
		schoolDB.put("school2", studentList11);

	}

	@RequestMapping(value = "/getStudentDetailforSchool/{schoolName}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolName) {
		System.out.println("Getting Student detail for student" + schoolName);
		List<Student> studentlist = schoolDB.get(schoolName);
		if (studentlist == null) {
			studentlist = new ArrayList<Student>();
			Student std = new Student("not found 401", "N/A");
			studentlist.add(std);

		}
		return studentlist;

	}
}
