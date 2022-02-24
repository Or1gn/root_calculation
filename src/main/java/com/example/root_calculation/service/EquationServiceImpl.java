package com.example.root_calculation.service;

import com.example.root_calculation.model.RS.DecisionRS;
import com.example.root_calculation.model.RS.EquationRS;
import com.example.root_calculation.model.dto.DecisionDTO;
import com.example.root_calculation.model.dto.EquationDTO;
import com.example.root_calculation.model.entity.Equation;
import com.example.root_calculation.model.enums.Messages;
import com.example.root_calculation.repository.EquationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquationServiceImpl implements EquationService {
    private final EquationRepository equationRepository;

    @Override
    public DecisionRS<DecisionDTO> getDecision(double a, double b, double c) {
        DecisionRS<DecisionDTO> response = new DecisionRS<>();
        double x1, x2;
        double discriminant = b * b - 4 * a * c;
        if (a == 0)
        {
            log.info("a не может быть равно 0");
            response.setMessage(Messages.A_EQUALS_ZERO);
            x1 = 0;
            x2 = 0;
        }
        else if (discriminant > 0) {
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            log.info("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
            saveValues(a, b, c, x1, x2);
            response.setMessage(Messages.SUCCESS);
        } else if (discriminant == 0) {
            x1 = -b / (2 * a);
            x2 = x1;
            log.info("Уравнение имеет единственный корень: x = " + x1);
            saveValues(a, b, c, x1, x2);
            response.setMessage(Messages.SUCCESS);
        } else {
            log.info("Уравнение не имеет действительных корней!");
            x1 = 0;
            x2 = x1;
            response.setMessage(Messages.NO_ROOTS);
        }
        response.setData(getDTO(x1, x2));
        return response;
    }

    @Override
    public EquationRS<List<EquationDTO>> getSolutions() {
        EquationRS<List<EquationDTO>> response = new EquationRS<>();
        List<Equation> equationList = equationRepository.findAll();
        response.setMessage(Messages.SUCCESS);
        response.setData(getEquationDTO(equationList));
        return response;
    }

    private List<EquationDTO> getEquationDTO(List<Equation> equationList)
    {
        return equationList.stream()
            .map(EquationDTO::getEquationDTO)
            .collect(Collectors.toList());
    }

    private void saveValues(double a, double b, double c, double x1, double x2)
    {
        Equation equation = new Equation();
        equation.setA(a);
        equation.setB(b);
        equation.setC(c);
        equation.setX1(x1);
        equation.setX2(x2);
        equationRepository.save(equation);
    }

    private DecisionDTO getDTO(double x1, double x2)
    {
        DecisionDTO decisionDTO = new DecisionDTO();
        decisionDTO.setX1(x1);
        decisionDTO.setX2(x2);
        return decisionDTO;
    }
}
