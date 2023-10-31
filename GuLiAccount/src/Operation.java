public enum Operation {
    DEPOSIT("收入"),
    WITHDRAW("支出");

    private final String description;

    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public static void main(String[] args) {
        for (Operation op : Operation.values()) {
            System.out.println(op.name() + ": " + op.getDescription());
        }
    }
}
