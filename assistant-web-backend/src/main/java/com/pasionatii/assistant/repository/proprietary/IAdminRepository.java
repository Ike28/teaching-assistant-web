package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdminRepository extends IRepository<Admin> {
    Optional<Admin> findByEmailAndPassword(String email, String password);

}
