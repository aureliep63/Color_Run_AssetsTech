package fr.hb.color_run.service.Impl;

import fr.hb.color_run.dto.CourseDto;
import fr.hb.color_run.mapper.CourseMapper;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Inscription;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.repository.CourseRepository;
import fr.hb.color_run.repository.InscriptionRepository;
import fr.hb.color_run.repository.ParcoursRepository;
import fr.hb.color_run.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private ParcoursRepository parcoursRepository;
    private InscriptionRepository inscriptionRepository;
    private CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, ParcoursRepository parcoursRepository, InscriptionRepository notebooksRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.parcoursRepository = parcoursRepository;
        this.inscriptionRepository = notebooksRepository;
        this.courseMapper = courseMapper;
    }

    private CourseDto courseDto;

    @Override
    public List<CourseDto> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id) {
        return courseRepository.findById(id)
                                .map(courseMapper::toDto)
                                .orElse(null);
    }

    @Override
    public Course saveCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);

        if(courseDto.getParcoursId() != null && courseDto.getParcoursId().isEmpty()) {
            List<Parcours> parcoursList = parcoursRepository.findAllById(courseDto.getParcoursId());
            course.setParcours(parcoursList);
        }

        if(courseDto.getInscriptionId() != null && courseDto.getInscriptionId().isEmpty()) {
            List<Inscription> inscriptions = inscriptionRepository.findAllById(courseDto.getInscriptionId());
            course.setInscriptions(inscriptions);
        }

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
