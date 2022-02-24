package com.example.root_calculation.model.RS;

import com.example.root_calculation.model.dto.DecisionDTO;
import com.example.root_calculation.model.enums.Messages;
import lombok.Data;

@Data
public class DecisionRS<T>{
    private Messages message;
    private DecisionDTO data;
}
