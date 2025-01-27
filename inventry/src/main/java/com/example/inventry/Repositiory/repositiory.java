package com.example.inventry.Repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventry.Model.model;
import java.util.List;


public interface repositiory extends JpaRepository<model, Long> {
    List<model> findByName(String name);
}
