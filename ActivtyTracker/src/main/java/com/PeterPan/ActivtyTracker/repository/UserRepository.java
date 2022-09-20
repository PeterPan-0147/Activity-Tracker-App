package com.PeterPan.ActivtyTracker.repository;

import com.PeterPan.ActivtyTracker.model.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByEmailAndPassword(String email, String password);

    public Long countByEmail(String email);
}
