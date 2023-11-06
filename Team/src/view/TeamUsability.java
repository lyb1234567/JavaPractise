package view;

import java.util.Scanner;

public class TeamUsability {
    public static char readMenuSelection()
    {
        char key;
        for(;;)
        {
            Scanner scanner=new Scanner(System.in);
            key=scanner.nextLine().charAt(0);
            if (key!='1' && key!='2' && key !='3' && key!='4')
            {
                System.out.print("\n选择错误，请重新输入:");
                continue;
            }
            break;
        }
        return key;
    }

    public static char readConfirmationFromKeyBoard()
    {
        char c;
        for(;;)
        {
            Scanner scanner=new Scanner(System.in);
            c=scanner.nextLine().toUpperCase().charAt(0);
            if (c!='Y' && c!='N')
            {
                System.out.print("\n选择错误，请重新输入:");
                continue;
            }
            break;
        }
        return c;
    }

    public static int readIntFromKeyBoard()
    {
        String s;
        for(;;)
        {
            Scanner scanner=new Scanner(System.in);
            s=scanner.nextLine();
            if (!s.matches("\\d+"))
            {
                System.out.print("\n选择错误，请重新输入:");
                continue;
            }
            break;
        }
        return Integer.parseInt(s);
    }
    public static void reeadReturn()
    {
        Scanner scanner = new Scanner(System.in);
        // 等待用户输入
        scanner.nextLine();  // 读取回车键之前的输入（可能是空的）
    }


}
