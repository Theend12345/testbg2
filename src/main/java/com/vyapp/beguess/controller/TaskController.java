package com.vyapp.beguess.controller;

import com.vyapp.beguess.data.Tasks;
import com.vyapp.beguess.service.TaskServiceImp;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Log
@RequestMapping("/task")
public class TaskController {

    private final TaskServiceImp taskService;

    @PostMapping
    @RequestMapping("/update")
    ResponseEntity<Tasks> update(@Validated @RequestBody Tasks task){
        taskService.deleteByKey();
        Tasks newTask = taskService.updateTask(task);
        return ResponseEntity.ok(newTask);
    }

    @GetMapping
    @RequestMapping("/gettask")
    ResponseEntity<Tasks> getTask(){
        return ResponseEntity.ok(taskService.getTask());
    }

}
