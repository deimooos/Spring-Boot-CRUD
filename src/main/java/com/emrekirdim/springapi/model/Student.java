package com.emrekirdim.springapi.model;

import javax.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int row;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_lecture",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id", referencedColumnName = "id")
    )
    private Set<Lecture> lectures = new HashSet<>();
}

