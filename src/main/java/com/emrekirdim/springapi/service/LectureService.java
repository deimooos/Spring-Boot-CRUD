package com.emrekirdim.springapi.service;

import com.emrekirdim.springapi.model.LectureTable;
import com.emrekirdim.springapi.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureTable create(LectureTable lecture) {
        return lectureRepository.save(lecture);
    }

    public List<LectureTable> getAll() {
        return lectureRepository.findAll();
    }

    public LectureTable update(Long id, LectureTable lectureDetails) {
        LectureTable lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        lecture.setName(lectureDetails.getName());
        return lectureRepository.save(lecture);
    }

    public void delete(Long id) {
        lectureRepository.deleteById(id);
    }
}
