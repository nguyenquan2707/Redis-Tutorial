package com.mustafa.redistutorial.controller;

import com.mustafa.redistutorial.enm.EnmGender;
import com.mustafa.redistutorial.entity.Student;
import com.mustafa.redistutorial.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getAllUser() {
        return studentService.getAllUser();
    }

    @PostMapping("/")
    public boolean addUser(Student student) {
        return studentService.addUser(student);
    }

    @GetMapping("/{id}")
    public Student getUser(@PathVariable String id) throws Exception {
        return studentService.getUser(id);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable String id, @RequestBody Student newStudentData) throws Exception {
        Student existStudent = studentService.getUser(id);

        try{
            if(Objects.nonNull(newStudentData.getName())) {
                existStudent.setName(newStudentData.getName());
            }

            if(Objects.nonNull(newStudentData.getGrade())) {
                existStudent.setGrade(newStudentData.getGrade());
            }

            if(Objects.nonNull(newStudentData.getGender())) {
                existStudent.setGender(newStudentData.getGender());
            }

            return studentService.updateUser(existStudent);
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(String id) {
        return studentService.deleteUser(id);
    }
}
