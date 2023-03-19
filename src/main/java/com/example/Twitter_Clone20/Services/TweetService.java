package com.example.Twitter_Clone20.Services;

import com.example.Twitter_Clone20.Model.Tweet;
import com.example.Twitter_Clone20.Repository.TweetsRepository;
import com.example.Twitter_Clone20.ResquestDto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TweetService {
    @Autowired
    TweetsRepository tweetsRepository;

    public List<Tweet> getAllTweetByName ( String name){
        List<Tweet> alltweets=tweetsRepository.findAll();
        List<Tweet>list=new ArrayList<>();
        for(Tweet tweet:alltweets){
            if(name.equals(tweet.getTweetBy()))
                 list.add(tweet);
        }

        return list;
    }


    public void tweetByName (TweetDto tweetDto){
        Tweet tweet=new Tweet();
        tweet.setTweetBy(tweetDto.getTweetBy());
        tweet.setTweetBy(tweetDto.getMsg());
        tweetsRepository.save(tweet);
    }
}
