package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;

//Creating the missing TeacherService interface

public interface TeacherService extends CrudService<TeacherDTO>{
	
	//writing the two methods based on the TeacherServiceImpl.java file	
	TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname);
	
	TeacherDTO findByTeacherEmail(String email);

}
