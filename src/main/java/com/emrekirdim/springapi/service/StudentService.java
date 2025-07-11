package com.emrekirdim.springapi.service;

import com.emrekirdim.springapi.model.LectureTable;
import com.emrekirdim.springapi.model.StudentTable;
import com.emrekirdim.springapi.repository.LectureRepository;
import com.emrekirdim.springapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    public StudentTable createStudent(StudentTable student, List<Long> lectureIds) {
        Set<LectureTable> lectures = new HashSet<>();
        for (Long id : lectureIds) {
            LectureTable lecture = lectureRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Lecture not found with id: " + id));
            lectures.add(lecture);
        }

        student.setLectures(lectures);
        return studentRepository.save(student);
    }

    public List<StudentTable> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentTable updateStudent(Long id, StudentTable studentDetails, List<Long> lectureIds) {
        StudentTable student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setName(studentDetails.getName());
        student.setRow(studentDetails.getRow());

        Set<LectureTable> lectures = new HashSet<>();
        for (Long lectureId : lectureIds) {
            LectureTable lecture = lectureRepository.findById(lectureId)
                    .orElseThrow(() -> new RuntimeException("Lecture not found with id: " + lectureId));
            lectures.add(lecture);
        }
        student.setLectures(lectures);

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
