package com.example.todolist.entity;

import com.example.todolist.service.ToDoListService;
import com.example.todolist.validator.Unique;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * To-Do list with name (up to 255 chars) and a set of entries
 */
@Entity
@Table(name = "lists")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    @Unique(service = ToDoListService.class, fieldName = "name", message = "Name must be unique")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "list")
    private Set<ToDoEntry> entries;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public ToDoList() {
    }
    
    public ToDoList(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ToDoEntry> getEntries() {
        return entries;
    }
}
