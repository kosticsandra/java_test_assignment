package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;

import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//TODO finishing all the methods that return null 

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherMapper teacherMapper;
    
    //A method for finding a teacher based on their id and returning the found DTO teacher
    @Override
    public TeacherDTO findOne(Integer id) {
    	Optional<Teacher> teacher = teacherRepository.findById(id);
    	
    	 if (!teacher.isPresent()) {
             throw new IllegalArgumentException
                 ("Teacher with the following id = " + id + " is not found.");
         }
         return teacherMapper.transformToDTO(teacher.get());
    }
    
    //A method for finding all the teachers and storing their DTO-s into a list
    @Override
    public List<TeacherDTO> findAll() {
    	// filling the list the old-fashioned way
    	List<Teacher> teacherList = teacherRepository.findAll();
    	List<TeacherDTO> teacherDTOlist = new ArrayList<TeacherDTO>();
    	
    	for(Teacher teacher:teacherList) {
    		TeacherDTO teacherDTO = teacherMapper.transformToDTO(teacher);
    		teacherDTOlist.add(teacherDTO);
    	}
    	
   	// return teacherRepository.findAll().stream().map(i -> teacherMapper.transformToDTO(i)).collect(Collectors.toList());
    	return teacherDTOlist;
    }

    //A method for saving a new DTO teacher
    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
    	Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
        return teacherMapper.transformToDTO(teacherRepository.save(teacher));
    }

    //A method for removing a teacher based on their existing id
    @Override
    public void remove(Integer id) throws IllegalArgumentException {
    	Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                ("Teacher with the following id = " + id + " is not found.");
        }
        teacherRepository.deleteById(id);
    }
    //A method for updating a teacher based on their existing id and DTO object,  an updated DTO teacher returned
    @Override
    public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
    	Optional<Teacher> oldTeacher = teacherRepository.findById(id);
        if (!oldTeacher.isPresent()) {
            throw new IllegalArgumentException 
                ("Teacher with the following id = " + id + " is not found.");
        }
        oldTeacher.get().setTeacherName(teacherDTO.getTeacherName());
        oldTeacher.get().setTeacherSurname(teacherDTO.getTeacherSurname());
        oldTeacher.get().setTeacherEmail(teacherDTO.getTeacherEmail());
        teacherRepository.save(oldTeacher.get());
        return teacherMapper.transformToDTO(oldTeacher.get());
    }
    
    //writing additional two methods based on the TeacherRepository.java file	
    
    //A method for finding a teacher based on their first and last name, returning the DTO teacher
    @Override
    public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
    	Optional<Teacher> teacher = teacherRepository.findByTeacherNameAndTeacherSurname(name, surname);
        if (!teacher.isPresent()) {
            throw new IllegalArgumentException
                ("Teacher with the provided first name and surname combination is not found.");
        }
        return teacherMapper.transformToDTO(teacher.get());
    }

    //A method for finding a teacher based on their email, returning the DTO teacher
    @Override
    public TeacherDTO findByTeacherEmail(String email) {
    	Optional<Teacher> teacher = teacherRepository.findByTeacherEmail(email);
    	if(!teacher.isPresent()) {
    		throw new IllegalArgumentException
    		("Teacher with the provided email is not found.");
    	}
        return teacherMapper.transformToDTO(teacher.get());
    }
}
