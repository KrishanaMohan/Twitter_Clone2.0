package com.example.Twitter_Clone20.Services;
import com.example.Twitter_Clone20.JWT.JwtService;
import com.example.Twitter_Clone20.Model.User;
import com.example.Twitter_Clone20.Repository.UserRepository;
import com.example.Twitter_Clone20.ResquestDto.LoginDto;
import com.example.Twitter_Clone20.ResquestDto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;

    public void registration ( UserDto userDto){
        User user=new User();
       user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setMobile(userDto.getMobile());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        userRepository.save(user);
    }
    public void UpdateUser (UserDto newinfo){
        User user=userRepository.findByName(newinfo.getName());
        user.setDob(newinfo.getDob());
        user.setEmail(newinfo.getEmail());
        user.setName(newinfo.getName());
        user.setPassword(newinfo.getPassword());
        userRepository.save(user);
    }

    public User getUserByName (String  userName){
        User user=userRepository.findByName(userName);
       return user;
    }

    public User getUserById(Integer userId) throws Exception {
        User user=userRepository.findById(userId).get();
        if(user==null){
            throw new Exception();
        }
         return user;

    }
    public void  DeleteAccountByName(String name){
        User user=userRepository.findByName(name);
        userRepository.delete(user);
    }
    public String Authentication(LoginDto loginDto) throws Exception{
        User user=userRepository.findByName(loginDto.getName());
        if(user==null|| !user.getPassword().equals(loginDto.getPassword()))
             throw new Exception("UserName or Password is Wrong");

       return  jwtService.generateToken(loginDto.getName());
    }
}
