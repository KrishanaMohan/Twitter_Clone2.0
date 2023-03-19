package com.example.Twitter_Clone20.Services;

import com.example.Twitter_Clone20.Model.User;
import com.example.Twitter_Clone20.ResquestDto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    com.example.Twitter_Clone20.Repository.UserRepository UserRepository;

    public void resistration ( UserDto userDto){
        User user=new User();
       user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        UserRepository.save(user);
    }
    public void UpdateUser (UserDto newinfo){
        User user=UserRepository.findByName(newinfo.getName());
        user.setDob(newinfo.getDob());
        user.setEmail(newinfo.getEmail());
        user.setName(newinfo.getName());
        user.setPassword(newinfo.getPassword());
        UserRepository.save(user);
    }

    public User getUserByName (String  userName){
        User user=UserRepository.findByName(userName);
       return user;
    }

    public User getUserById(Integer userId){
        User user=UserRepository.findById(userId).get();
        return user;
    }

    public void  DeleteAccountByName(String name){
        User user=UserRepository.findByName(name);
        UserRepository.delete(user);
    }

}
