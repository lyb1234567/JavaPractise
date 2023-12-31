package domain;

public class Designer extends Programmer{

    private double bonus;

    public Designer(int id, String name, int age, double salary,Equipment equipment,double bonus) {
        super(id, name, age, salary,equipment);
        this.bonus=bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString() {
        return getDetails()+"\t设计师\t"+getStatus()+"\t"+getBonus()+"\t\t\t"+getEquipment().getDescription();
    }

    protected String getBasicDetailForTeam()
    {
        return memberId+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t";
    }
    public String getDetailsFromTeam()
    {
        return getBasicDetailForTeam()+"设计师\t"+getBonus();
    }
}
