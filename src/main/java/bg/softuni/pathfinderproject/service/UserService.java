package bg.softuni.pathfinderproject.service;

import bg.softuni.pathfinderproject.model.dto.UserLoginDTO;
import bg.softuni.pathfinderproject.model.dto.UserRegistrationDTO;
import bg.softuni.pathfinderproject.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    boolean registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    boolean checkForNonExistingUsername(String username);

    boolean checkForNonExistingEmail(String email);

    void logOutUser();

    UserEntity getUserByUsername(String username);
}