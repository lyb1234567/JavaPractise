import java.util.Scanner;

public class CustomerView {
    CustomerList customerList=new CustomerList(10);


    public void enterMainMenu()
    {
      boolean isFlag=true;
      while (isFlag)
      {
          System.out.println("-----------------------拼电商客户管理系统-------------------");
          System.out.println("                         1 添加客户");
          System.out.println("                         2 修改客户");
          System.out.println("                         3 删除客户 ");
          System.out.println("                         4 客户列表");
          System.out.println("                         5 退出\n");
          System.out.println("\n");
          System.out.print("                         请选择(1-5):");
          char key=Utility.readCharFromKeyBoard();
          switch (key)
          {
              case '1':
                  addNewCustomer();
                  break;
              case '2':
                  modifyCustomer();
                  break;
              case '3':
                  deleteCustomer();
                  break;
              case '4':
                  listAllCustomers();
                  break;
              case '5':
                  System.out.print("确认是否退出(Y/N):");
                  char isExit=Utility.readConfirmationFromKeyBoard();
                  if(isExit=='Y')
                  {
                      isFlag=false;
                  }
                  break;
          }
      }
    }

    public void addNewCustomer()
    {
        System.out.println("-------------------------添加新客户--------------------");
        System.out.print("姓名：");
        String name=Utility.readStringFromKeyBoard();
        System.out.print("性别：");
        char gender=Utility.readGenderFromKeyBoard();
        System.out.print("年龄：");
        int age=Utility.readInt(3);
        System.out.print("电话：");
        String phone=Utility.readStringFromKeyBoard();
        while (!Utility.isValidPhoneNumber(phone))
        {
            System.out.print("电话格式错误，请重新输入：");
            phone=Utility.readStringFromKeyBoard();
        }
        System.out.print("邮箱：");
        String email=Utility.readStringFromKeyBoard();
        while (!Utility.isValidEmailAddress(email))
        {
            System.out.print("邮箱格式错误，请重新输入：");
            phone=Utility.readStringFromKeyBoard();
        }
        Customer newCustomer=new Customer(name,gender,age,phone,email);
        if(!customerList.addCustomer(newCustomer))
        {
            System.out.println("--------------------客户已满-----------------");
        }
    }
    public void modifyCustomer()
    {
        System.out.println("----------------修改客户------------------------");
        int index=0;
        Customer cust=null;
        for(;;)
        {
            System.out.print("请选择待修改客户编号(-1)退出");
            index=Utility.readInt(1);
            if(index==-1)
            {
                return;
            }
            cust=customerList.getCustomer(index);
            if(cust==null)
            {
                System.out.print("无法找到指定客户！！！");
                return;
            }
            else
            {
                System.out.printf("姓名(%s):",cust.getName());
                String name=Utility.readStringFromKeyBoard();
                System.out.printf("性别(%c)：",cust.getGender());
                char gender=Utility.readGenderFromKeyBoard();
                System.out.printf("年龄(%d)：",cust.getAge());
                int age=Utility.readInt(3);
                System.out.printf("电话(%s)：",cust.getPhone());
                String phone=Utility.readStringFromKeyBoard();
                while (!Utility.isValidPhoneNumber(phone))
                {
                    System.out.print("电话格式错误，请重新输入：");
                    phone=Utility.readStringFromKeyBoard();
                }
                System.out.printf("邮箱(%s)：",cust.getEmail());
                String email=Utility.readStringFromKeyBoard();
                while (!Utility.isValidEmailAddress(email))
                {
                    System.out.print("邮箱格式错误，请重新输入：");
                    phone=Utility.readStringFromKeyBoard();
                }
                Customer newCustomer=new Customer(name,gender,age,phone,email);
                customerList.replaceCustomer(newCustomer,index);
                return ;
            }
        }
    }
    public void deleteCustomer()
    {
        System.out.print("请选择待删除客户编号(-1)退出:");
        int index=Utility.readInt(1);
        if(index==-1)
        {
            return;
        }
        Customer target=customerList.getCustomer(index);
        if (target==null)
        {
            System.out.println("-------------找不到待删除的客户-------------");
            return;
        }
        customerList.deleteCustomer(index);
    }
    public  void listAllCustomers()
    {
        System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱");
        System.out.println("-----------------------客户列表------------------------");
        for(int i=0;i< customerList.getTotal();i++)
        {
            Customer customer=customerList.getCustomer(i);
            System.out.println(i+"\t\t"+customer.getName()+"\t\t"+customer.getGender()+"\t\t"+customer.getAge()+"\t\t"+customer.getPhone()+"\t\t"+customer.getEmail());
        }
        System.out.println("----------------------客户列表完成-----------------------");
    }
}
