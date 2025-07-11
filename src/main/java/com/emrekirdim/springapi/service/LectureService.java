package com.emrekirdim.springapi.service;

import com.emrekirdim.springapi.model.Lecture;
import com.emrekirdim.springapi.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public Lecture create(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public List<Lecture> getAll() {
        return lectureRepository.findAll();
    }

    public Lecture update(Long id, Lecture lectureDetails) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        lecture.setName(lectureDetails.getName());
        return lectureRepository.save(lecture);
    }

    public void delete(Long id) {
        lectureRepository.deleteById(id);
    }
}
