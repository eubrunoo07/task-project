package com.bruno.task.management.entities;

import com.bruno.task.management.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "task_tb")
@Getter@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String task_name;
    @Column
    private String description;
    @Column
    private LocalDate start_time;
    @Column
    private LocalDate end_time;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column
    private String priorities;
    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
