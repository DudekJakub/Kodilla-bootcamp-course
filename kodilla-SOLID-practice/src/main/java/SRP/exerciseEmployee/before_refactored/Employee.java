package SRP.exerciseEmployee.before_refactored;

public class Employee {
    private static final int LEAVES_ALLOWED = 27;
    private int empId;
    private String name;
    private double monthlySalary;
    private String manager;
    private int leavesTaken;
    private int yearsInOrg;
    private int[] _leavesLeftPreviously;


    public Employee(int empId, double monthlySalary, String manager, String name, int leavesTaken,
                    int[] leavesLeftPreviously)
    {
        this.empId = empId;
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.manager = manager;
        this.leavesTaken = leavesTaken;
        _leavesLeftPreviously = leavesLeftPreviously;
        yearsInOrg = leavesLeftPreviously.length;
    }

    public String toHtml()
    {
        String str = "<div>\n" +
                "<h1>Employee Info</h1>\n" +
                "<div id='emp" + empId + "'>\n" +
                "<span>" + name + "</span>\n" +
                "<div class='left'>\n" +
                "<span>Leaves Left :</span>\n" +
                "<span>Annual salary:</span>\n" +
                "<span>Manager:</span>\n" +
                "<span>Reimbursable leaves:</span>\n" +
                "</div>\n";
        str += "<div class='right'><span>" + (LEAVES_ALLOWED - leavesTaken) + "</span>\n";
        str += "<span>" + Math.round(monthlySalary * 12) + "</span>\n";
        if (manager != null) {
            str += "<span>" + manager + "</span>\n";
        } else {
            str += "<span>None</span>\n";
        }
        int years = 3;
        if (yearsInOrg < 3) {
            years = yearsInOrg;
        }
        int leavesLeftPreviously = 0;
        for (int i = 0; i < years; i++) { //zawsze 3 lata, jeśli yearsInOrg >= 3     <- years = 3
            leavesLeftPreviously += _leavesLeftPreviously[yearsInOrg - i - 1];
        }
        str += "<span>" + leavesLeftPreviously + "</span>\n";
        return str + "</div> </div>";
    }

    public static void main(String[] args) {
        int[] leavesLeftPreviously = new int[] {4, 3, 5, 6, 7, 8};
        Employee employee = new Employee(1,2000,"Krzychu","Jakub", 10, leavesLeftPreviously);
        System.out.println(employee.toHtml());
    }
}
