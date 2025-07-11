package com.emrekirdim.springapi.repository;

import com.emrekirdim.springapi.model.StudentTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentTable, Long> {
}
