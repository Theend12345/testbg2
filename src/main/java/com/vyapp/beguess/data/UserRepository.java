package com.vyapp.beguess.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    User findByUsername(String username);

    List<User> findAllByStatus(boolean status);

    @Transactional
    @Modifying
    @Query("update User u set u.status = :status where u.id = :id")
    void updateStatus(@Param(value = "id") long id, @Param(value = "status") boolean status);

    @Transactional
    @Modifying
    @Query("update User u set u.score = :score where u.id = :id")
    void updateScore(@Param(value = "id") long id, @Param(value = "score") long score);

}
