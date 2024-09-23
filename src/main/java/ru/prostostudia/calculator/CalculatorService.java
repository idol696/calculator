package ru.prostostudia.calculator;

import org.springframework.stereotype.Service;
import ru.prostostudia.calculator.exceptions.DivideByZeroException;
import ru.prostostudia.calculator.exceptions.NotValidParameterException;

@Service
public class CalculatorService implements CalculatorServiceInterface {

    public String getPlus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) throw new NotValidParameterException();
        int sum = num1 + num2;
        return String.format("%s + %s = %s",num1,num2,sum);
    }

    public String getMinus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) throw new NotValidParameterException();
        int diff = num1 - num2;
        return String.format("%s - %s = %s",num1,num2,diff);
    }

    public String getDivide(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) throw new NotValidParameterException();
        int div;
        if (num2 != 0) {
            div = num1 / num2;
        } else {
            throw new DivideByZeroException();
        }
        return String.format("%s / %s = %s",num1,num2,div);
    }

    public String getMultiply(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) throw new NotValidParameterException();
        Integer prod = num1 * num2;
        return String.format("%s * %s = %s",num1,num2,prod);
    }
}