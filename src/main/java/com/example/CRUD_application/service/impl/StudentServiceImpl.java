package com.example.CRUD_application.service.impl;
import com.example.CRUD_application.model.Student;
import com.example.CRUD_application.repository.StudentRepository;
import com.example.CRUD_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository StudentRepsitory;
    //save Student in database
    @Override
    public Student saveStudent(Student Student){
    return StudentRepsitory.save(Student);
    }
    //get all Student form database
    @Override
    public List<Student> getAllStudent() {
    return StudentRepsitory.findAll();
    }
    //get Student using id
    @Override
    public Student getStudentById(long id) {
    Optional<Student> Student = StudentRepsitory.findById(id);
    if(Student.isPresent()){
    return Student.get();
    }else {
    throw new RuntimeException();
    }
    }
    //update Student
    @Override
    public Student updateStudent(Student Student, long id) {
    Student existingStudent =
   StudentRepsitory.findById(id).orElseThrow(
    ()-> new RuntimeException()
    );
    existingStudent.setFirstName(Student.getFirstName());
    existingStudent.setLastName(Student.getLastName());
    existingStudent.setEmail(Student.getEmail());
    // save
    StudentRepsitory.save(existingStudent);
    return existingStudent;
    }
    //delete Student
 @Override
 public void deleteStudent(long id) {
 //check
 StudentRepsitory.findById(id).orElseThrow(()-> new
RuntimeException());
 //delete
 StudentRepsitory.deleteById(id);
 }
}
