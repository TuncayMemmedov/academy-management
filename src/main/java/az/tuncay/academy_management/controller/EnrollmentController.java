package az.tuncay.academy_management.controller;

import az.tuncay.academy_management.dto.EnrollmentRequestDto;
import az.tuncay.academy_management.dto.EnrollmentResponseDto;
import az.tuncay.academy_management.enums.EnrollmentStatus;
import az.tuncay.academy_management.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentResponseDto createEnrollment(@RequestBody EnrollmentRequestDto dto) {
        return enrollmentService.createEnrollment(dto);
    }

    @GetMapping
    public List<EnrollmentResponseDto> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public EnrollmentResponseDto getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PutMapping("/{id}/status")
    public EnrollmentResponseDto updateEnrollmentStatus(
            @PathVariable Long id,
            @RequestParam EnrollmentStatus status) {
        return enrollmentService.updateEnrollmentStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}
