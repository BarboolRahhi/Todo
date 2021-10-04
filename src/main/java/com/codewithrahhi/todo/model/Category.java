package com.codewithrahhi.todo.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "category")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "description")
    private String description;

}