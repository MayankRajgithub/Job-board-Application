package com.jobboard.Job.Board.Apllicatins.repository;

import com.jobboard.Job.Board.Apllicatins.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>  {
public Optional<User> findByEmail(String email);
}
