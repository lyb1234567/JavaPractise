package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {
    private static int counter=1;
    private final int MAX_MEMBER=5;

    private Programmer[]team=new Programmer[MAX_MEMBER];

    private int total;

    public Programmer[] getTeam()
    {
        Programmer [] team=new Programmer[total];
        for(int i=0;i<team.length;i++)
        {
            team[i]=this.team[i];
        }
        return team;
    }
    public void addMember(Employee e) throws TeamException {
       if(total>MAX_MEMBER)
       {
           throw new TeamException("成员已满，无法添加");
       }
       if (!(e instanceof Programmer))
       {
           throw new TeamException("该成员不是开发人员，无法添加");
       }
       Programmer p=(Programmer) e;
       System.out.println(p.getStatus());
       Status status=p.getStatus();
       switch (status)
       {
           case BUSY:
               throw new TeamException("该员工已是某团队成员");
           case VOCATION:
               throw new TeamException("该员工正在休假，无法添加");
       }
       boolean isExist=isExist(p);
       if (isExist)
       {
           throw new TeamException("该员工已经存在团队中");
       }
       int ProgNum=0;
       int DesignNum=0;
       int ArchNum=0;
       for(int i=0;i<team.length;i++)
       {
           if(team[i] instanceof Architect)
           {
              ArchNum++;
           }
           else if(team[i] instanceof Designer)
           {
               DesignNum++;
           }
           else
           {
               ProgNum++;
           }
       }

       if (p instanceof Architect)
       {
           if (ArchNum>=1)
           {
               throw  new TeamException("团队中最多有一名架构师");

           }
       }

       if (p instanceof Designer)
       {
           if( DesignNum>=2)
           {
               throw new TeamException("团队中最多有一名设计师");
           }
       }

       if (p instanceof Programmer)
       {
           if(ProgNum>=3)
           {
               new TeamException("团队中最多有三名程序员");
           }
       }
//       可以添加
        team[total++]=p;
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
    }

//    检查团队中是否有已经有特定的开发人员
    private boolean isExist(Programmer p) {

        for(int i=0;i<team.length;i++)
        {
            if (team[i]!=null)
            {
                if (team[i].getId()==p.getId())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {

        int i;
        for(i=0;i<team.length;i++)
        {
            if (memberId==team[i].getMemberId())
            {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i==0)
        {
            throw new TeamException("没有找到该员工Id");
        }
        for(int j=i;j<total-1;j++)
        {
            team[j]=team[j+1];
        }
        team[total-1]=null;
        total--;
    }
}
