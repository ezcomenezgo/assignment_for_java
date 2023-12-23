package com.example.wholesale_system.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO of user
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUserByUsername(String username);
}
