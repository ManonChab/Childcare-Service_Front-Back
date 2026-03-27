package org.daypilot.demo.html5eventcalendarspring.service;

import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.LoginRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.UserRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.UserResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.exception.BadIdException;
import org.daypilot.demo.html5eventcalendarspring.mappper.UserMapper;
import org.daypilot.demo.html5eventcalendarspring.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
}

    public UserResponseDTO createUser(UserRequestDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // ⚡ hash here
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setPhone(userDTO.getPhone());
        User savedUser = userRepository.save(user);

        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public User getUserById (int id){
        return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The user does not exist"));
    }

    @Override
    @Transactional
    public void updateUser(int id, UserRequestDTO user) {
        if(!user.getId().equals(getUserById(id).getId())){
            throw new BadIdException("Problems with id autentication");
    }
        User updatedUser = getUserById(id);
        userMapper.updateEntityFromDto(user, updatedUser);
        userRepository.save(updatedUser);
    }  

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    @Override
    public User login(LoginRequestDTO loginDTO) {
    User user = userRepository.findByEmail(loginDTO.email())
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(loginDTO.password(), user.getPassword())) {
        throw new RuntimeException("Invalid password");
    }

    return user; 
}

}
