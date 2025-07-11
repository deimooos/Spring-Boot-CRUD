package com.emrekirdim.springapi.controller;

import com.emrekirdim.springapi.model.Student;
import com.emrekirdim.springapi.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO.getStudent(), studentDTO.getLectureIds());
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody UpdateStudentWithLecturesDTO updateDTO) {
        return studentService.updateStudent(updateDTO.getId(), updateDTO.getStudent(), updateDTO.getLectureIds());
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestBody DeleteRequest deleteRequest) {
        studentService.deleteStudent(deleteRequest.getId());
    }

    @Getter
    @Setter
    public static class StudentDTO {
        private Student student;
        private List<Long> lectureIds;
    }

    @Getter
    @Setter
    public static class UpdateStudentWithLecturesDTO {
        private Long id;
        private Student student;
        private List<Long> lectureIds;
    }

    @Getter
    @Setter
    public static class DeleteRequest {
        private Long id;
    }
}
