package org.daypilot.demo.html5eventcalendarspring.repository;

import java.util.Optional;

import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByEmail(String email);
}
