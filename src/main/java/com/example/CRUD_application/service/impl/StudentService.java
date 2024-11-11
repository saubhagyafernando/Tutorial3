package com.example.CRUD_application.service.impl;
import com.example.CRUD_application.model.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student Student);
 List<Student> getAllStudent();
 Student getStudentById(long id);
 Student updateStudent(Student Student,long id);
 void deleteStudent(long id);
}
