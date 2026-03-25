package org.daypilot.demo.html5eventcalendarspring.service;

import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.LoginRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.UserRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.UserResponseDTO;

public interface UserService {

    public UserResponseDTO createUser(UserRequestDTO user);

    public User getUserById (int id);

    public void updateUser (int id, UserRequestDTO user);

    public void deleteUser (int id);

    public User login(LoginRequestDTO credentials);

}
