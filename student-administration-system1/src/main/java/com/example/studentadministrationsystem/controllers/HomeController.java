package com.example.studentadministrationsystem.controllers;

import com.example.studentadministrationsystem.models.Student;
import com.example.studentadministrationsystem.repositories.IStudentRepository;
import com.example.studentadministrationsystem.repositories.StudentRepositoryDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class HomeController {


    IStudentRepository iStudentRepository;

    public HomeController() {

            iStudentRepository = new  StudentRepositoryDB();

    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("list",iStudentRepository.readAllStudents());

        return "index";

    }
@GetMapping("/createstudent")
    public String create (){

        return "Student/create";
}

@PostMapping ("/created")
    public String created(@ModelAttribute Student student){
        iStudentRepository.createStudent(student);
        return "redirect:/createstudent";
    }

    @GetMapping ("/deletestudent")
    public String deleteStudent(){


        return "Student/delete";
    }

    @PostMapping("/deleted")
    public String deleted (@RequestParam String cpr, @RequestParam String firstName){
        iStudentRepository.deleteStudent(cpr,firstName);
        return "redirect:/deletestudent";
    }
}
