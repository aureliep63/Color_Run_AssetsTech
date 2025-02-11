package fr.hb.color_run.mapper;

import fr.hb.color_run.dto.ParcoursDto;
import fr.hb.color_run.model.Course;
import fr.hb.color_run.model.Parcours;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T18:54:37+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ParcoursMapperImpl implements ParcoursMapper {

    @Override
    public ParcoursDto toDto(Parcours parcours) {
        if ( parcours == null ) {
            return null;
        }

        ParcoursDto parcoursDto = new ParcoursDto();

        parcoursDto.setCourseId( parcoursCourseId( parcours ) );
        parcoursDto.setId( parcours.getId() );
        parcoursDto.setOrdre( parcours.getOrdre() );
        parcoursDto.setLatitude( parcours.getLatitude() );
        parcoursDto.setLongitude( parcours.getLongitude() );

        return parcoursDto;
    }

    @Override
    public Parcours toEntity(ParcoursDto parcoursDto) {
        if ( parcoursDto == null ) {
            return null;
        }

        Parcours parcours = new Parcours();

        parcours.setId( parcoursDto.getId() );
        parcours.setLatitude( parcoursDto.getLatitude() );
        parcours.setLongitude( parcoursDto.getLongitude() );
        parcours.setOrdre( parcoursDto.getOrdre() );

        return parcours;
    }

    @Override
    public List<ParcoursDto> toDtoList(List<Parcours> parcoursList) {
        if ( parcoursList == null ) {
            return null;
        }

        List<ParcoursDto> list = new ArrayList<ParcoursDto>( parcoursList.size() );
        for ( Parcours parcours : parcoursList ) {
            list.add( toDto( parcours ) );
        }

        return list;
    }

    @Override
    public List<Parcours> toEntityList(List<ParcoursDto> parcoursDtoList) {
        if ( parcoursDtoList == null ) {
            return null;
        }

        List<Parcours> list = new ArrayList<Parcours>( parcoursDtoList.size() );
        for ( ParcoursDto parcoursDto : parcoursDtoList ) {
            list.add( toEntity( parcoursDto ) );
        }

        return list;
    }

    private Long parcoursCourseId(Parcours parcours) {
        if ( parcours == null ) {
            return null;
        }
        Course course = parcours.getCourse();
        if ( course == null ) {
            return null;
        }
        Long id = course.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
