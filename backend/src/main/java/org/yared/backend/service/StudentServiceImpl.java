package org.yared.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yared.backend.model.Student;
import org.yared.backend.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    to create student

    public Student createStudent(Student student){

        return studentRepository.save(student);
    }

//    display all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
//    update student

    public Student updateStudent(Long id, Student student){
        Student existingStudent = studentRepository.findById(id).orElseThrow();

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());

        return studentRepository.save(existingStudent);
    }

//    delete student
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);

    }
//    get student by Id
    public Student getStudentById(Long id){
       return studentRepository.findById(id).orElseThrow();
    }


}
