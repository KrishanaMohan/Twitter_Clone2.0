package com.example.Twitter_Clone20.Repository;

import com.example.Twitter_Clone20.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
   public User findByName(String name);
}
