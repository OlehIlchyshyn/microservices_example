package com.example.resourceservice.repositories;

import com.example.resourceservice.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {
    @Query("SELECT ud FROM UserDetails ud where ud.name=?1")
    List<UserDetails> findUserByName(String name);
}
