package az.tuncay.academy_management.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {

    private Long id;

    private String fullName;

    private String email;

    private LocalDateTime createdAt;
}
