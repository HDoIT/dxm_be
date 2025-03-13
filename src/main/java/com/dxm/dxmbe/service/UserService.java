package com.dxm.dxmbe.service;

import com.dxm.dxmbe.model.User;
import com.dxm.dxmbe.request.UserRequest;

import java.util.Optional;

public interface UserService {

    int register(UserRequest.registerUser registerUser);

    String login(UserRequest.loginRequest loginRequest);

    int forgetPassword(String username);

    int changePassword(String oldPassword, String newPassword);

    int resetPassword(String email);

    Optional<User> getUserDetail(String email);

}
