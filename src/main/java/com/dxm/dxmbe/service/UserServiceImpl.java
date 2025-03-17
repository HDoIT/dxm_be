package com.dxm.dxmbe.service;

import com.dxm.dxmbe.enums.ErrorException;
import com.dxm.dxmbe.exceptions.DxmException;
import com.dxm.dxmbe.model.User;
import com.dxm.dxmbe.repository.UserRepository;
import com.dxm.dxmbe.request.UserRequest;
import com.dxm.dxmbe.utils.Auth;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
            if(userRepository.existsByEmail(registerUser.getEmail())) {
                throw new DxmException(ErrorException.EMAIL_EXIST);
            }
            if(userRepository.existsByUserName(registerUser.getUserName())) {
                throw new DxmException(ErrorException.USERNAME_EXIST);
            }
            if(userRepository.existsByPhone(registerUser.getPhone())) {
                throw new DxmException(ErrorException.PHONE_EXIST);
            }
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
        }catch (DxmException e){
            throw e;
        } catch (Exception e) {
            throw new DxmException(ErrorException.ERROR_SERVER);
        }

    }

    @Override
    public String login(UserRequest.loginRequest loginRequest) {
        try{

            Optional<User> user = userRepository.findByUserName(loginRequest.getUserName());

            if(user.isPresent()){
                User userGenerate = User.builder().id(user.get().getId())
                        .userName(user.get().getUserName())
                        .build();
                if (auth.matchPassword(loginRequest.getPassWord(), user.get().getPassword())) {
                    return auth.generateToken(userGenerate);
                }
                throw new DxmException(ErrorException.USERNAME_PASSWORD_WRONG);
            }
            throw new DxmException(ErrorException.USER_NOT_EXIST);

        }catch (DxmException e){
            throw e;
        }catch (Exception ex){
            throw new DxmException(ErrorException.ERROR_SERVER);
        }
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
