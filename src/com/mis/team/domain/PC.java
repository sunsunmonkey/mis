package com.mis.team.domain;

public class PC implements Equipment{
    //    机器名称
    private String model;
    //    机器显示器
    private String display;

    public PC() {
        super();
    }
    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
}
