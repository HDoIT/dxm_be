package com.dxm.dxmbe.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "albumn")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Albumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, name = "title")
    private String title;

    @Column(nullable = true,name = "description")
    private String description;

    @Column(nullable = true, name = "user_id")
    private String userId;

    @Column(nullable = true, name = "url_image")
    private String urlImage;

    @Column(nullable = false, name = "date")
    private Instant date;

    @Column(nullable = false, name = "create_at")
    private Instant createAt;

    @Column(nullable = true, name = "update_at")
    private Instant updateAt;
}
