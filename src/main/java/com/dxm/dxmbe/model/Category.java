package com.dxm.dxmbe.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500, nullable = false, unique = true, name = "name")
    private String name;

    @Column(length = 500, nullable = true,name = "description")
    private String description;

    @Column(nullable = true,name = "icon")
    private String icon;
}
