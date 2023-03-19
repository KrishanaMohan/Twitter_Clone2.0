package com.example.Twitter_Clone20;

import com.example.Twitter_Clone20.Model.Tweet;
import com.example.Twitter_Clone20.Model.User;
import com.example.Twitter_Clone20.Repository.FollowerRepository;
import com.example.Twitter_Clone20.ResquestDto.FollowDto;
import com.example.Twitter_Clone20.ResquestDto.TweetDto;
import com.example.Twitter_Clone20.ResquestDto.UserDto;
import com.example.Twitter_Clone20.Services.FollowerService;
import com.example.Twitter_Clone20.Services.TweetService;
import com.example.Twitter_Clone20.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @Autowired
    FollowerService followerService;



    @PostMapping ("/Resitration")
    public ResponseEntity<String> resistration (@RequestBody UserDto userDto){
        userService.resistration(userDto);
        return new ResponseEntity<>("User resistration succesfull", HttpStatus.OK);
    }
//    @PostMapping ("/Login")
//    public ResponseEntity<String> Login (@RequestBody LoginDto loginDto){
//      String token=  service.Login(userDto);
//        return new ResponseEntity<>(token, HttpStatus.OK);
//    }

    @PostMapping ("/UpdateUser")
    public ResponseEntity<String> UpdateUser (@RequestBody UserDto newinfo){
        userService.UpdateUser(newinfo);
        return new ResponseEntity<>("User update succesfull", HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<User> getUserByName (@RequestParam String UserName){
      User user = userService.getUserByName(UserName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Integer id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/DeleteAccountByName")
    public ResponseEntity<String> DeleteAccountByName (@RequestParam String name){
        userService.DeleteAccountByName(name);
        return new ResponseEntity<>("User Deleted Succussful", HttpStatus.OK);
    }
    // Tweets
    @GetMapping("/findAllTweetByName")
    public ResponseEntity<List<Tweet>> findAllTweetByName (@RequestParam String name){
        List<Tweet> list= tweetService.getAllTweetByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping ("/tweet")
    public ResponseEntity<String> tweetByName (@RequestBody TweetDto tweetDto){
        tweetService.tweetByName(tweetDto);
        return new ResponseEntity<>("User tweet succesfull", HttpStatus.OK);
    }


// Follower
    @PostMapping ("/followByName")
    public ResponseEntity<String> followByName (@RequestBody FollowDto followDto){
        followerService.followByName(followDto);
        return new ResponseEntity<>("User succesfull follow", HttpStatus.OK);
    }

    @PostMapping ("/UnfollowByName")
    public ResponseEntity<String> UnfollowByName (@RequestBody FollowDto followDto){
        followerService.UnfollowByName(followDto);
        return new ResponseEntity<>("User succesfull Unfollow", HttpStatus.OK);
    }

}
