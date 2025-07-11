package com.emrekirdim.springapi.controller;

import com.emrekirdim.springapi.model.Lecture;
import com.emrekirdim.springapi.service.LectureService;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecture")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/create")
    public Lecture create(@RequestBody Lecture lecture) {
        return lectureService.create(lecture);
    }

    @GetMapping("/all")
    public List<Lecture> getAll() {
        return lectureService.getAll();
    }

    @PutMapping("/update")
    public Lecture update(@RequestBody LectureDTO lectureDTO) {
        return lectureService.update(lectureDTO.getId(), lectureDTO.getLecture());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody IdDTO idDTO) {
        lectureService.delete(idDTO.getId());
    }

    @Getter
    @Setter
    public static class LectureDTO {
        private Long id;
        private Lecture lecture;
    }

    @Getter
    @Setter
    public static class IdDTO {
        private Long id;
    }
}
