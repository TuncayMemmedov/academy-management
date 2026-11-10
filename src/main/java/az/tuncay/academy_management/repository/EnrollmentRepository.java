package az.tuncay.academy_management.repository;

import az.tuncay.academy_management.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findAllByStudent_Id(Long student_id);

    List<Enrollment> findAllByCourse_Id(Long course_id);

    boolean existsByStudent_IdAndCourse_Id(Long student_id, Long course_id);

    boolean existsByCourse_Id(Long courseId);
}
