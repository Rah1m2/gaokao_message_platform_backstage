package com.gaokao.main.DTO;

/**
 * 对应数据库中的institution_accomodation表
 */
public class Accommodation {
    private String institution_name;
    private String dormitory;
    private String food_standard;

    public Accommodation() {
    }

    public Accommodation(String institution_name, String dormitory, String food_standard) {
        this.institution_name = institution_name;
        this.dormitory = dormitory;
        this.food_standard = food_standard;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getFood_standard() {
        return food_standard;
    }

    public void setFood_standard(String food_standard) {
        this.food_standard = food_standard;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "institution_name='" + institution_name + '\'' +
                ", dormitory='" + dormitory + '\'' +
                ", food_standard='" + food_standard + '\'' +
                '}';
    }
}
