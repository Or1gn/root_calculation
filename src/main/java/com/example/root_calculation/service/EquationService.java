package com.example.root_calculation.service;

import com.example.root_calculation.model.RS.DecisionRS;
import com.example.root_calculation.model.RS.EquationRS;
import com.example.root_calculation.model.dto.DecisionDTO;
import com.example.root_calculation.model.dto.EquationDTO;

import java.util.List;

public interface EquationService {
    DecisionRS<DecisionDTO> getDecision(double a, double b, double c);
    EquationRS<List<EquationDTO>> getSolutions();
}
