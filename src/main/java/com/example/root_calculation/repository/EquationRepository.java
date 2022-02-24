package com.example.root_calculation.repository;

import com.example.root_calculation.model.entity.Equation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquationRepository extends JpaRepository<Equation, Integer> {
    List<Equation> findAll();
}
