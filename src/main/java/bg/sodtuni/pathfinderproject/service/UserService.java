package bg.sodtuni.pathfinderproject.service;

import bg.sodtuni.pathfinderproject.model.dto.UserRegistrationDTO;

public interface UserService {

    boolean registerUser(UserRegistrationDTO userRegistrationDTO);

}