package org.yared.backend.service;

import org.springframework.stereotype.Service;
import org.yared.backend.model.Student;

import java.util.List;

@Service
public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    Student getStudentById(Long id);

}
