package com.vyapp.beguess.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tasksss")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id = 0;

    private String word = "";
    private String res = "";
    private String description = "";

    private String keyword = "key";

}
