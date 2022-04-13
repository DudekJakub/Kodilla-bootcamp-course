package SRP.exerciseEmployee.after_refactored;

public class EmployeeHTMLFormatter {

    public String toHTML(Employee employee) {
        String str = "<div>\n" +
                "<h1>Employee Info</h1>\n" +
                "<div id='emp" + employee.getEmpId() + "'>\n" +
                "<span>" + employee.getName() + "</span>\n" +
                "<div class='left'>\n" +
                "<span>Leaves Left :</span>\n" +
                "<span>Annual salary:</span>\n" +
                "<span>Manager:</span>\n" +
                "<span>Reimbursable leaves:</span>\n" +
                "</div>\n" +
                "<div class='right'><span>" + employee.getLeavesAvailable() + "</span>\n" +
                "<span>" + employee.getYearSalary() + "</span>\n" +
                "<span>" + employee.getTotalLeavesLeftPreviously() + "</span>";
        str += "<span>" + ManagerFormatter(employee.getManager()) + "</span>";

        return str + "</div> </div>";
    }

    private String ManagerFormatter(String manager) {
       return (manager != null) ? manager : "None";
    }
}
