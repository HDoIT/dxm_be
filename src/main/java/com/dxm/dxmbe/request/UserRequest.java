package com.dxm.dxmbe.request;

import lombok.*;

public interface UserRequest {

    @Getter
    @Setter
    @Builder
    public class registerUser{
        private String userName;
        private String fullName;
        private String urlAvatar;
        private String email;
        private String phone;
        private String password;
        private String role = "USER";
        private String dateOfBirth;
        private String gender;
        private double budget;
    }

//    @Getter
//    @Setter
//    @Builder
//    public class getUserDetail{
//        private String userName;
//        private String fullName;
//        private String urlAvatar;
//        private String email;
//        private String phone;
//        private String password;
//        private String role;
//        private String dateOfBirth;
//        private String gender;
//        private String budget;
//    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class loginRequest{
        private String userName;
        private String passWord;
    }

}
