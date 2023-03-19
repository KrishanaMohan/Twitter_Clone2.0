package com.example.Twitter_Clone20.Repository;

import com.example.Twitter_Clone20.Model.Followers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Followers,Integer> {

}
