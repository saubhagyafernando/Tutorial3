package com.example.CRUD_application.controller;
import com.example.CRUD_application.model.Student;
import com.example.CRUD_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/Students")
@CrossOrigin(origins = "*")


public class StudentController {
    @Autowired
 private StudentService studentService;
 @PostMapping
 public ResponseEntity<Student> saveStudent(@RequestBody Student
Student){
 return new
ResponseEntity<Student>(studentService.saveStudent(Student),
HttpStatus.CREATED);
 }
 //GetAll Rest Api
 @GetMapping
 public List<Student> getAllStudent(){
 return StudentService.getAllStudent();
 }
 //Get by Id Rest Api
 @GetMapping("{id}")
 // localhost:8080/api/Students/1
 public ResponseEntity<Student> getStudentById(@PathVariable("id") long
StudentID){
 return new
ResponseEntity<Student>(StudentService.getStudentById(StudentID),HttpStatus.OK);
 }
 //Update Rest Api
 @PutMapping("{id}")
 public ResponseEntity<Student> updateStudent(@PathVariable("id") long
id,
 @RequestBody Student
Student){
 return new
ResponseEntity<Student>(StudentService.updateStudent(Student,id),HttpStatus.OK);
 }
 //Delete Rest Api
 @DeleteMapping("{id}")
 public ResponseEntity<String> deleteStudent(@PathVariable("id") long studentID){
 //delete Student from db
 StudentService.deleteStudent(id);
 return new 
 ResponseEntity<String>("Student deletedSuccessfully.",HttpStatus.OK);
 }
 @PutMapping("{id}")
 public ResponseEntity<Student> updateStudent(@PathVariable("id") long
id,
 @RequestBody StudentStudent){
 return new
ResponseEntity<Student>(StudentService.updateStudent(Student,id),HttpStatus.OK);
 }
 //Delete Rest Api
 @DeleteMapping("{id}")
 public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
 //delete Student from db
 StudentService.deleteStudent(id);
 return new ResponseEntity<String>("Student deletedSuccessfully.",HttpStatus.OK);
 }


}

