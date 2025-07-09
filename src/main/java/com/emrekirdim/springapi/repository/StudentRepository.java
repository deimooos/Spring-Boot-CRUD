package com.emrekirdim.springapi.repository;

import com.emrekirdim.springapi.StudentLectureTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<StudentLectureTable, Long> {
}
