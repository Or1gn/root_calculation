package com.example.root_calculation.model.dto;

import com.example.root_calculation.model.entity.Equation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquationDTO {
    private double a;

    private double b;

    private double c;

    private double x1;

    private double x2;

    public static EquationDTO getEquationDTO(Equation equation)
    {
        EquationDTO equationDTO = new EquationDTO();
        equationDTO.setA(equation.getA());
        equationDTO.setB(equation.getB());
        equationDTO.setC(equation.getC());
        equationDTO.setX1(equation.getX1());
        equationDTO.setX2(equation.getX2());
        return equationDTO;
    }
}
