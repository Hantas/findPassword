package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 10742 on 2018/1/1.
 */
@Controller
public class LoginController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("student", new Student());
        return "login";
    }

    @PostMapping("/")
    public String message(String id, String password, Model model) {
        Student realStudent = studentService.findById(id);
        if (realStudent != null && realStudent.getPassword().equals(password)){
            model.addAttribute("student", realStudent);
            return "message";
        }
        return "loginError";
    }
}
