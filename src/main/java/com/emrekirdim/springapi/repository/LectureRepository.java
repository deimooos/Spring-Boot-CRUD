package com.emrekirdim.springapi.repository;

import com.emrekirdim.springapi.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
