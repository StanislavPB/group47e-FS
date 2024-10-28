package lesson_12.code.taxCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaxCalculatorTest {

    @Test
    void testTaxCalculator2024(){

        CurrentYearProvider currentYearProvider = new CurrentYearProviderImpl();
        TaxCalculator taxCalculator = new TaxCalculator(currentYearProvider);

        double income = 1000;
        double expectedResult = 220;
        double actualResult = taxCalculator.calculateTax(income);

        assertEquals(expectedResult,actualResult);


    }

    @Test
    void testTaxCalculator2022(){

        //CurrentYearProvider currentYearProvider = new CurrentYearProviderImpl();

        CurrentYearProvider currentYearProvider = mock(CurrentYearProvider.class);
        TaxCalculator taxCalculator = new TaxCalculator(currentYearProvider);

        when(currentYearProvider.getYear()).thenReturn(2022);

        double income = 1000;
        double expectedResult = 180;
        double actualResult = taxCalculator.calculateTax(income);

        assertEquals(expectedResult,actualResult);


    }


}