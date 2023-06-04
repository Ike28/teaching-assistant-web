package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String passwordToken);
}
