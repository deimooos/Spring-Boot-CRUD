package com.emrekirdim.springapi.controller;

import com.emrekirdim.springapi.StudentLectureTable;
import com.emrekirdim.springapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentLectureTable> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentLectureTable getById(@PathVariable Long id){
        return studentService.getById(id).orElse(null);
    }

    @PostMapping
    public StudentLectureTable create(@RequestBody StudentLectureTable studentLectureTable){
        return studentService.create(studentLectureTable);
    }

    @PutMapping("/{id}")
    public StudentLectureTable update(@PathVariable Long id, @RequestBody StudentLectureTable updated){
        return studentService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
}
