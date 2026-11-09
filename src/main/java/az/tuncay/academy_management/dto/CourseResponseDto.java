package az.tuncay.academy_management.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponseDto {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private LocalDateTime createdAt;
}
