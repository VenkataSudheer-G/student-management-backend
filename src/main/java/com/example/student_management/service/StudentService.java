package com.example.student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());

        return repository.save(existingStudent);
    }

}

