package com.example.Twitter_Clone20.Model;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "UserTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (unique = true)
    private String name;
    private String password;
    private String email;
    private Date dob;

    @CreationTimestamp
    private Date userRegistrationTime;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tweet> tweetList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Followers>followersList;
    public User() {
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


}
