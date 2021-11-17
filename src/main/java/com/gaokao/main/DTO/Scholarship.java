package com.gaokao.main.DTO;

public class Scholarship {
    private String scholarship_name;
    private String scholarship;
    private String poverty_support;

    public Scholarship() {
    }

    public Scholarship(String scholarship_name, String scholarship, String poverty_support) {
        this.scholarship_name = scholarship_name;
        this.scholarship = scholarship;
        this.poverty_support = poverty_support;
    }

    public String getScholarship_name() {
        return scholarship_name;
    }

    public void setScholarship_name(String scholarship_name) {
        this.scholarship_name = scholarship_name;
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public String getPoverty_support() {
        return poverty_support;
    }

    public void setPoverty_support(String poverty_support) {
        this.poverty_support = poverty_support;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "scholarship_name='" + scholarship_name + '\'' +
                ", scholarship='" + scholarship + '\'' +
                ", poverty_support='" + poverty_support + '\'' +
                '}';
    }
}
