package az.tuncay.academy_management.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequestDto {

    private String title;

    private String description;

    private BigDecimal price;
}
