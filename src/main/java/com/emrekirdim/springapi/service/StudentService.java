package com.emrekirdim.springapi.service;

import com.emrekirdim.springapi.model.Lecture;
import com.emrekirdim.springapi.model.Student;
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

    public Student createStudent(Student student, List<Long> lectureIds) {
        Set<Lecture> lectures = new HashSet<>();
        for (Long id : lectureIds) {
            Lecture lecture = lectureRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Lecture not found with id: " + id));
            lectures.add(lecture);
        }

        student.setLectures(lectures);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentDetails, List<Long> lectureIds) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setName(studentDetails.getName());
        student.setRow(studentDetails.getRow());

        Set<Lecture> lectures = new HashSet<>();
        for (Long lectureId : lectureIds) {
            Lecture lecture = lectureRepository.findById(lectureId)
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
