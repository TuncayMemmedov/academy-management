package az.tuncay.academy_management.repository;

import az.tuncay.academy_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

    boolean existsByEmail(String email);
}
