package com.NeDonil.VacationCalc.service;

import org.springframework.stereotype.Service;

@Service
public class VacationCalculatorService {
    public double calcSalary(double midSalary, int vacationDays){
        double vacationInMonths = vacationDays / 30.0;
        return vacationInMonths * midSalary; // vacation salary
    }
}
