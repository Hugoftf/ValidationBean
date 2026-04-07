package com.github.Hugoftf.Validation_Spring.repository;

import com.github.Hugoftf.Validation_Spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
