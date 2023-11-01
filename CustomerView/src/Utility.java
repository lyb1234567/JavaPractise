import java.util.Scanner;
import java.util.regex.Pattern;

public class Utility {
    public static String readStringFromKeyBoard()
    {
        String str;
        Scanner scanner=new Scanner(System.in);
        str=scanner.nextLine();
        return str;
    }
    public static boolean isValidPhoneNumber(String number) {
        // Basic check: ensure the phone number is only digits and 10 characters long
        return number.length() == 11 && number.matches("\\d+");
    }
    public static boolean isValidEmailAddress(String email)
    {
        return Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email);
    }
    public static char readCharFromKeyBoard()
    {
        char c;
        Scanner scanner=new Scanner(System.in);
        c=scanner.nextLine().charAt(0);
        return c;
    }
    public static int readInt(int limit)
    {
        String intString;
        Scanner scanner=new Scanner(System.in);
        intString=scanner.nextLine();
        if (intString.length()>limit)
        {
            intString=intString.substring(0,limit-1);
        }
        while(!isNumeric(intString))
        {
            System.out.print("输入错误，请重新输入：");
            intString=scanner.nextLine();
        }
        return Integer.parseInt(intString);
    }
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public static char readGenderFromKeyBoard()
    {
        char c;
        for(;;)
        {
            Scanner scanner=new Scanner(System.in);
            c=scanner.nextLine().toUpperCase().charAt(0);
            if (c!='F' && c!='M')
            {
                System.out.print("\n选择错误，请重新输入");
            }
            break;
        }
        return c;
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
}