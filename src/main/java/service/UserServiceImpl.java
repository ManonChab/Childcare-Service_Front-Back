package service;

import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.UserRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.UserResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.exception.BadIdException;
import org.daypilot.demo.html5eventcalendarspring.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mappper.UserMapper;

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

    @Override
    public UserResponseDTO createUser(UserRequestDTO userIn) {
        User user = userMapper.toEntity(userIn);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);        
        return userMapper.toEntity(user);

    }

    @Override
    public User getUserById (int id){
        return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The user does not exist"));
    }

    @Override
    @Transactional
    public void updateUser(int id, UserRequestDTO user) {
        if(!user.id().equals(getUserById(id).getId())){
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

}
