package service;

import domain.*;

public class NameListService {
    private Employee[] employees;


    public NameListService()
    {
        employees=new Employee[Data.EMPLOYEES.length];
        for(int i=0;i<employees.length;i++)
        {
            int type=Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id=Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name=Data.EMPLOYEES[i][2];
            int age=Integer.parseInt(Data.EMPLOYEES[i][3]);
            int salary=Integer.parseInt(Data.EMPLOYEES[i][4]);
            double bonus;
            Equipment equipment;
            int stock;
            switch (type)
            {
                case Data.EMPLOYEE:
                    employees[i]=new Employee(id,name,age,salary);
                    break;

                case Data.PROGRAMMER:
                    equipment=createEquipment(i);
                    employees[i]=new Programmer(id,name,age,salary,equipment);
                    break;

                case Data.ARCHITECT:
                    equipment=createEquipment(i);
                    bonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
                    salary=Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i]=new Architect(id,name,age,salary,equipment,bonus,salary);
                    break;

                case Data.DESIGNER:
                    equipment=createEquipment(i);
                    bonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i]=new Designer(id,name,age,salary,equipment,bonus);
                    break;
            }
        }
    }
    public Equipment createEquipment(int index)
    {
        int EquipmentType=Integer.parseInt(Data.EQUIPMENTS[index][0]);
        switch (EquipmentType)
        {
            case Data.PC:
                String model=Data.EQUIPMENTS[index][1];
                String display=Data.EQUIPMENTS[index][2];
                return new PC(model,display);
            case Data.PRINTER:
                String name=Data.EQUIPMENTS[index][1];
                String type=Data.EQUIPMENTS[index][2];
                return new Printer(name,type);
            case Data.NOTEBOOK:
                String model_ =Data.EQUIPMENTS[index][1];
                double price=Integer.parseInt(Data.EQUIPMENTS[index][2]);
                return new NoteBook(model_,price);
        }
        return null;
    }
    public Employee [] getAllEmployees()
    {
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException {
        for(int i=0;i<employees.length;i++)
        {
            if(id==employees[i].getId())
            {
                return employees[i];
            }
        }
        throw new TeamException("没有找到指定Employee id");
    }
}
