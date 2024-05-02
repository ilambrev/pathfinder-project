package bg.softuni.pathfinderproject.service.impl;

import bg.softuni.pathfinderproject.exception.UserNotFoundException;
import bg.softuni.pathfinderproject.model.dto.UserLoginDTO;
import bg.softuni.pathfinderproject.model.dto.UserRegistrationDTO;
import bg.softuni.pathfinderproject.model.entity.RoleEntity;
import bg.softuni.pathfinderproject.model.entity.UserEntity;
import bg.softuni.pathfinderproject.model.enums.RoleEnum;
import bg.softuni.pathfinderproject.model.enums.UserLevelEnum;
import bg.softuni.pathfinderproject.repository.RoleRepository;
import bg.softuni.pathfinderproject.repository.UserRepository;
import bg.softuni.pathfinderproject.service.UserService;
import bg.softuni.pathfinderproject.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }


    @Override
    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        RoleEntity role = this.roleRepository.findByName(RoleEnum.USER);
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(role);

        UserEntity user = new UserEntity()
                .setUsername(userRegistrationDTO.getUsername())
                .setFullName(userRegistrationDTO.getFullName())
                .setEmail(userRegistrationDTO.getEmail())
                .setAge(userRegistrationDTO.getAge())
                .setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()))
                .setLevel(UserLevelEnum.BEGINNER)
                .setRoles(roles);

        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        Optional<UserEntity> userOptional = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if (userOptional.isEmpty()) {
            return false;
        }

        UserEntity user = userOptional.get();

        if (!this.passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            return false;
        }

        this.currentUser
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setAge(user.getAge())
                .setFullName(user.getFullName())
                .setLevel(user.getLevel())
                .setRoles(user.getRoles())
                .setLogged(true);

        return true;
    }

    @Override
    public boolean checkForNonExistingUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public boolean checkForNonExistingEmail(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public void logOutUser() {
        this.currentUser.logout();
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username: " + username + "not found!"));
    }

}