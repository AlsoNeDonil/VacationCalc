package com.NeDonil.VacationCalc.controller;

import com.NeDonil.VacationCalc.service.VacationCalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VacationCalculatorController {

    private final VacationCalculatorService service;

    VacationCalculatorController(VacationCalculatorService service){
        this.service = service;
    }

    @GetMapping("/vacation_calc")
    ResponseEntity calcSalary(@RequestParam(name = "mid_salary", defaultValue = "0.0") double midSalary,
                              @RequestParam(name = "vacation_days", defaultValue = "0") int vacationDays){
        try {
            return ResponseEntity.ok()
                    .body(service.calcSalary(midSalary, vacationDays));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
