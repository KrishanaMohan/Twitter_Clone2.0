package com.example.Twitter_Clone20.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "followers")
public class Followers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String followBy;
    private String followTo;

    @CreationTimestamp
    private Date followTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    private User user;

    public Followers() {
    }

    public String getFollowBy() {
        return followBy;
    }

    public void setFollowBy(String followBy) {
        this.followBy = followBy;
    }

    public String getFollowTo() {
        return followTo;
    }

    public void setFollowTo(String followTo) {
        this.followTo = followTo;
    }
}
