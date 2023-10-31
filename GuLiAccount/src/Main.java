import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        char readChar;
        char readConfirmation;
        double readNumberDeposit;
        double readNumberWithdraw;
        String description;
        boolean exit=false;
        Account account=new Account();
        System.out.println("-----------------------谷粒记账软件-------------------");
        System.out.println("                         1 收支明细");
        System.out.println("                         2 登记收入");
        System.out.println("                         3 登记支出 ");
        System.out.println("                         4 退出");
        System.out.println("\n");
        System.out.print("                         请选择(1-4):");
        while (true)
        {
            readChar=Utility.readCharFromKeyBoard();
            switch (readChar)
            {
                case '1':
                    System.out.println("---------------------------当前收支明细记录-----------------------");
                    Utility.printTranscationHistory(account);
                    break;
                case '2':
                    readNumberDeposit=Utility.readDepositFromKeyBoard();
                    description=Utility.readDescription();
                    account.deposit(readNumberDeposit,description);
                    break;
                case '3':
                    readNumberWithdraw=Utility.readWithdrawFromKeyBoard();
                    description=Utility.readDescription();
                    account.withdraw(readNumberWithdraw,description);
                    break;
                case '4':
                    System.out.print("\n确认是否退出(Y/N):");
                    readConfirmation=Utility.readConfirmationFromKeyBoard();
                    if (readConfirmation=='Y')
                    {
                        exit=true;
                    }
                    break;
            }
            if (exit)
            {
                break;
            }
            System.out.println("-------------------------------------------------");
            System.out.println("-----------------------谷粒记账软件-------------------");
            System.out.println("                         1 收支明细");
            System.out.println("                         2 登记收入");
            System.out.println("                         3 登记支出 ");
            System.out.println("                         4 退出");
            System.out.println("\n");
            System.out.print("                         请选择(1-4):");
        }
    }

}