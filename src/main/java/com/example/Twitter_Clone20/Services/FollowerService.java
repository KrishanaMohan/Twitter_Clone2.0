package com.example.Twitter_Clone20.Services;

import com.example.Twitter_Clone20.Model.Followers;
import com.example.Twitter_Clone20.Repository.FollowerRepository;
import com.example.Twitter_Clone20.ResquestDto.FollowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {
    @Autowired
    FollowerRepository followerRepository;

    public void followByName ( FollowDto followDto){
        Followers follow=new Followers();
        follow.setFollowBy(followDto.getFollowBy());
        follow.setFollowTo(followDto.getFollowTo());
        followerRepository.save(follow);

    }

    public void UnfollowByName (FollowDto followDto){
       List<Followers> followersList=followerRepository.findAll();
       Integer id=null;
       for(Followers follow:followersList){
           if(followDto.getFollowBy().equals(follow.getFollowBy()) && follow.getFollowTo().equals(follow.getFollowTo())){
               id=follow.getId();
               followerRepository.deleteById(id);
           }

       }


    }
}
