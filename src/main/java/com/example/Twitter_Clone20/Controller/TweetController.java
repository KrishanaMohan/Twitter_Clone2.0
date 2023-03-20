package com.example.Twitter_Clone20.Controller;

import com.example.Twitter_Clone20.Model.Tweet;
import com.example.Twitter_Clone20.ResquestDto.TweetDto;
import com.example.Twitter_Clone20.Services.FollowerService;
import com.example.Twitter_Clone20.Services.TweetService;
import com.example.Twitter_Clone20.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {
    @Autowired
    TweetService tweetService;
    @GetMapping("/findAllTweetByName")
    public ResponseEntity<List<Tweet>> findAllTweetByName (@RequestParam String name){
        List<Tweet> list= tweetService.getAllTweetByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/tweet")
    public ResponseEntity<String> tweetByName (@RequestBody TweetDto tweetDto){
        tweetService.tweetByName(tweetDto);
        return new ResponseEntity<>("User tweet succesfull", HttpStatus.OK);
    }

}
