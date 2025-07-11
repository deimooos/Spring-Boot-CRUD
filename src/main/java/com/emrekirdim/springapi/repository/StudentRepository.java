package com.emrekirdim.springapi.repository;

import com.emrekirdim.springapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
