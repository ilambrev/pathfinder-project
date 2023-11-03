package bg.sodtuni.pathfinderproject.service.impl;

import bg.sodtuni.pathfinderproject.model.dto.UserRegistrationDTO;
import bg.sodtuni.pathfinderproject.model.entity.RoleEntity;
import bg.sodtuni.pathfinderproject.model.entity.UserEntity;
import bg.sodtuni.pathfinderproject.model.enums.RoleEnum;
import bg.sodtuni.pathfinderproject.model.enums.UserLevelEnum;
import bg.sodtuni.pathfinderproject.repository.RoleRepository;
import bg.sodtuni.pathfinderproject.repository.UserRepository;
import bg.sodtuni.pathfinderproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        RoleEntity role = this.roleRepository.findByName(RoleEnum.USER);
        Set<RoleEntity> roles = new HashSet<>();
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

}