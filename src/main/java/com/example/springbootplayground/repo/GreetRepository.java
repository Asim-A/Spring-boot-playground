package com.example.springbootplayground.repo;

import com.example.springbootplayground.models.Greet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetRepository extends JpaRepository<Greet, Long> {



}
