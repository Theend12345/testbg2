package com.vyapp.beguess.service;


import com.vyapp.beguess.data.Tasks;

public interface TaskService {

    Tasks updateTask(Tasks task);

    void deleteByKey();

    Tasks getTask();

}
