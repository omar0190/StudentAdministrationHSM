package com.example.studentadministrationsystem.controllers;

import com.example.studentadministrationsystem.models.Student;
import com.example.studentadministrationsystem.repositories.IStudentRepository;
import com.example.studentadministrationsystem.repositories.StudentRepositoryDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String deleted (@RequestParam String cpr){
        iStudentRepository.deleteStudent(cpr);
        return "redirect:/deletestudent";
    }
    @GetMapping ("/editstudent")
    public String editStudent(){


        return "Student/edit";
    }

    @PostMapping ("/edited")
    public String edited (@ModelAttribute Student student ){
        iStudentRepository.editStudent(student);

        return "redirect:/editstudent";
    }
    @GetMapping ("/delete/{id}")
    public String deleteButton(@PathVariable("id") String cpr){
        iStudentRepository.deleteStudent(cpr);
        return"redirect:/";
    }

}
