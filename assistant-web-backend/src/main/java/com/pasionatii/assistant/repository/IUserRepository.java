package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPasswordToken(String email, String passwordToken);
}
