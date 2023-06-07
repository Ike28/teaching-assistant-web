package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Admin;
import com.pasionatii.assistant.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService{

    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public Optional<Admin> findByEmailAndPassword(String email, String password) {

        return  adminRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Optional<Admin> findById(Long aLong) {

        return adminRepository.findById(aLong);
    }

    @Override
    public Admin save(Admin entity) {
        return adminRepository.save(entity);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
