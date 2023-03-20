package com.example.Twitter_Clone20.Controller;
import com.example.Twitter_Clone20.Model.User;
import com.example.Twitter_Clone20.ResquestDto.UserDto;
import com.example.Twitter_Clone20.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/Registration")
    public ResponseEntity<String> registration (@RequestBody @Valid UserDto userDto){
        userService.registration(userDto);
        return new ResponseEntity<>("User registration successfully", HttpStatus.OK);
    }
//    @PostMapping ("/Login")
//    public ResponseEntity<String> Login (@RequestBody LoginDto loginDto){
//      String token=  service.Login(userDto);
//        return new ResponseEntity<>(token, HttpStatus.OK);
//    }

    @PutMapping("/UpdateUser")
    public ResponseEntity<String> UpdateUser (@RequestBody UserDto newinfo){
        userService.UpdateUser(newinfo);
        return new ResponseEntity<>("User update successfully", HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<User> getUserByName (@RequestParam String UserName){
        User user = userService.getUserByName(UserName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/findById{id}")
    public ResponseEntity<User> getUserById (@PathVariable Integer id) throws Exception {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/DeleteAccountByName")
    public ResponseEntity<String> DeleteAccountByName (@RequestParam String name){
        userService.DeleteAccountByName(name);
        return new ResponseEntity<>("User Deleted successfully", HttpStatus.OK);
    }
}
