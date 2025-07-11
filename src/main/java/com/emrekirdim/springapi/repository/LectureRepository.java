package com.emrekirdim.springapi.repository;

import com.emrekirdim.springapi.model.LectureTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<LectureTable, Long> {
}
