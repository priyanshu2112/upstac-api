package org.upgrad.upstac.auth.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;
import org.upgrad.upstac.users.models.AccountStatus;
import org.upgrad.upstac.users.roles.UserRole;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
public class RegisterService {

    @Autowired
    private UserService userService;


    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);

    public User addUser(RegisterRequest registerRequest) {

        if (userService.findByUserName(registerRequest.getUserName()) != null) {
            throw new AppException("Username exist!");
        }
        if (userService.findByEmail(registerRequest.getEmail()) != null) {
            throw new AppException("User with same EMAIL exist!");
        }
        if (userService.findByPhoneNumber(registerRequest.getPhoneNumber()) != null) {
            throw new AppException("User with same mobile number exist!");
        }

        try {
            User user = new User();
            user.setAddress(registerRequest.getAddress());
            user.setEmail(registerRequest.getEmail());
            user.setRoles(userService.getRoleFor(UserRole.USER));
            user.setPassword(userService.toEncrypted(registerRequest.getPassword()));
            user.setGender(registerRequest.getGender());
            user.setPhoneNumber(registerRequest.getPhoneNumber());
            user.setUserName(registerRequest.getUserName());
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setCreated(LocalDateTime.now());
            user.setDateOfBirth(LocalDate.parse(registerRequest.getDateOfBirth()));
            user.setStatus(AccountStatus.APPROVED);
            user.setPinCode(registerRequest.getPinCode());
            return userService.saveInDatabase(user);
        } catch (Exception ex) {
            throw new AppException(ex.getMessage());
        }

    }

    public User addDoctor(RegisterRequest registerRequest) {

        if (userService.findByUserName(registerRequest.getUserName()) != null) {
            throw new AppException("Username exist!");
        }
        if (userService.findByEmail(registerRequest.getEmail()) != null) {
            throw new AppException("User with same EMAIL exist!");
        }
        if (userService.findByPhoneNumber(registerRequest.getPhoneNumber()) != null) {
            throw new AppException("User with same mobile number exist!");
        }

        try {
            User user = new User();
            user.setAddress(registerRequest.getAddress());
            user.setEmail(registerRequest.getEmail());
            user.setRoles(userService.getRoleFor(UserRole.DOCTOR));
            user.setPassword(userService.toEncrypted(registerRequest.getPassword()));
            user.setGender(registerRequest.getGender());
            user.setPhoneNumber(registerRequest.getPhoneNumber());
            user.setUserName(registerRequest.getUserName());
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setCreated(LocalDateTime.now());
            user.setDateOfBirth(LocalDate.parse(registerRequest.getDateOfBirth()));
            user.setStatus(AccountStatus.INITIATED);
            user.setPinCode(registerRequest.getPinCode());
            return userService.saveInDatabase(user);
        } catch (Exception ex) {
            throw new AppException(ex.getMessage());
        }
    }


    public User addTester(RegisterRequest registerRequest) {

        if (userService.findByUserName(registerRequest.getUserName()) != null) {
            throw new AppException("Username exist!");
        }
        if (userService.findByEmail(registerRequest.getEmail()) != null) {
            throw new AppException("User with same EMAIL exist!");
        }
        if (userService.findByPhoneNumber(registerRequest.getPhoneNumber()) != null) {
            throw new AppException("User with same mobile number exist!");
        }

        try {
            User user = new User();
            user.setAddress(registerRequest.getAddress());
            user.setEmail(registerRequest.getEmail());
            user.setRoles(userService.getRoleFor(UserRole.TESTER));
            user.setPassword(userService.toEncrypted(registerRequest.getPassword()));
            user.setGender(registerRequest.getGender());
            user.setPhoneNumber(registerRequest.getPhoneNumber());
            user.setUserName(registerRequest.getUserName());
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setCreated(LocalDateTime.now());
            user.setDateOfBirth(LocalDate.parse(registerRequest.getDateOfBirth()));
            user.setStatus(AccountStatus.INITIATED);
            user.setPinCode(registerRequest.getPinCode());
            return userService.saveInDatabase(user);
        } catch (Exception ex) {
            throw new AppException(ex.getMessage());
        }

    }


}
