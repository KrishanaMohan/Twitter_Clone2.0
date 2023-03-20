package com.example.Twitter_Clone20.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@Table(name = "Tweets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String tweetBy;
    private String msg;

    @CreationTimestamp
    private Date tweetTime;
    @ManyToOne
    private User user;

}
