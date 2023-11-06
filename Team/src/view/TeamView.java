package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
    private NameListService nameListService=new NameListService();

    private TeamService teamService=new TeamService();

    public void enterMainMenu() throws TeamException {
        boolean loopFlag=true;
        char key=0;
        do {
            if (key!='1')
            {
                listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4): ");
            key=TeamUsability.readMenuSelection();
            System.out.println();
            switch (key)
            {
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char yn=TeamUsability.readConfirmationFromKeyBoard();
                    if (yn=='Y')
                    {
                        loopFlag=false;
                    }
                    break;
            }
        }while(loopFlag);
    }

    private void deleteMember() throws TeamException {
        System.out.println("-----------------------------------删除成员----------------------------");
        System.out.print("请输入要刪除的员工Id:");
        int id=TeamUsability.readIntFromKeyBoard();
        System.out.print("请确认是否删除(Y/N):");
        char yn=TeamUsability.readConfirmationFromKeyBoard();
        if(yn=='N')
        {
            return ;
        }
        try
        {
            teamService.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            throw new TeamException(e.getMessage());
        }
        System.out.println("按下回车键继续..............");
        TeamUsability.reeadReturn();
    }

    private void addMember() throws TeamException {
        System.out.println("-----------------------------------添加成员----------------------------");
        System.out.print("请输入要添加的员工Id:");
        int id=TeamUsability.readIntFromKeyBoard();
        try{
            Employee e= nameListService.getEmployee(id);
            teamService.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            throw new TeamException(e.getMessage());
        }
        System.out.println("按下回车键继续..............");
      TeamUsability.reeadReturn();
    }

    private void listTeam() {
        System.out.println("\n--------------------------------------------------------团队成员表-----------------------------");
        Programmer [] team=teamService.getTeam();
        if(team.length==0)
        {
            System.out.println("开发团队目前没有成员！！");
        }
        else
        {
             System.out.println("TID/ID\t姓名\t\t年龄\t工资\t\t职位\t\t奖金\t\t股票");
        }
        for(int i=0;i<team.length;i++)
        {
           System.out.println(" "+team[i].getDetailsFromTeam());
        }
        System.out.println("按下回车键继续..............");
        TeamUsability.reeadReturn();
    }

    private void listAllEmployees() {
        Employee [] employees=nameListService.getAllEmployees();
        for(int i=0;i<employees.length;i++)
        {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) throws TeamException {
        TeamView teamView=new TeamView();
        teamView.enterMainMenu();
    }

}
