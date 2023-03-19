package com.example.Twitter_Clone20.Repository;

import com.example.Twitter_Clone20.Model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetsRepository extends JpaRepository<Tweet,Integer> {
}
