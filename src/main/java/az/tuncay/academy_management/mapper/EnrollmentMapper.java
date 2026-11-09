package az.tuncay.academy_management.mapper;

import az.tuncay.academy_management.dto.EnrollmentRequestDto;
import az.tuncay.academy_management.dto.EnrollmentResponseDto;
import az.tuncay.academy_management.entity.Course;
import az.tuncay.academy_management.entity.Enrollment;
import az.tuncay.academy_management.entity.Student;
import az.tuncay.academy_management.enums.EnrollmentStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EnrollmentMapper {

    public Enrollment toEntity(Student student, Course course){

        return Enrollment.builder().
                student(student).
                course(course).
                status(EnrollmentStatus.ACTIVE).
                enrollmentDate(LocalDate.now()).
                build();
    }

    public EnrollmentResponseDto toResponse(Enrollment enrollment){

        return EnrollmentResponseDto.builder().
                id(enrollment.getId()).
                enrollmentDate(enrollment.getEnrollmentDate()).
                studentId(enrollment.getStudent().getId()).
                studentName(enrollment.getStudent().getFullName()).
                courseId(enrollment.getCourse().getId()).
                courseTitle(enrollment.getCourse().getTitle()).
                status(enrollment.getStatus()).
                build();
    }
}
