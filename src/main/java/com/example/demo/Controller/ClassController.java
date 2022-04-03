package com.example.demo.Controller;


import com.example.demo.Entity.Student;
import com.example.demo.Exceptions.StudentNotFoundException;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.TeacherService;
import com.example.demo.dto.EnrollRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class ClassController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @PostMapping("/enroll")
    public Student enroll(@RequestBody EnrollRequest request){

        return studentService.save(request.getStudent());
    }

    @GetMapping("/getAllEnrollInfo")
    public List<Student> findAllInfo(){
        return studentService.findAll();
    }


    @GetMapping("/students/{id}")
    Student student(@PathVariable int id){
        return studentService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student newStudent, @PathVariable int id){
        return studentService.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    return studentService.save(newStudent);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentService.save(newStudent);});


    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Student> updateEnroll(@PathVariable String id){
//        return new ResponseEntity<>( studentService.getStudentById(id), HttpStatus.OK);
//
//    }
    //    @GetMapping("/students/{id}")student
//    public List<Student> getStudentInfo(@PathVariable int id) {
//          return studentService.findById(id);
//    }
    @DeleteMapping("/deleteStudent/{id}")
    public void dropStudent(@PathVariable int id) {
        studentService.deleteById(id);
                
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> customizedExceptionHandler() {
        return new ResponseEntity<>("This student is not exist!", HttpStatus.NOT_FOUND);
    }


}


