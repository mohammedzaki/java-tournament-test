/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todolist.service;

import com.example.todolist.repository.ListRepository;
import com.example.todolist.validator.FieldValueExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * @author Mohammed Zaki mohammedzaki.dev@gmail.com
 */
@Service
public class ToDoListService implements FieldValueExists { 
    
    @Autowired
    private ListRepository listRepository;

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName, "fieldName must provided");

        if (!fieldName.equals("name")) {
            throw new UnsupportedOperationException("Field name not supported");
        }

        if (value == null) {
            return false;
        }

        return this.listRepository.existsByName(value.toString());
    }
}
