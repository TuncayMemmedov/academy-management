package az.tuncay.academy_management.controller;

import az.tuncay.academy_management.dto.CourseRequestDto;
import az.tuncay.academy_management.dto.CourseResponseDto;
import az.tuncay.academy_management.entity.Course;
import az.tuncay.academy_management.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseResponseDto createCourse(@RequestBody CourseRequestDto dto) {
        return courseService.createCourse(dto);
    }

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/sorted-by-price")
    public List<CourseResponseDto> getCoursesSortedByPrice() {
        return courseService.getCoursesSortedByPrice();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}