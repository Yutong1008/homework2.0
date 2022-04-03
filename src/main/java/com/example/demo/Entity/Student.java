package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name ="id")
    private int id;
    private String name;

    @OneToMany(targetEntity = Teacher.class, cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "enroll_class", referencedColumnName = "id")
//    public Set<Student> enrolledStudents = new HashSet<>();
    private List<Teacher> teachers;

    public Student(Student stu) {
        this.id = stu.getId();
        this.name = stu.getName();
    }
}

