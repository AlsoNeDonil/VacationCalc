package com.NeDonil.VacationCalc.service;

import com.NeDonil.VacationCalc.exception.CalculatorOperandsException;
import org.springframework.stereotype.Service;

@Service
public class VacationCalculatorService {
    public double calcSalary(double midSalary, int vacationDays) throws CalculatorOperandsException {
        if(midSalary < 0 || vacationDays < 0){
            throw new CalculatorOperandsException("Operands must be positive numbers");
        }
        double vacationInMonths = vacationDays / 30.0;
        return vacationInMonths * midSalary; // vacation salary
    }
}
