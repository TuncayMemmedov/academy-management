package az.tuncay.academy_management.service;

import az.tuncay.academy_management.dto.CourseRequestDto;
import az.tuncay.academy_management.dto.CourseResponseDto;
import az.tuncay.academy_management.entity.Course;
import az.tuncay.academy_management.exception.ResourceNotFoundException;
import az.tuncay.academy_management.mapper.CourseMapper;
import az.tuncay.academy_management.repository.CourseRepository;
import az.tuncay.academy_management.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final EnrollmentRepository enrollmentRepository;


    public Course getCourseById(Long id){

        return courseRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public CourseResponseDto createCourse(CourseRequestDto dto){

        Course course = courseMapper.toEntity(dto);

        Course saveCourse = courseRepository.save(course);

        return courseMapper.toResponse(saveCourse);
    }

    public List<CourseResponseDto> getAllCourses(){

        return courseRepository.
                findAll().
                stream().
                map(courseMapper::toResponse).
                toList();
    }

    public List<CourseResponseDto> getCoursesSortedByPrice(){

        return courseRepository.
                findAllByOrderByPriceAsc().
                stream().
                map(courseMapper::toResponse).
                toList();
    }

    public void deleteCourse(Long id){

        if (enrollmentRepository.existsByCourse_Id(id)){

            throw new ResourceNotFoundException("Cannot delete course because enrollments exist");
        }else {

            Course course = getCourseById(id);

            courseRepository.delete(course);
        }
    }
}
