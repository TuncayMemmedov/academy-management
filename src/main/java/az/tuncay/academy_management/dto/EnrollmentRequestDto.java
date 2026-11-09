package az.tuncay.academy_management.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentRequestDto {

    private Long studentId;

    private Long courseId;
}
