package com.bruno.task.management.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "taskdb")
@Getter@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task_name;
    private String description;
    private LocalDate start_time;
    private LocalDate end_time;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String priorities;

}
