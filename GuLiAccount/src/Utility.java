import java.util.Scanner;

public class Utility {
    public static char readCharFromKeyBoard()
    {
        char c;
        for(;;)
        {
                Scanner scanner=new Scanner(System.in);
                c=scanner.nextLine().charAt(0);
                if (c!='1' && c!='2' && c!='3' && c!='4')
                {
                    System.out.print("\n选择错误，请重新输入");
                }
                break;
        }
        return c;
    }
    public static String readDescription()
    {
        System.out.print("请输入描述：");
        String description;
        Scanner scanner=new Scanner(System.in);
        description=scanner.nextLine();
        return description;
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
                System.out.print("\n选择错误，请重新输入");
            }
            break;
        }
        return c;
    }
    public static double readDepositFromKeyBoard() {
        Scanner scanner = new Scanner(System.in);
        double number;

        for (;;) {
            System.out.print("请输入收入：");
            if (scanner.hasNextDouble()) { // 检查输入是否为有效的 double 类型数字
                number = scanner.nextDouble();
                break;  // 有效数字输入，退出循环
            } else {
                System.out.println("这不是一个有效的数字，请重新输入。");
                scanner.next();  // 清除无效输入
            }
        }
        return number;
    }
    public static double readWithdrawFromKeyBoard() {
        Scanner scanner = new Scanner(System.in);
        double number;

        for (;;) {
            System.out.print("请输入支出：");
            if (scanner.hasNextDouble()) { // 检查输入是否为有效的 double 类型数字
                number = scanner.nextDouble();
                break;  // 有效数字输入，退出循环
            } else {
                System.out.println("这不是一个有效的数字，请重新输入。");
                scanner.next();  // 清除无效输入
            }
        }
        return number;
    }
    public static void printTranscationHistory(Account account)
    {
        int count=0;
        System.out.println("收支\t\t账户金额\t\t收支金额\t\t说明");
        for(Transcation transcation: account.getTranscationHistory())
        {
             System.out.println(transcation.getOperation().getDescription()+"\t\t"+transcation.getCurrentNumber()+"\t\t"+transcation.getNumber()+"\t\t"+transcation.getDescription());
        }
    }
}
