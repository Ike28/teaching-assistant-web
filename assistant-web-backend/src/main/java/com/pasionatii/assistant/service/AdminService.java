package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Admin;

import java.util.Optional;

public interface AdminService extends Service<Admin, Long>{

    Optional<Admin> findByEmailAndPassword(String email, String password);
}
