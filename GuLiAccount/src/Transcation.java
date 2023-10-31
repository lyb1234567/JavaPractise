public class Transcation {
    private Operation operation;
    private double number;
    private String description;

    private double currentNumber;

    public void Transcation()
    {
        this.operation=null;
        this.number=0.0;
        this.description=" ";
        this.currentNumber=0.0;
    }

    public double getNumber() {
        return number;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    public void setCurrentNumber(double amount)
    {
        this.currentNumber=amount;
    }

    public double getCurrentNumber() {
        return currentNumber;
    }
}
