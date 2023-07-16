package com.mustafa.redistutorial.service;

import com.mustafa.redistutorial.entity.Student;
import com.mustafa.redistutorial.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllUser() {
        List<Student> studentList = new ArrayList<>();

        studentRepository.findAll().forEach(studentList::add);

        return studentList;
    }

    public boolean addUser(Student student) {
        try {
            studentRepository.save(student);
            return true;
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    public Student getUser(String id) throws Exception {
        if(studentRepository.findById(id).isPresent()) {
            return studentRepository.findById(id).get();
        } else {
         throw new Exception("User not found.");
        }
    }

    public boolean updateUser(Student student) {
        try {
            studentRepository.save(student);
            return true;
        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    public boolean deleteUser(String id) {
        try{
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
