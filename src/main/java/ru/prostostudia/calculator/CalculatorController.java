package ru.prostostudia.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/calculator")
public class CalculatorController {
    private final CalculatorServiceInterface calculatorService;

    public CalculatorController(CalculatorServiceInterface calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = "/plus")
    public String calculatorPrintPlus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.getPlus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String calculatorPrintMinus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.getMinus(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String calculatorPrintDivide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.getDivide(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String calculatorPrintMultiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.getMultiply(num1, num2);
    }
}
