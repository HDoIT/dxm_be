package com.dxm.dxmbe.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "username",unique = true)
    private String userName;

    @Column(nullable = false, name = "fullname")
    private String fullName;

    @Column(nullable = true,name = "url_avatar")
    private String urlAvatar;

    @Column(nullable = false,name = "email",unique = true)
    private String email;

    @Column(nullable = false, name = "phone",unique = true)
    private String phone;

    @Column(nullable = false,name ="password")
    private String password;

    @Column(nullable = true, name = "role")
    private String role;

    @Column(nullable = true,name = "date_of_birth")
    private String dateOfBirth;

    @Column(nullable = true,name = "gender")
    private String gender;

    @Column(nullable = true, name = "budget")
    private double budget = 0;

    @Column(nullable = true, name = "create_at")
    private Instant createAt;

    @Column(nullable = true, name = "update_at")
    private Instant updateAt;

    @Column(nullable = true,name = "reset_password_token")
    private String resetPasswordToken;
}
