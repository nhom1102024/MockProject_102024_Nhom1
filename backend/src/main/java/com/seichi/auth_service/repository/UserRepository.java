package com.seichi.auth_service.repository;

import com.seichi.auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on October 2024
 *
 * @author Seichi
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}
