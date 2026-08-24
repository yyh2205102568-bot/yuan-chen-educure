public class RegularEmployee extends Employee {

    int baseSalary;
    // baseSalary = 基本工资

    public RegularEmployee(String name, int baseSalary) {

        super(name);
        // super = 调用父类Employee的构造方法
        // 把name交给Employee处理

        this.baseSalary = baseSalary;
    }

    @Override
    public String getRole() {

        return "正社員";
    }

    @Override
    public int calculateSalary() {

        return baseSalary;
        // 正式员工工资直接返回基本工资
    }
}