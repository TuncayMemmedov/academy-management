package az.tuncay.academy_management.dto;

import az.tuncay.academy_management.enums.EnrollmentStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponseDto {

    private Long id;

    private LocalDate enrollmentDate;

    private Long studentId;

    private String studentName;

    private Long courseId;

    private String courseTitle;

    private EnrollmentStatus status;
}
