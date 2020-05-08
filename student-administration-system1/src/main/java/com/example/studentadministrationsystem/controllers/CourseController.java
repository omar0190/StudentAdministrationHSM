package com.example.studentadministrationsystem.controllers;

import com.example.studentadministrationsystem.models.Course;
import com.example.studentadministrationsystem.repositories.ICourseRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CourseController {

    ICourseRepository IcoursesRepository;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("list",IcoursesRepository.readAllCourses());

        return "index";

    }
    @GetMapping("/createcourse")
    public String create (){

        return "Course/create";

}
    @PostMapping("/created")
    public String created(@ModelAttribute Course course){
        IcoursesRepository.createCourse(course);
        return "redirect:/createcourse";
    }

    @GetMapping ("/editcourse")
    public String editCourse(){


        return "Course/edit";
    }


    @PostMapping ("/edited")
    public String edited (@ModelAttribute Course course ){
        IcoursesRepository.editCourse(course);

        return "redirect:/editcourse";
    }
    @GetMapping ("/delete/{id}")
    public String deleteButton(@PathVariable("id") int courseID){
        IcoursesRepository.deleteCourse(courseID);
        return"redirect:/";
    }
    @GetMapping("/details{id}")
    public String getDetails(@PathVariable("id") int courseID, Model model){
        Course course = IcoursesRepository.readCourses(courseID);

        model.addAttribute("coursesID", course.getCourseID());
        model.addAttribute("CorseName", course.getCourseName());
        model.addAttribute("startDate", course.getStartDate());
        model.addAttribute("courseDiscrpition", course.getCourseDescription());
        model.addAttribute("etcs", course.getEtcs());




        return "Course/details";
    }

}