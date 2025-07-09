package com.emrekirdim.springapi;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "studentLecture")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class StudentLectureTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentRow")
    private int studentRow;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "studentSurname")
    private String studentSurname;

    @Column(name = "studentLecture")
    private String studentLecture;
}
