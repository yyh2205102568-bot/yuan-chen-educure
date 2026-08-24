public class PartTimeEmployee extends Employee {

    int hourlyWage;
    // hourlyWage = 时薪

    int hoursWorked;
    // hoursWorked = 工作时间

    public PartTimeEmployee(
        String name,
        int hourlyWage,
        int hoursWorked
    ) {

        super(name);

        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getRole() {

        return "パートタイム";
    }

    @Override
    public int calculateSalary() {

        return hourlyWage * hoursWorked;
        // 工资 = 时薪 × 工作时间
    }
}