package com.NeDonil.VacationCalc.service;

import com.NeDonil.VacationCalc.exception.CalculatorOperandsException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class VacationCalculatorService {
    public double calcSalary(double midSalary, long vacationDays) throws CalculatorOperandsException {
        if(midSalary < 0 || vacationDays < 0){
            throw new CalculatorOperandsException("Operands must be positive numbers");
        }

        double vacationInMonths = vacationDays / 30.0;
        return vacationInMonths * midSalary; // vacation salary
    }

    public double calcSalary(double midSalary,
                             LocalDate vacationBegin,
                             LocalDate vacationEnd) throws CalculatorOperandsException {
        long vacationDays = Duration.between(vacationBegin.atStartOfDay(), vacationEnd.atStartOfDay()).toDays();

        if(midSalary < 0 || vacationDays < 0){
            throw new CalculatorOperandsException("The end of the vacation must be later than the start");
        }

        double vacationInMonths = vacationDays / 30.0;
        return vacationInMonths * midSalary; // vacation salary
    }
}
