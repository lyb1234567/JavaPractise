package domain;

public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    protected String getDetails()
    {
        return id+"\t"+formatName(name, 3)+"\t"+age+"\t"+salary;
    }
    @Override
    public String toString() {
        return getDetails();
    }


    public static String formatName(String name, int length) {
        if (name.length() > length) {
            return name.substring(0, length - 1) + "..."; // truncate and add ellipsis
        } else {
            return String.format("%-" + length + "s", name); // left-align and pad with spaces
        }
    }
}
