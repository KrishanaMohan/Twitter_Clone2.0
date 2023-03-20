package com.example.Twitter_Clone20.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "followers")
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
