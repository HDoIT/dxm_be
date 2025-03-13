package com.dxm.dxmbe.service;

import com.dxm.dxmbe.model.User;
import com.dxm.dxmbe.repository.UserRepository;
import com.dxm.dxmbe.request.UserRequest;
import com.dxm.dxmbe.utils.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Auth auth;

    @Override
    public int register(UserRequest.registerUser registerUser) {
        try {
            User user = User.builder()
                    .userName(registerUser.getUserName())
                    .fullName(registerUser.getFullName())
                    .phone(registerUser.getPhone())
                    .email(registerUser.getEmail())
                    .password(auth.encodePassword(registerUser.getPassword()))
                    .urlAvatar(registerUser.getUrlAvatar())
                    .role("USER")
                    .gender(registerUser.getGender())
                    .dateOfBirth(registerUser.getDateOfBirth())
                    .budget(registerUser.getBudget())
                    .createAt(Instant.now())
                    .build();
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    @Override
    public String login(UserRequest.loginRequest loginRequest) {
        try{

            Optional<User> user = userRepository.findByUserName(loginRequest.getUserName());

            if(user.isPresent()){
                User userGenarate = User.builder().id(user.get().getId())
                        .userName(user.get().getUserName())
                        .build();
                if (auth.matchPassword(loginRequest.getPassWord(), user.get().getPassword())) {
                    return auth.generateToken(userGenarate);
                }
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public int forgetPassword(String username) {
        return 0;
    }

    @Override
    public int changePassword(String oldPassword, String newPassword) {
        return 0;
    }

    @Override
    public int resetPassword(String email) {
        return 0;
    }

    @Override
    public Optional<User> getUserDetail(String userName) {
        try{
            Optional<User> user = userRepository.findByUserName(userName);
            return user;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }


}
