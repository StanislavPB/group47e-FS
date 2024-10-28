package lesson_12.code.taxCalculator;

import java.time.LocalDateTime;

public class CurrentYearProviderImpl implements CurrentYearProvider{
    @Override
    public int getYear() {
        return LocalDateTime.now().getYear();
    }
}
