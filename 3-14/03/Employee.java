public abstract class Employee {

    public String name;
    // name = 姓名

    public Employee(String name) {
        this.name = name;
        // 初始化姓名
    }

    public String getName() {
        // getName = 获取姓名

        return name;
    }

    public abstract String getRole();
    // getRole = 获取职位
    // 子类自己决定返回“正社員”还是“パートタイム”

    public abstract int calculateSalary();
    // calculateSalary = 计算工资
}