package SRP.exerciseEmployee.after_refactored;

public class Employee {
    public static final int LEAVES_ALLOWED = 27;
    private int empId;
    private String name;
    private double monthySalary;
    private String manager;
    private int leavesTaken;
    private int yearsInOrg;
    private int[] leavesLeftPreviously;

    public Employee(int empId, String name, double monthySalary, String manager, int leavesTaken
                    ,int[] leavesLeftPreviously) {

        this.empId = empId;
        this.name = name;
        this.monthySalary = monthySalary;
        this.manager = manager;
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getLeavesAvailable() {
        return LEAVES_ALLOWED - leavesTaken;
    }

    public Long getYearSalary() {
        return Math.round(monthySalary*12);
    }

    public String getManager() {
        return manager;
    }

    public int getTotalLeavesLeftPreviously() {
        int years = (yearsInOrg < 3) ? yearsInOrg : 3;
        int leavesLeft = 0;

        for (int i = 0; i < years; i++) {
            leavesLeft += leavesLeftPreviously[yearsInOrg-i-1];

            //0 + [3-0-1] = 0+[2] = 0 + 5 = 5;
            //0 + [3-1-1] = 0+[1] = 0 + 3 = 3;
            //0 + [3-2-1] = 0+[0] = 0 + 4 = 4;
            //5+3+4=12 //3 ostatnie lata
        }
        return leavesLeft;
    }
}
