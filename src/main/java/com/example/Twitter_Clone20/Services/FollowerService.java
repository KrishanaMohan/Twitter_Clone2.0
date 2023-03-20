package com.example.Twitter_Clone20.Services;
import com.example.Twitter_Clone20.Model.Followers;
import com.example.Twitter_Clone20.Model.User;
import com.example.Twitter_Clone20.Repository.FollowerRepository;
import com.example.Twitter_Clone20.Repository.UserRepository;
import com.example.Twitter_Clone20.ResquestDto.FollowDto;
import com.example.Twitter_Clone20.ResquestDto.UnFollowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowerService {
    @Autowired
    FollowerRepository followerRepository;

    @Autowired
    UserRepository userRepository;

    public String followByName ( FollowDto followDto){

        User user=userRepository.findByName(followDto.getFollowTo());
        List<Followers> list=user.getFollowersList();

        // if already follow the become unfollow
        if(list.contains(followDto.getFollowBy())){
            UnFollowDto unFollowDto=new UnFollowDto();
            unFollowDto.setUnfollowBy(followDto.getFollowBy());
            unFollowDto.setUnfollowTo(followDto.getFollowTo());
            return UnfollowByName(unFollowDto);
        }

        Followers follow=new Followers();
        follow.setFollowBy(followDto.getFollowBy());
        follow.setFollowTo(followDto.getFollowTo());

        list.add(follow);
        user.setFollowersList(list);
        follow.setUser(user);
        userRepository.save(user);
        return "User successfully follow";
    }

    public String UnfollowByName (UnFollowDto unfollowDto){

        List<Followers>list=followerRepository.findAll();
        Integer id=null;
        for(Followers followers:list){
            if(followers.getFollowBy().equals(unfollowDto.getUnfollowBy()) && followers.getFollowTo().equals(unfollowDto.getUnfollowTo()))
                id=followers.getId();
        }

       followerRepository.deleteById(id);
        return "User successfully Unfollow";

    }
    public List<String> MyFollowers( String name){
       User user=userRepository.findByName(name);
       List<Followers> list=user.getFollowersList();
       List<String >myTotalFollowers=new ArrayList<>();
       for(Followers followers:list){
           myTotalFollowers.add(followers.getFollowBy());
       }

       return myTotalFollowers;

    }
}
