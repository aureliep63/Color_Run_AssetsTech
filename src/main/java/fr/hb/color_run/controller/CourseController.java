package fr.hb.color_run.controller;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping("/vueCourses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public String listCourses(Model model, Locale locale) {
        model.addAttribute("courses", courseService.getCourses());
        return "course/list";
    }

    @GetMapping("/add")
    public String addCourseForm(Model model) {
        model.addAttribute("isEditMode", false);
        model.addAttribute("course", new Course());
        return "course/form";
    }

    @GetMapping("edit/{id}")
    public String editCourseForm(@PathVariable("id") Long id, Model model) {
        CourseDto existing = courseService.getCourseById(id);
        if (existing == null) {
            return "redirect:/vueCourses";
        }
        model.addAttribute("isEditMode", true);
        model.addAttribute("course", existing);
        return "course/form";
    }

    @PostMapping("")
    public String saveCourse(@Valid @ModelAttribute("course") CourseDto courseDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isEditMode", courseService.getCourseById(courseDto.getId()) != null);
            return "course/form";
        }
        courseService.saveCourse(courseDto);
        return "redirect:/vueCourses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/vueCourses";
    }
}


