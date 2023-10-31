import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
    private double balance;
    private final List<Transcation>transcationHistory;

    public Account()
    {
        this.balance=0.0;
        this.transcationHistory=new ArrayList<>();
    }
    public void deposit(double amount,String description)
    {
        if (amount<=0)
        {
            System.out.println("存款金额必须大于0!");
            return;
        }
        else
        {
            Transcation transcation=new Transcation();
            this.balance+=amount;
            transcation.setNumber(amount);
            transcation.setOperation(Operation.DEPOSIT);
            transcation.setDescription(description);
            transcation.setCurrentNumber(this.balance);
            transcationHistory.add(transcation);
            return;
        }
    }

    public void withdraw(double amount,String description)
    {
        if (amount<=0)
        {
            System.out.println("取款金额必须大于0!");
            return;
        }
        if (amount > balance) {
            System.out.println("余额不足!");
            return;
        }
        else
        {
            this.balance -= amount;
            Transcation transcation=new Transcation();
            transcation.setNumber(amount);
            transcation.setOperation(Operation.DEPOSIT);
            transcation.setDescription(description);
            transcation.setCurrentNumber(this.balance);
            transcationHistory.add(transcation);
            return;
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<Transcation> getTranscationHistory() {
        return transcationHistory;
    }
}
