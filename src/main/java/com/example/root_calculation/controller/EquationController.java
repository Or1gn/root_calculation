package com.example.root_calculation.controller;

import com.example.root_calculation.model.RS.DecisionRS;
import com.example.root_calculation.model.RS.EquationRS;
import com.example.root_calculation.model.dto.DecisionDTO;
import com.example.root_calculation.model.dto.EquationDTO;
import com.example.root_calculation.service.EquationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/equation")
public class EquationController {
    private final EquationServiceImpl equationService;

    @PostMapping("/result")
    public ResponseEntity<DecisionRS<DecisionDTO>> getDecision(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam double c){
        return ResponseEntity.ok().body(equationService.getDecision(a, b, c));
    }

    @GetMapping("/result/all")
    public ResponseEntity<EquationRS<List<EquationDTO>>> getSolutions(){
        return ResponseEntity.ok().body(equationService.getSolutions());
    }
}
