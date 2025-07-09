package com.emrekirdim.springapi.service;

import com.emrekirdim.springapi.StudentLectureTable;
import com.emrekirdim.springapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentLectureTable> getAll(){
        return repository.findAll();
    }

    public Optional<StudentLectureTable> getById(Long id){
        return repository.findById(id);
    }

    public StudentLectureTable create(StudentLectureTable studentLectureTable){
        return repository.save(studentLectureTable);
    }

    public StudentLectureTable update(Long id, StudentLectureTable updatedData){
        return repository.findById(id).map(existing -> {
            existing.setStudentRow(updatedData.getStudentRow());
            existing.setStudentName(updatedData.getStudentName());
            existing.setStudentSurname(updatedData.getStudentSurname());
            existing.setStudentLecture(updatedData.getStudentLecture());
            return repository.save(existing);
        }).orElse(null);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}