package com.gaokao.main.POJO;

public class Salary {
    private int province_salary_level_id;
    private String major_name;
    private String name;
    private String value;

    public Salary() {
    }

    public Salary(int province_salary_level_id, String major_name, String name, String value) {
        this.province_salary_level_id = province_salary_level_id;
        this.major_name = major_name;
        this.name = name;
        this.value = value;
    }

    public int getProvince_salary_level_id() {
        return province_salary_level_id;
    }

    public void setProvince_salary_level_id(int province_salary_level_id) {
        this.province_salary_level_id = province_salary_level_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "province_salary_level_id=" + province_salary_level_id +
                ", major_name='" + major_name + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
