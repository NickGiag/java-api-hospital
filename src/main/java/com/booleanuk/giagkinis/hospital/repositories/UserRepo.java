package com.booleanuk.giagkinis.hospital.repositories;

import com.booleanuk.giagkinis.hospital.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
