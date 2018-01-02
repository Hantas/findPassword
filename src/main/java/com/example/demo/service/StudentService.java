package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 10742 on 2018/1/1.
 */
@Service("jpa.studentService")
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student findById(String id) {
        return studentRepository.findById(id);
    }

    public void updatePasswordById(String password, String id) {
        studentRepository.updatePasswordById(password, id);
    }
}
