package com.dxm.dxmbe.controller;

import com.dxm.dxmbe.enums.ErrorCode;
import com.dxm.dxmbe.model.User;
import com.dxm.dxmbe.request.UserRequest;
import com.dxm.dxmbe.response.ResqBean;
import com.dxm.dxmbe.service.UserService;
import com.dxm.dxmbe.utils.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(value = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Auth auth;

    @PostMapping("/login")
    public ResqBean<String> login(@RequestBody UserRequest.loginRequest loginRequest) {
        return ResqBean.ok("success", userService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResqBean<Integer> register(@RequestBody UserRequest.registerUser registerUser) {
        try {
            return ResqBean.ok("success", userService.register(registerUser));
        }catch (Exception e) {
            return ResqBean.error(e.getMessage(), null, 400);
        }
    }

    @GetMapping("/auth/me")
    public ResqBean<Optional<User>> userDetail(@RequestHeader("Authorization") String token) {
        try {
            if (!auth.validateToken(token)) {
                return ResqBean.error(ErrorCode.ERROR_401_STR, null, ErrorCode.ERROR_401);
            }
            return ResqBean.ok("success", userService.getUserDetail(auth.getUsernameFromToken(token)));
        } catch (Exception e) {
            return ResqBean.error(e.getMessage(), null, 400);
        }

    }


}
