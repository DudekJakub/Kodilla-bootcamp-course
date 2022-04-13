package SRP.exerciseEmployee.after_refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeHTMLFormatterTest {

    @Test
    void toHTML() {
        //Given
        int[] leavesLeftPreviously = new int[] {2,2,2,4};
        Employee employee = new Employee(1,"Jakub",2000, "Krzychu",
                10, leavesLeftPreviously);
        EmployeeHTMLFormatter employeeHTMLFormatter = new EmployeeHTMLFormatter();

        //When
        String result = employeeHTMLFormatter.toHTML(employee);
        String lastFewLettersOfResult = result.substring(result.length()-6);

        //Then
        assertEquals("</div>", lastFewLettersOfResult);
        System.out.println(result);
    }
}