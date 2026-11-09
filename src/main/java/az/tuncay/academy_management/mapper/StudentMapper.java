package az.tuncay.academy_management.mapper;

import az.tuncay.academy_management.dto.StudentRequestDto;
import az.tuncay.academy_management.dto.StudentResponseDto;
import az.tuncay.academy_management.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDto dto){

        return Student.builder().
                fullName(dto.getFullName()).
                email(dto.getEmail()).
                build();
    }

    public StudentResponseDto toResponse(Student student){

        return StudentResponseDto.builder().
                id(student.getId()).
                fullName(student.getFullName()).
                email(student.getEmail()).
                createdAt(student.getCreatedAt()).
                build();
    }
}
