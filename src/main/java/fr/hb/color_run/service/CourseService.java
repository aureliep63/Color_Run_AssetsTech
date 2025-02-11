package fr.hb.color_run.service;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.model.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();

    CourseDto getCourseById(Long id);

    Course saveCourse(CourseDto courseDto);

    void deleteCourse(Long id);
}
