package az.tuncay.academy_management.service;

import az.tuncay.academy_management.dto.StudentRequestDto;
import az.tuncay.academy_management.dto.StudentResponseDto;
import az.tuncay.academy_management.entity.Student;
import az.tuncay.academy_management.exception.ResourceNotFoundException;
import az.tuncay.academy_management.mapper.StudentMapper;
import az.tuncay.academy_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Student getStudentById(Long id){
        return studentRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public StudentResponseDto createStudent(StudentRequestDto dto){

        Student student = studentMapper.toEntity(dto);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toResponse(savedStudent);
    }

    public List<StudentResponseDto> getAllStudents(){

        return studentRepository.
                findAll().
                stream().
                map(studentMapper::toResponse).
                toList();
    }

    public void deleteStudent(Long id){

        Student student = getStudentById(id);

        studentRepository.delete(student);
    }
}
