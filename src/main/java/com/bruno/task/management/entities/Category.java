package com.bruno.task.management.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorydb")
@Getter@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String category;
    @OneToMany(mappedBy = "category")
    private List<Task> tasks;
}
