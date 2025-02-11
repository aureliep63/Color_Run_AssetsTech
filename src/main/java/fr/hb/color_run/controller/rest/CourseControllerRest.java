package fr.hb.color_run.controller.rest;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Validated
public class CourseControllerRest {

    private CourseService courseService;

    public CourseControllerRest(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("")
    public List<CourseDto> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course saveCourse(@Valid @RequestBody CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @Valid @RequestBody CourseDto courseDto) {
        courseDto.setId(id);
        return courseService.saveCourse(courseDto);
    }

}
