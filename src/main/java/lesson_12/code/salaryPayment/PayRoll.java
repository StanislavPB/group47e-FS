package lesson_12.code.salaryPayment;

import java.util.List;

public class PayRoll {

    private EmployeeDB employeeDB;

    private BankService bankService;

    public PayRoll(EmployeeDB employeeDB, BankService bankService) {
        this.employeeDB = employeeDB;
        this.bankService = bankService;
    }

    public int monthlyPayment(){

        List<Employee> employees = employeeDB.getAllEmployees();

        for (Employee employee : employees){
            bankService.makePayment(employee.getBankId(), employee.getSalary());
        }

        return employees.size();
    }
}
