package com.gamecodeschool.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {
//each conversion has its own test with an input of 10, the expected value, and the method to get the result
    @Test
    public void testKilogramsToPoundsConversion() { //kg to lbs conversion test
        double inputValue = 10.0; //value
        double expectedOutput = 22.0462; //expected result
        double result = convertUnits(inputValue, "Kilograms to Pounds"); //perform conversion method
        assertEquals(expectedOutput, result, 0.001);
    }

    @Test
    public void testPoundsToKilogramsConversion() { //lbs to kg unit test
        double inputValue = 10.0; //value
        double expectedOutput = 4.53592; //expected result
        double result = convertUnits(inputValue, "Pounds to Kilograms"); //perform method
        assertEquals(expectedOutput, result, 0.001);
    }

    @Test
    public void testFahrenheitToCelsiusConversion() {
        double inputValue = 10.0;
        double expectedOutput = -12.2222;
        double result = convertUnits(inputValue, "Fahrenheit to Celsius");
        assertEquals(expectedOutput, result, 0.001);
    }

    @Test
    public void testCelsiusToFahrenheitConversion() {
        double inputValue = 10.0;
        double expectedOutput = 50.0;
        double result = convertUnits(inputValue, "Celsius to Fahrenheit");
        assertEquals(expectedOutput, result, 0.001);
    }

    @Test
    public void testFeetToMetersConversion() {
        double inputValue = 10.0;
        double expectedOutput = 3.048;
        double result = convertUnits(inputValue, "Feet to Meters");
        assertEquals(expectedOutput, result, 0.001);
    }

    @Test
    public void testMetersToFeetConversion() {
        double inputValue = 10.0;
        double expectedOutput = 32.8084;
        double result = convertUnits(inputValue, "Meters to Feet");
        assertEquals(expectedOutput, result, 0.001);
    }

//same method as in main activity to test all 6 conversions
    private double convertUnits(double input, String selectedOption) {
        double result = 0;

        switch (selectedOption) {
            case "Kilograms to Pounds":
                result = input * 2.20462;
                break;
            case "Pounds to Kilograms":
                result = input / 2.20462;
                break;
            case "Fahrenheit to Celsius":
                result = (input - 32) * 5 / 9;
                break;
            case "Celsius to Fahrenheit":
                result = (input * 9 / 5) + 32;
                break;
            case "Feet to Meters":
                result = input * 0.3048;
                break;
            case "Meters to Feet":
                result = input / 0.3048;
                break;
        }

        return result;
    }
}
