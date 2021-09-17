package com.gaokao.main.POJO;

public class ChargingItem {
    private String institution_name;
    private String charging_item;

    public ChargingItem() {
    }

    public ChargingItem(String institution_name, String charging_item) {
        this.institution_name = institution_name;
        this.charging_item = charging_item;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getCharging_item() {
        return charging_item;
    }

    public void setCharging_item(String charging_item) {
        this.charging_item = charging_item;
    }

    @Override
    public String toString() {
        return "ChargingItem{" +
                "institution_name='" + institution_name + '\'' +
                ", charging_item='" + charging_item + '\'' +
                '}';
    }
}
