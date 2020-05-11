package com.example.studentadministrationsystem.controllers;


import com.example.studentadministrationsystem.models.Course;
import com.example.studentadministrationsystem.models.Student;
import com.example.studentadministrationsystem.repositories.CourseRepositoryDB;
import com.example.studentadministrationsystem.repositories.ICourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    ICourseRepository iCourseRepository;

    public CourseController(){

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
        return "redirect:/courses";
    }

    @GetMapping("/editCourse{id}")
    public String edit(@PathVariable("id") int courseID, Model model){

    Course course = iCourseRepository.readCourses(courseID);

    model.addAttribute("courseName", course.getCourseName());
    model.addAttribute("startDate", course.getStartDate());
    model.addAttribute("description", course.getCourseDescription());
    model.addAttribute("etcs", course.getEtcs());
    model.addAttribute("courseID", course.getCourseID());

        return "Course/edit";
    }

    @PostMapping("/courseEdited")
    public String edited(@ModelAttribute Course course){

        iCourseRepository.editCourse(course);

        return "redirect:/courses";
    }


    @GetMapping("/courseDetails{id}")
    public String courseDetails(@PathVariable("id") int courseId, Model model){

        Course course = iCourseRepository.readCourses(courseId);

        model.addAttribute("courseName", course.getCourseName());
        model.addAttribute("startDate" , course.getStartDate());
        model.addAttribute("description", course.getCourseDescription());
        model.addAttribute("etcs", course.getEtcs());
        model.addAttribute("id", course.getCourseID());

        return "Course/details";
    }
    @GetMapping ("/deleteCourses{id}")
    public String deleteButton(@PathVariable("id") int courseID){
        iCourseRepository.deleteCourse(courseID);
        return"redirect:/courses";
    }



}
