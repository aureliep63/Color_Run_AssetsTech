package fr.hb.color_run.service.Impl;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.mapper.ParcoursMapper;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Parcours;
import fr.hb.color_run.model.Role;
import fr.hb.color_run.repository.CourseRepository;
import fr.hb.color_run.repository.ParcoursRepository;
import fr.hb.color_run.service.ParcoursService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParcoursServiceImpl implements ParcoursService {

    private ParcoursRepository parcoursRepository;
    private ParcoursMapper parcoursMapper;

    public ParcoursServiceImpl(ParcoursRepository parcoursRepository, ParcoursMapper parcoursMapper,
                               CourseRepository courseRepository) {
        this.parcoursRepository = parcoursRepository;
        this.parcoursMapper = parcoursMapper;
        this.courseRepository = courseRepository;
    }

    private ParcoursDto parcoursDto;
    private final CourseRepository courseRepository;

    @Override
    public List<ParcoursDto> getParcours() {
        List<Parcours> parcours = parcoursRepository.findAll();
        return parcours.stream()
                        .map(parcoursMapper::toDto)
                        .collect(Collectors.toList());
    }

    @Override
    public ParcoursDto getParcoursById(Long id) {
        return parcoursRepository.findById(id)
                                    .map(parcoursMapper::toDto)
                                    .orElse(null);
    }
    @Override
    public Parcours saveParcours(ParcoursDto parcoursDto) {
        Parcours parcours = parcoursMapper.toEntity(parcoursDto);
        if(parcoursDto.getCourseId() != null){
            Course course= courseRepository.findById(parcoursDto.getCourseId()).orElse(null);
            parcours.setCourse(course);
        }
        return parcoursRepository.save(parcours);
    }

    @Override
    public void deleteParcoursById(Long id) {
        parcoursRepository.deleteById(id);
    }
}
