package az.tuncay.academy_management.service;

import az.tuncay.academy_management.dto.EnrollmentRequestDto;
import az.tuncay.academy_management.dto.EnrollmentResponseDto;
import az.tuncay.academy_management.entity.Course;
import az.tuncay.academy_management.entity.Enrollment;
import az.tuncay.academy_management.entity.Student;
import az.tuncay.academy_management.enums.EnrollmentStatus;
import az.tuncay.academy_management.mapper.EnrollmentMapper;
import az.tuncay.academy_management.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final StudentService studentService;
    private final CourseService courseService;

    private void checkDuplicateEnrollment(Long studentId, Long courseId){
        if (enrollmentRepository.existsByStudent_IdAndCourse_Id(studentId, courseId)) {
            throw new RuntimeException("Student is already enrolled in this course");
        }
    }

    private Enrollment findEnrollmentEntityById(Long id) {
        return enrollmentRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public EnrollmentResponseDto createEnrollment(EnrollmentRequestDto dto){

        Student student = studentService.getStudentById(dto.getStudentId());
        Course course = courseService.getCourseById(dto.getCourseId());

        checkDuplicateEnrollment(student.getId(), course.getId());

        Enrollment enrollment = enrollmentMapper.toEntity(student, course);

        Enrollment saveEnrollment = enrollmentRepository.save(enrollment);

        return enrollmentMapper.toResponse(saveEnrollment);
    }

    public List<EnrollmentResponseDto> getAllEnrollments(){

        return enrollmentRepository.
                findAll().
                stream().
                map(enrollmentMapper::toResponse).
                toList();
    }


    public EnrollmentResponseDto getEnrollmentById(Long id){
        Enrollment enrollment = findEnrollmentEntityById(id);

        return enrollmentMapper.toResponse(enrollment);
    }

    public EnrollmentResponseDto updateEnrollmentStatus(Long id, EnrollmentStatus status){

        Enrollment enrollment = findEnrollmentEntityById(id);

        enrollment.setStatus(status);

        Enrollment saveEnrollment = enrollmentRepository.save(enrollment);

        return enrollmentMapper.toResponse(saveEnrollment);
    }

    public void deleteEnrollment(Long id){

        Enrollment enrollment = findEnrollmentEntityById(id);

        enrollmentRepository.delete(enrollment);
    }
}
