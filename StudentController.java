package com.example.DataJpaDemo.controller;

import com.example.DataJpaDemo.entity.Student;
import com.example.DataJpaDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    @Autowired
    private StudentRepo studentRepo;


    //gellALl

    @GetMapping("/students")

    public List<Student>getAll(){

        return studentRepo.findAll();
    }

    @PostMapping("/students")

    public Student createStudent( @RequestBody Student student){

        return studentRepo.save(student);
    }
    @PutMapping("/students/{id}")

    public Student updateStudent(@RequestBody Student student,@PathVariable int id){

        Student existing=studentRepo.findById(id).get();
        existing.setName(student.getName());
        existing.setStd(student.getStd());
        existing.setRoll_no(student.getRoll_no());
        studentRepo.save(existing);
        return existing;

    }
    @DeleteMapping("/students/{id}")

    public String removeById(@PathVariable int id){

        if(studentRepo.existsById(id)){

            studentRepo.deleteById(id);
            return "id Has Been Deleted";
        }
        else{

            return"Does Not Contain Existing id";

        }

    }
}
