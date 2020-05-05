package com.example.studentadministrationsystem.controllers;

import com.example.studentadministrationsystem.repositories.IStudentRepository;
import com.example.studentadministrationsystem.repositories.StudentRepositoryDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
public class HomeController {


    IStudentRepository iStudentRepository;

    public HomeController() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/my_company" , "admin" , "Ali010298");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("list",iStudentRepository.readAllStudents());

        return "index";
    }


}
