package domain;

public class PC implements Equipment{
    private String model;//机器型号
    private String display;//显示器名称
    @Override
    public String getDescription() {
        return model+"("+display+")";
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public String getDisplay() {
        return display;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDisplay(String display) {
        this.display = display;
    }


}
