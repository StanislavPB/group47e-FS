package lesson_12.code.taxCalculator;

public class TaxCalculator {

    private CurrentYearProvider currentYearProvider;

    public TaxCalculator(CurrentYearProvider currentYearProvider) {
        this.currentYearProvider = currentYearProvider;
    }

    public double calculateTax(double income){
        double taxAmount;

        if (currentYearProvider.getYear() == 2022) {
            taxAmount = income * 0.18;
        } else {
            taxAmount = income * 0.22;
        }

        return taxAmount;
    }
}
