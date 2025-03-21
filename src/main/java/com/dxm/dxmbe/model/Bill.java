package com.dxm.dxmbe.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, name = "name", length = 255)
    private String name;

    @Column(nullable = true, name = "description", length = 255)
    private String description;

    @Column(nullable = false, name = "category_id")
    private Long categoryId;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Column(nullable = true, name = "amount")
    private Double amount;

    @Column(nullable = false, name = "date")
    private Instant date;

    @Column(nullable = true, name = "update_at")
    private Instant updateAt;

    @Column(nullable = true, name = "create_at")
    private Instant createAt;

}
