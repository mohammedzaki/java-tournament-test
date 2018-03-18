package com.example.todolist;

import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToDoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class);
    }
    
    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        if (emf.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return emf.unwrap(SessionFactory.class);
    }
}
