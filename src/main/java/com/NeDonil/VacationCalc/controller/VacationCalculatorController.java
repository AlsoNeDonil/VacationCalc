package com.NeDonil.VacationCalc.controller;

import com.NeDonil.VacationCalc.service.VacationCalculatorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@RequestMapping("/vacation_calc")
@Controller
public class VacationCalculatorController {

    private final VacationCalculatorService service;

    VacationCalculatorController(VacationCalculatorService service){
        this.service = service;
    }

    @GetMapping("/days")
    ResponseEntity calcSalaryByDayCount(@RequestParam(name = "mid_salary", defaultValue = "0.0") double midSalary,
                              @RequestParam(name = "vacation_days", defaultValue = "0") long vacationDays){
        try {
            return ResponseEntity.ok()
                    .body(service.calcSalary(midSalary, vacationDays));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/dates")
    ResponseEntity calcSalaryByDates(@RequestParam(name = "mid_salary", defaultValue = "0.0") double midSalary,
                              @RequestParam(name = "vacation_begin")
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate vacationBegin,
                              @RequestParam(name = "vacation_end")
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate vacationEnd){
        try {
            return ResponseEntity.ok()
                    .body(service.calcSalary(midSalary, vacationBegin, vacationEnd));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
