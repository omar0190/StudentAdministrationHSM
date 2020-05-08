package com.example.studentadministrationsystem.controllers;


import com.example.studentadministrationsystem.models.Course;
import com.example.studentadministrationsystem.repositories.CourseRepositoryDB;
import com.example.studentadministrationsystem.repositories.ICourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Con {

    ICourseRepository iCourseRepository;

    public Con(){

        iCourseRepository = new CourseRepositoryDB();
    }

    @GetMapping("/courses")
    public String homePage(Model model){
        model.addAttribute("list",iCourseRepository.readAllCourses());

        return "Course/allcourses";

    }

    @GetMapping("/createcourse")
    public String create (){

        return "Course/create";

    }
    @PostMapping("/courseCreated")
    public String created(@ModelAttribute Course course){
        iCourseRepository.createCourse(course);
        return "redirect:/createcourse";
    }



}
