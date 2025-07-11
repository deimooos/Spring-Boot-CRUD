package com.emrekirdim.springapi.controller;

import com.emrekirdim.springapi.model.LectureTable;
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
    public LectureTable create(@RequestBody LectureTable lecture) {
        return lectureService.create(lecture);
    }

    @GetMapping("/all")
    public List<LectureTable> getAll() {
        return lectureService.getAll();
    }

    @PutMapping("/update")
    public LectureTable update(@RequestBody LectureDTO lectureDTO) {
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
        private LectureTable lecture;
    }

    @Getter
    @Setter
    public static class IdDTO {
        private Long id;
    }
}
