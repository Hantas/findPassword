package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 10742 on 2018/1/1.
 */
@Controller
public class FindPasswordController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/findPasswordI")
    public String findPasswordI() {
        return "findPasswordI";
    }

    @RequestMapping("/findPasswordII")
    public String findPasswordII(HttpSession session, Model model) {
        model.addAttribute("student", session.getAttribute("student"));
        return "findPasswordII";
    }

    @RequestMapping("/findPasswordIII")
    public String findPasswordIII(HttpSession session, Model model) {
        model.addAttribute("student", session.getAttribute("student"));
        return "findPasswordIII";
    }

    @RequestMapping("/findPasswordIV")
    public String findPasswordIV() {
        return "findPasswordIV";
    }

    @PostMapping("/findPasswordI")
    public String validateId(@RequestParam String sid, HttpSession session, Model model) {
        Student student = studentService.findById(sid);
        if (student != null) {
            session.setAttribute("student", student);
            model.addAttribute("student", student);
            return "findPasswordII";
        }
        return "findPasswordI";
    }

    @PostMapping("/findPasswordII")
    public String validateCode(@RequestParam String emailCode, HttpSession session, Model model) {
        model.addAttribute("student", session.getAttribute("student"));
        String code = (String) session.getAttribute("code");
        if (emailCode.equals(code)) {
            return "findPasswordIII";
        }
        return "findPasswordII";
    }

    @PostMapping("/findPasswordIII")
    public String validateRepeat(String newPassword, String confirm, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (!student.getPassword().equals(newPassword) && newPassword.equals(confirm))
        {
            studentService.updatePasswordById(newPassword, student.getId());
            return "findPasswordIV";
        }
        return "findPasswordIII";
    }
}