package com.vyapp.beguess.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks, Long> {

    void deleteByKeyword(String key);

    Tasks findByKeyword(String keyword);

}
