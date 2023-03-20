package com.example.Twitter_Clone20.Controller;

import com.example.Twitter_Clone20.ResquestDto.FollowDto;
import com.example.Twitter_Clone20.ResquestDto.UnFollowDto;
import com.example.Twitter_Clone20.Services.FollowerService;
import com.example.Twitter_Clone20.Services.TweetService;
import com.example.Twitter_Clone20.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FollowerController {

    @Autowired
    FollowerService followerService;
    @PostMapping("/followByName")
    public ResponseEntity<String> followByName (@RequestBody FollowDto followDto){
      String s=  followerService.followByName(followDto);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping ("/UnfollowByName")
    public ResponseEntity<String> UnfollowByName (@RequestBody UnFollowDto unFollowDto){
        String s=followerService.UnfollowByName(unFollowDto);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping("/findMyAllFollowers")
    public ResponseEntity<List<String>> findAllFollower(@RequestParam String name){
        List<String> myfollews=followerService.MyFollowers(name);
        return new ResponseEntity<>(myfollews,HttpStatus.OK);
    }
}
