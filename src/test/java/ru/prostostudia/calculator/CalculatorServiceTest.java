package ru.prostostudia.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.prostostudia.calculator.exceptions.DivideByZeroException;
import ru.prostostudia.calculator.exceptions.NotValidParameterException;

import java.util.Random;
import java.util.stream.Stream;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();
    private static final Random RANDOM = new Random();

    @ParameterizedTest
    @MethodSource("parametersNullForBasicServiceTest")
    void getPlus_CalculatingSumNullParameters_ThrowingNotValidParameterException(String message, Integer num1, Integer num2) {
        assertThrows(NotValidParameterException.class, () -> {
            calculatorService.getPlus(num1,num2);
        });
    }

    @ParameterizedTest
    @MethodSource("parametersNullForBasicServiceTest")
    void getMinus_CalculatingDifferenceNullParameters_ThrowingNotValidParameterException(String message, Integer num1, Integer num2) {
        assertThrows(NotValidParameterException.class, () -> {
            calculatorService.getMinus(num1,num2);
        });
    }

    @ParameterizedTest
    @MethodSource("parametersNullForBasicServiceTest")
    void getDivide_CalculatingDivideNullParameters_ThrowingNotValidParameterException(String message, Integer num1, Integer num2) {
        assertThrows(NotValidParameterException.class, () -> {
            calculatorService.getDivide(num1,num2);
        });
    }

    @ParameterizedTest
    @MethodSource("parametersNullForBasicServiceTest")
    void getMultiply_CalculatingMultiplyNullParameters_ThrowingNotValidParameterException(String message, Integer num1, Integer num2) {
        assertThrows(NotValidParameterException.class, () -> {
            calculatorService.getMultiply(num1,num2);
        });
    }

    @Test
    void getDivide_DivideByZeroParameters_ThrowingDivideByZeroException() {
        int num1 = RANDOM.nextInt();
        int num2 = 0;
        assertThrows(DivideByZeroException.class, () -> {
            calculatorService.getDivide(num1,num2);
        });
    }

    @ParameterizedTest
    @MethodSource("parametersPrimitiveForExtendedServiceTest")
    void getPlus_CalculatingSumParameters_ReturningCorrectResult(String message, Integer num1, Integer num2) {
        Integer sum = num1 + num2;
        String expected = String.format("%s + %s = %s",num1,num2,sum);
        String actual = calculatorService.getPlus(num1,num2);
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("parametersPrimitiveForExtendedServiceTest")
    void getMinus_CalculatingDifferenceParameters_ReturningCorrectResult(String message, Integer num1, Integer num2) {
        Integer diff = num1 - num2;
        String expected = String.format("%s - %s = %s",num1,num2,diff);
        String actual = calculatorService.getMinus(num1,num2);
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("parametersPrimitiveForBasicServiceTest")
    void getDivide_CalculatingDifferenceParameters_ReturningCorrectResult(String message, Integer num1, Integer num2) {
        Integer div = num1 / num2;
        String expected = String.format("%s / %s = %s",num1,num2,div);
        String actual = calculatorService.getDivide(num1,num2);
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("parametersPrimitiveForExtendedServiceTest")
    void getMultiply_CalculatingMultiplyParameters_ReturningCorrectResult(String message, Integer num1, Integer num2) {
        Integer multiply = num1 * num2;
        String expected = String.format("%s * %s = %s",num1,num2,multiply);
        String actual = calculatorService.getMultiply(num1,num2);
        assertEquals(actual, expected);
    }


    private static Stream<Arguments> parametersPrimitiveForBasicServiceTest() {
        return Stream.of(Arguments.of("Тест обычных чисел",5,2),
                Arguments.of("Тест отрицательного и положительного числа",-10,5),
                Arguments.of("Тест положительного и отрицательного числа",5,-10),
                Arguments.of("Тест отрицательных чисел",-15,-12)
        );
    }

    private static Stream<Arguments> parametersPrimitiveForExtendedServiceTest() {
        return Stream.concat(parametersPrimitiveForBasicServiceTest(),
                Stream.of(Arguments.of("Тест нулей",0,0)));
    }

    private static Stream<Arguments> parametersNullForBasicServiceTest() {
        return Stream.of(Arguments.of("Первое число null, второе Integer",null, 15 ),
                Arguments.of("Второе число null, первое Integer", RANDOM.nextInt() ,null),
                Arguments.of("Оба числа null",null,null)
        );
    }

}
