package com.college.crudstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.crudstudent.entity.StudentEntity;
import com.college.crudstudent.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public void save(StudentEntity entity) {
		repo.save(entity);
	}
	
	public StudentEntity findById(long id) {
		return repo.findById(id).get();
	}
	
	public void deleteById(long id) {
		repo.deleteById(id);
	}
	
	public List<StudentEntity> findAll(){
		return repo.findAll();
	}

}
