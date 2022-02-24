package com.example.root_calculation.model.RS;

import com.example.root_calculation.model.dto.EquationDTO;
import com.example.root_calculation.model.enums.Messages;
import lombok.Data;

import java.util.List;

@Data
public class EquationRS<T> {
    private Messages message;
    private List<EquationDTO> data;
}
