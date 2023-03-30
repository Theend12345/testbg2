package com.vyapp.beguess.service;

import com.vyapp.beguess.data.TaskRepository;
import com.vyapp.beguess.data.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImp implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImp(@Autowired TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tasks updateTask(Tasks task) {

        repository.save(task);

        return task;
    }

    @Override
    public void deleteByKey() {
        repository.deleteByKeyword("key");
    }

    @Override
    public Tasks getTask() {
        return repository.findByKeyword("key");
    }

}
