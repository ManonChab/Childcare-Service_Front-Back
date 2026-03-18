package org.daypilot.demo.html5eventcalendarspring.repository;

import org.daypilot.demo.html5eventcalendarspring.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
