package com.example.todolist.repository;

import com.example.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ToDoList, Long> {
    
    boolean existsByName(String name);
    
}
