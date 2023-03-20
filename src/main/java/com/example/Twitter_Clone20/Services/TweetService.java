package com.example.Twitter_Clone20.Services;

import com.example.Twitter_Clone20.Model.Tweet;
import com.example.Twitter_Clone20.Model.User;
import com.example.Twitter_Clone20.Repository.TweetsRepository;
import com.example.Twitter_Clone20.Repository.UserRepository;
import com.example.Twitter_Clone20.ResquestDto.TweetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    @Autowired
    TweetsRepository tweetsRepository;

    @Autowired
    UserRepository userRepository;

   public List<Tweet> getAllTweetByName (String name){
        User user=userRepository.findByName(name);
        List<Tweet> alltweets= user.getTweetList();
        return alltweets;
    }


    public void tweetByName (TweetDto tweetDto){
        Tweet tweet=new Tweet();
        User user=userRepository.findByName(tweetDto.getTweetBy());
        tweet.setTweetBy(tweetDto.getTweetBy());
        tweet.setMsg(tweetDto.getMsg());


        List<Tweet> list=user.getTweetList();
        list.add(tweet);
        tweet.setUser(user);
        user.setTweetList(list);

        userRepository.save(user);
        //tweetsRepository.save(tweet);
    }
}
