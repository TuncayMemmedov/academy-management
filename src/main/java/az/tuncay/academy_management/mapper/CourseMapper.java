package az.tuncay.academy_management.mapper;

import az.tuncay.academy_management.dto.CourseRequestDto;
import az.tuncay.academy_management.dto.CourseResponseDto;
import az.tuncay.academy_management.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDto dto){

        return Course.builder().title(dto.getTitle()).
                description(dto.getDescription()).
                price(dto.getPrice()).
                build();
    }

    public CourseResponseDto toResponse(Course course){

        return CourseResponseDto.builder().id(course.getId()).
                title(course.getTitle()).
                description(course.getDescription()).
                price(course.getPrice()).
                createdAt(course.getCreatedAt()).
                build();
    }
}
