package com.myproject.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer  id;

    private String username;

    private String password;

    public User(String UserName,String Password)
    {
        this.username=UserName;
        this.password=Password;
    }




}
