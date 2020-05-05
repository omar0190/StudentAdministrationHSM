package com.example.studentadministrationsystem.controllers;

import com.example.studentadministrationsystem.repositories.IStudentRepository;
import com.example.studentadministrationsystem.repositories.StudentRepositoryDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    IStudentRepository iStudentRepository;

    public HomeController() {
        iStudentRepository = new StudentRepositoryDB();
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("list",iStudentRepository.readAllStudents());

        return "index";
    }


}
