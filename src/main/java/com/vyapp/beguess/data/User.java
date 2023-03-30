package com.vyapp.beguess.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    @Column(unique = true)
    private String username = "";

    private String password = "";

    private long place = 0;

    private long score = 0;

    private boolean status = false;

}
